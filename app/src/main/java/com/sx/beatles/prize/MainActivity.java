package com.sx.beatles.prize;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.sx.beatles.prize.adapter.MainFragmentViewPagerAdapter;
import com.sx.beatles.prize.databinding.ActivityMainBinding;
import com.sx.beatles.prize.fragment.HomeFragment;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mMainBinding;
    private ViewPager mViewPager;
    private MainFragmentViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());

        mAdapter = new MainFragmentViewPagerAdapter(getSupportFragmentManager(),fragments);

        mViewPager.setAdapter(mAdapter);
    }

    private void initView() {
        mViewPager = mMainBinding.viewPager;
    }
}
