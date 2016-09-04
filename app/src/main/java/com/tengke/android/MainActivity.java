package com.tengke.android;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tengke.android.base.ui.BaseActivity;
import com.tengke.android.base.ui.BaseFragment;
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
    private BaseFragment currentFragemnt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        initBottomNav();

    }

    private void initBottomNav() {
        nav_main.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tabbar_icon_home, 0, 0);
        nav_main.setTextColor(getResources().getColor(R.color.color_99ffffff));
        nav_order.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tabbar_icon_circle, 0, 0);
        nav_order.setTextColor(getResources().getColor(R.color.color_99ffffff));
        nav_user.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.tabbar_icon_profile, 0, 0);
        nav_user.setTextColor(getResources().getColor(R.color.color_99ffffff));
    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

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

}
