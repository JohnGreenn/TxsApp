package com.hpkj.txsapp.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hpkj.txsapp.R;
import com.hpkj.txsapp.app.AppActivity;
import com.hpkj.txsapp.app.AppFragment;
import com.hpkj.txsapp.base.FragmentPagerAdapter;
import com.hpkj.txsapp.databinding.ActivityMainBinding;
import com.hpkj.txsapp.manager.ActivityManager;
import com.hpkj.txsapp.other.DoubleClickHelper;
import com.hpkj.txsapp.other.IntentKey;
import com.hpkj.txsapp.ui.fragment.CartFragment;
import com.hpkj.txsapp.ui.fragment.CategoryFragment;
import com.hpkj.txsapp.ui.fragment.FindFragment;
import com.hpkj.txsapp.ui.fragment.HomeFragment;
import com.hpkj.txsapp.ui.fragment.MessageFragment;
import com.hpkj.txsapp.ui.fragment.MyFragment;


/**
 *    author : glq
 *    desc   : 首页界面
 */
public final class MainActivity extends AppActivity<ActivityMainBinding>
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;

    private FragmentPagerAdapter<AppFragment<?,?>> mPagerAdapter;

    public static void start(Context context) {
        start(context, HomeFragment.class);
    }

    public static void start(Context context, Class<? extends AppFragment<?,?>> fragmentClass) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(IntentKey.INDEX, fragmentClass);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    /*@Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }*/

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mViewPager = findViewById(R.id.vp_home_pager);
        mBottomNavigationView = findViewById(R.id.bv_home_navigation);

        // 不使用图标默认变色
        mBottomNavigationView.setItemIconTintList(null);
        // 设置导航栏条目点击事件
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);

        // 屏蔽底部导航栏长按文本提示
        Menu menu = mBottomNavigationView.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            mBottomNavigationView.findViewById(menu.getItem(i).getItemId()).setOnLongClickListener(v -> true);
        }
    }

    @Override
    protected void initData() {
        mPagerAdapter = new FragmentPagerAdapter<>(this);
        mPagerAdapter.addFragment(HomeFragment.newInstance());
        mPagerAdapter.addFragment(CategoryFragment.newInstance());
        mPagerAdapter.addFragment(CartFragment.newInstance());
        mPagerAdapter.addFragment(MyFragment.newInstance());

        mViewPager.setAdapter(mPagerAdapter);

        onNewIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int fragmentIndex = mPagerAdapter.getFragmentIndex(getSerializable(IntentKey.INDEX));
        if (fragmentIndex == -1) {
            return;
        }

        mViewPager.setCurrentItem(fragmentIndex);
        switch (fragmentIndex) {
            case 0:
                mBottomNavigationView.setSelectedItemId(R.id.menu_home);
                break;
            case 1:
                mBottomNavigationView.setSelectedItemId(R.id.home_found);
                break;
            case 2:
                mBottomNavigationView.setSelectedItemId(R.id.home_message);
                break;
            case 3:
                mBottomNavigationView.setSelectedItemId(R.id.home_me);
                break;
            default:
                break;
        }
    }

    /**
     * {@link BottomNavigationView.OnNavigationItemSelectedListener}
     */

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_home) {
            mViewPager.setCurrentItem(0);
            return true;
        } else if (itemId == R.id.home_found) {
            mViewPager.setCurrentItem(1);
            return true;
        } else if (itemId == R.id.home_message) {
            mViewPager.setCurrentItem(2);
            return true;
        } else if (itemId == R.id.home_me) {
            mViewPager.setCurrentItem(3);
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (!DoubleClickHelper.isOnDoubleClick()) {
            toast(R.string.home_exit_hint);
            return;
        }

        // 移动到上一个任务栈，避免侧滑引起的不良反应
        moveTaskToBack(false);
        postDelayed(() -> {
            // 进行内存优化，销毁掉所有的界面
            ActivityManager.getInstance().finishAllActivities();
            // 销毁进程（注意：调用此 API 可能导致当前 Activity onDestroy 方法无法正常回调）
            // System.exit(0);
        }, 300);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewPager.setAdapter(null);
        mBottomNavigationView.setOnNavigationItemSelectedListener(null);
    }
}