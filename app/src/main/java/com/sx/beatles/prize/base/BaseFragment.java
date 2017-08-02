package com.sx.beatles.prize.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sx.beatles.prize.net.HttpUtil;
import com.sx.beatles.prize.net.RequestCallBack;
import com.sx.beatles.prize.util.AsyncTaskUtil;

import java.util.HashMap;

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

    protected void requestData(RequestCallBack callBack,String url, HashMap<String,String> map) {
        final RequestCallBack cb = callBack;
        final String requestUrl = url;
        final HashMap<String,String> paramMap = map;
        doAsync(new AsyncTaskUtil.CallPre<String>() {
            @Override
            public void onCallPre() throws Exception {
            }
        }, new AsyncTaskUtil.CallDoInBackground<String>() {
            @Override
            public String call() throws Exception {
                return HttpUtil.requestPost(requestUrl, paramMap);
            }
        }, new AsyncTaskUtil.CallPost<String>() {
            @Override
            public void onCallPost(String value) {
                if (TextUtils.isEmpty(value)) {
                    cb.onFail("返回json为空");
                    return;
                }
                cb.onSuccess(value);
            }
        });
    }
}
