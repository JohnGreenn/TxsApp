package com.hpkj.txsapp.other;

import android.util.Base64;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 描述：
 * fileName：com.hpkj.sheplive.utils
 * author：GLQ
 * time：2020/05/28 15:04
 */
public class EncryptUtil {
    /**
     * UID PassWord
     */
    public static final int UidPassWord = 10086;
    /**
     * TimePassWord
     */
    public static final long TimePassWord = 2649895571L;

    /**
     * Function Entry Point
     */
    public static void main(String[] args) {
        String requestId = getRequestId(1);
        System.out.println(requestId);
    }

    /**
     * Get RequestId
     *
     * @param uid LoginUserId
     */
    public static String getRequestId(int uid) {
        //1.XOR uid
        int xorUid = uid ^ UidPassWord;
        //2.Convert UID To Bytes
        byte[] byteUid = intToByte(xorUid);
        //3.Get TimeSpan
        long time = System.currentTimeMillis();
        //4.Xor TimeSpan
        long xorTime = time ^ TimePassWord;
        //5.Convert TimeSpan
        byte[] byteTime = longToBytes(xorTime);
        //6.Join MD5 String
        StringBuilder sbRequest = new StringBuilder();
        //6.1 append not xor uid
        sbRequest.append(uid);
        //6.2 append time span 0,7,4,9,8 Bit
        String strTime = String.valueOf(time);
        sbRequest.append(strTime.charAt(0));
        sbRequest.append(strTime.charAt(7));
        sbRequest.append(strTime.charAt(4));
        sbRequest.append(strTime.charAt(9));
        sbRequest.append(strTime.charAt(8));
        //6.3 append "shepintang"
        sbRequest.append("shepintang");
        //7. Get Md5 String
        String md5String = MD5_16(sbRequest.toString());
        //8.Join RequestId
        byte[] byteRequest = new byte[28];
        //8.1 frist 4 byte is uid
        System.arraycopy(byteUid,0,byteRequest,0,4);
        //8.2 next 16 byte is MD5 String
        System.arraycopy(md5String.getBytes(StandardCharsets.UTF_8),0,byteRequest,4,16);
        //8.3 last 8 byte is time
        System.arraycopy(byteTime,0,byteRequest,20,8);
        //9. Base64String
        String requestId = getBase64(byteRequest);
        return requestId;
    }

    /**
     * Convert int2Bytes
     */
    public static byte[] intToByte(int val) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (val >> 24);
        bytes[1] = (byte) (val >> 16);
        bytes[2] = (byte) (val >> 8);
        bytes[3] = (byte) val;
        return bytes;
    }

    /**
     * Convert long2Bytes
     */
    public static byte[] longToBytes(long val) {
        byte[] byteArray = new byte[8];
        byteArray[0] = (byte) (val >> 56);
        byteArray[1] = (byte) (val >> 48);
        byteArray[2] = (byte) (val >> 40);
        byteArray[3] = (byte) (val >> 32);
        byteArray[4] = (byte) (val >> 24);
        byteArray[5] = (byte) (val >> 16);
        byteArray[6] = (byte) (val >> 8);
        byteArray[7] = (byte) (val >> 0);
        return byteArray;
    }

    /**
     * Get MD5 String 16
     *
     * @param sourceStr
     * @return
     */
    public static String MD5_16(String sourceStr) {
        String md5 = MD5_32(sourceStr).substring(8,24);
        return md5;
    }

    /**
     * Get MD5 String 32
     *
     * @param sourceStr
     * @return
     */
    public static String MD5_32(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte[] b = md.digest();
            int i;
            StringBuffer buf = new StringBuffer();
            for(int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if(i < 0)
                    i += 256;
                if(i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch(NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

    /**
     * Get Base64 String
     */
    public static String getBase64(byte[] dataBytes) {
        //return  new sun.misc.BASE64Encoder().encode(dataBytes);
        return Base64.encodeToString(dataBytes,Base64.DEFAULT);
    }

}
