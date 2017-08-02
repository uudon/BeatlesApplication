package com.sx.beatles.prize.net;

/**
 * Created by 施行 on 2017/8/2.
 */

public interface RequestCallBack {
     void onSuccess(String result);

     void onFail(String errorMessage);
}
