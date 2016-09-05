package com.tengke.android;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.tengke.android.base.ui.BaseActivity;
import com.tengke.android.base.ui.BaseFragment;
import com.tengke.android.interfaces.IReLoad;
import com.tengke.android.interfaces.ITabBarShowListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    public static final String EXTRA_INIT_PAGE_ID = "init_page_id";

    @BindView(R.id.main_btn_nav_main) TextView nav_main;
    @BindView(R.id.main_btn_nav_order) TextView nav_order;
    @BindView(R.id.main_btn_nav_user) TextView nav_user;
    @BindView(R.id.main_ll_nav) View mainTabBar;
    @BindView(R.id.main_ll_bg_view) View mainTabBgView;

    private int currentPosition = -1;
    private BaseFragment currentFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        nav_main.setOnClickListener(onClickListener);
        nav_order.setOnClickListener(onClickListener);
        nav_user.setOnClickListener(onClickListener);

        initBottomNav();

        int firstPage = (savedInstanceState == null) ?
                getIntent() == null ? 0 : getIntent().getIntExtra(EXTRA_INIT_PAGE_ID, HomeFragment.PAGE_POSITION) :
                savedInstanceState.getInt(EXTRA_INIT_PAGE_ID);
        gotoPage(firstPage, null, true);
    }

    private void initBottomNav() {
        nav_main.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tabbar_icon_home, 0, 0);
        nav_main.setTextColor(getResources().getColor(R.color.color_99ffffff));
        nav_order.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tabbar_icon_circle, 0, 0);
        nav_order.setTextColor(getResources().getColor(R.color.color_99ffffff));
        nav_user.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tabbar_icon_profile, 0, 0);
        nav_user.setTextColor(getResources().getColor(R.color.color_99ffffff));
    }

    /**
     * 跳转到该页面,如果是当前页则刷新
     *
     * @param pageId
     * @param bundle
     * @param isInit
     */
    private void gotoPage(int pageId, Bundle bundle, boolean isInit) {
        if (pageId > 3 || pageId < 0) {
            pageId = 0;
        }
        if (currentPosition == pageId && currentFragment != null) {//分发点击事件
            if (currentFragment instanceof IReLoad) {
                ((IReLoad) currentFragment).onReLoad();
            }
            return;
        }

        BaseFragment bf = null;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (isInit) {//remove old info
            for (int i = 0; i < 3; i++) {
                BaseFragment temp = (BaseFragment) getSupportFragmentManager().findFragmentByTag(String.valueOf(i));

                if (temp != null) {
                    if (pageId != i) {
                        transaction.hide(temp);
                    } else {
                        bf = temp;
                    }
                }
            }
        } else if (bf == null) {// 查询缓存
            bf = (BaseFragment) getSupportFragmentManager().findFragmentByTag(String.valueOf(pageId));
        }

        if (currentFragment != null) {//隐藏上个页面
            transaction.hide(currentFragment);
        }

        if (bf != null) {//显示已存在的新页面
            transaction.show(bf);
        } else {//添加不存在的新页面
            switch (pageId) {
                case HomeFragment.PAGE_POSITION:
                    bf = HomeFragment.newInstance(bundle);
                    break;
                case OrderListFragment.PAGE_POSITION:
                    bf = OrderListFragment.newInstance(bundle);
                    break;
                case UserFragment.PAGE_POSITION:
                    bf = UserFragment.newInstance(bundle);
                    break;
            }
            transaction.add(R.id.main_fl_content, bf, String.valueOf(pageId));
        }
        transaction.commitAllowingStateLoss();
        currentFragment = bf;
        refreshNavBtn(currentPosition, pageId);
        currentPosition = pageId;
    }

    private void refreshNavBtn(int curPos, int newPos) {
        if (curPos >= 0) {
            switch (curPos) {
                case 0: {
                    nav_main.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tabbar_icon_home, 0, 0);
                    nav_main.setTextColor(getResources().getColor(R.color.color_99ffffff));
                }
                break;
                case 1: {
                    nav_order.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tabbar_icon_circle, 0, 0);
                    nav_order.setTextColor(getResources().getColor(R.color.color_99ffffff));
                }
                break;
                case 2: {
                    nav_user.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tabbar_icon_profile, 0, 0);
                    nav_user.setTextColor(getResources().getColor(R.color.color_99ffffff));
                }
                break;
            }
        }
        switch (newPos) {
            case 0: {
                nav_main.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tabbar_icon_home, 0, 0);
                nav_main.setTextColor(getResources().getColor(R.color.color_7575ff));
            }
            break;
            case 1: {
                nav_order.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tabbar_icon_circle, 0, 0);
                nav_order.setTextColor(getResources().getColor(R.color.color_7575ff));
            }
            break;
            case 2: {
                nav_user.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tabbar_icon_profile, 0, 0);
                nav_user.setTextColor(getResources().getColor(R.color.color_7575ff));
            }
            break;
        }
    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.main_btn_nav_main:
                    gotoPage(HomeFragment.PAGE_POSITION, null, false);
                    break;
                case R.id.main_btn_nav_order:
                    gotoPage(OrderListFragment.PAGE_POSITION, null, false);
                    break;
                case R.id.main_btn_nav_user:
                    gotoPage(UserFragment.PAGE_POSITION, null, false);
                    break;
            }
        }
    };

    public ITabBarShowListener tabBarShowListener = new ITabBarShowListener() {
        @Override
        public void showTabBar() {

        }

        @Override
        public void hideTabBar() {

        }
    };

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putInt(EXTRA_INIT_PAGE_ID, currentPosition);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < 4; i++) {
            BaseFragment temp = (BaseFragment) getSupportFragmentManager().findFragmentByTag(String.valueOf(i));
            if (temp != null) {
                if (currentPosition != i && i != HomeFragment.PAGE_POSITION) {
                    transaction.remove(temp);
                }
            }
        }
        transaction.commitAllowingStateLoss();
        super.onSaveInstanceState(outState);
    }


}
