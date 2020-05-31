package com.zh.prject_zhulong;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zh.prject_zhulong.fragment.CurriculumFragment;
import com.zh.prject_zhulong.fragment.DataFragment;
import com.zh.prject_zhulong.fragment.HomePageFragment;
import com.zh.prject_zhulong.fragment.MyFragment;
import com.zh.prject_zhulong.fragment.VIPFragment;
import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        initData();
    }

    private void initData() {
        final List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomePageFragment());
        fragmentList.add(new CurriculumFragment());
        fragmentList.add(new VIPFragment());
        fragmentList.add(new DataFragment());
        fragmentList.add(new MyFragment());

        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

        tabLayout.setupWithViewPager(viewpager);
        tabLayout.getTabAt(0).setCustomView(getTabView(R.drawable.homepage_item,"主页"));
        tabLayout.getTabAt(1).setCustomView(getTabView(R.drawable.curriculum_item,"课程"));
        tabLayout.getTabAt(2).setCustomView(getTabView(R.drawable.vip_item,"VIP"));
        tabLayout.getTabAt(3).setCustomView(getTabView(R.drawable.data_item,"资料"));
        tabLayout.getTabAt(4).setCustomView(getTabView(R.drawable.my_item,"我的"));

    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.setSelectedTabIndicatorHeight(0);
    }

    private View getTabView(int image,String title){
        View tabView = LayoutInflater.from(this).inflate(R.layout.tab_item, null);
        ImageView tab_item_image = tabView.findViewById(R.id.tab_item_image);
        TextView tab_item_title = tabView.findViewById(R.id.tab_item_title);
        tab_item_image.setBackgroundResource(image);
        tab_item_title.setText(title);
        return tabView;
    }
}
