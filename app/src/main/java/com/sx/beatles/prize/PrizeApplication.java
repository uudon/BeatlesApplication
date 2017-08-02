package com.sx.beatles.prize;

import android.app.Application;

/**
 * Created by 施行 on 2017/8/1.
 */

public class PrizeApplication extends Application {
    private static PrizeApplication instance;

    public synchronized static PrizeApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
