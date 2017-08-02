package com.sx.beatles.prize.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gdobe.myrecyclerview.interfaces.OnRefreshListener;
import com.gdobe.myrecyclerview.recyclerview.LRecyclerView;
import com.gdobe.myrecyclerview.recyclerview.LRecyclerViewAdapter;
import com.sx.beatles.prize.R;
import com.sx.beatles.prize.adapter.MainDataAdapter;
import com.sx.beatles.prize.base.BaseFragment;
import com.sx.beatles.prize.bean.Prize;
import com.sx.beatles.prize.net.HttpUtil;
import com.sx.beatles.prize.util.AsyncTaskUtil;
import com.sx.beatles.prize.util.pref.CommonPreferences;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 施行 on 2017/7/31.
 */

public class HomeFragment extends BaseFragment {

    private Context mContext = null;
    private LRecyclerView mLRecyclerView;
    private LRecyclerViewAdapter mLRecyclerViewAdapter = null;
    private ArrayList<Prize> mPrizeInfoList;
    private MainDataAdapter mMainDataAdapter;

    @Override
    protected int setContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        mContext = getActivity();
        mLRecyclerView = (LRecyclerView) view.findViewById(R.id.recycler_view);
    }

    @Override
    protected void loadData() {
        mPrizeInfoList = new ArrayList<>();
        ArrayList<Prize> info = getParseData();
        if(info != null){
            mPrizeInfoList.addAll(info);
        }
        mMainDataAdapter = new MainDataAdapter(getActivity());
        mMainDataAdapter.addAll(mPrizeInfoList);

        mLRecyclerViewAdapter = new LRecyclerViewAdapter(mMainDataAdapter);

        mLRecyclerView.setAdapter(mLRecyclerViewAdapter);

        mLRecyclerView.setHasFixedSize(true);

        mLRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mLRecyclerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestData();
            }
        });
    }

    private void requestData() {
        doAsync(null, new AsyncTaskUtil.CallDoInBackground<String>() {
            @Override
            public String call() throws Exception {
                return HttpUtil.requestPost(new HashMap<String, String>());
            }
        }, new AsyncTaskUtil.CallPost<String>() {
            @Override
            public void onCallPost(String value) {
                if(TextUtils.isEmpty(value)) {
                    Toast.makeText(mContext,"解析data数据为空",Toast.LENGTH_LONG).show();
                    return;
                }
                JSONObject jsonObject = JSON.parseObject(value);
                if(jsonObject == null){
                    return;
                }
                String data = jsonObject.getString("data");
                if(TextUtils.isEmpty(data)){
                    Toast.makeText(mContext,"解析data数据为空",Toast.LENGTH_LONG).show();
                    return;
                }
                CommonPreferences.getInstance().setKeyPrizeInfo(data);//存在来，做缓存

                if(!mPrizeInfoList.isEmpty()){
                    mPrizeInfoList.clear();
                }
                ArrayList<Prize> info = getParseData();
                if(info != null){
                    mPrizeInfoList.addAll(info);
                }

                mMainDataAdapter.addAll(mPrizeInfoList);
                mLRecyclerViewAdapter.notifyDataSetChanged();
                mLRecyclerView.refreshComplete(20);
            }
        });
    }

    private ArrayList<Prize> getParseData(){
        String data = CommonPreferences.getInstance().getKeyPrizeInfo();
        if(TextUtils.isEmpty(data)){
            Toast.makeText(mContext,"缓存为空",Toast.LENGTH_LONG).show();
            return null;
        }
        ArrayList<Prize> infoList = new ArrayList<>();
        JSONArray jsonArray = JSON.parseArray(data);
        for(int i = 0 ; i < jsonArray.size(); i++){
            Prize prize = JSON.parseObject(jsonArray.get(i).toString(),Prize.class);
            infoList.add(prize);
        }
        return infoList;
    }
}
