package com.sx.beatles.prize.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sx.beatles.prize.util.AsyncTaskUtil;

/**
 * Created by 施行 on 2017/8/1.
 */

public abstract class BaseFragment extends Fragment{

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(setContentView(),null);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(mView);
        loadData();
    }

    protected abstract int setContentView();
    protected abstract void initView(View view);
    protected abstract void loadData();

    public <T> void doAsync(final AsyncTaskUtil.CallPre<T> callPre, final AsyncTaskUtil.CallDoInBackground<T>  callDoInBackground, final
    AsyncTaskUtil.CallPost<T>  callPost){
        AsyncTaskUtil.doAsync(callPre,callDoInBackground,callPost);
    }
}
