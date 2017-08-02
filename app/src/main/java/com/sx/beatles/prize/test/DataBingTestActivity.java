package com.sx.beatles.prize.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sx.beatles.prize.R;
import com.sx.beatles.prize.databinding.ActDatabingTestBinding;
import com.sx.beatles.prize.test.bean.User;

/**
 * Created by 施行 on 2017/7/30.
 * 将视图和model绑在了一起，你只需要修改Mode层的值，对应的View层就会监听到自动修改自身。
 */

public class DataBingTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActDatabingTestBinding binding = DataBindingUtil.setContentView(this, R.layout.act_databing_test);
        User user = new User("唐毅","28");
        binding.setUser(user);
    }
}
