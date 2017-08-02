package com.sx.beatles.prize.util.pref;

import android.content.Context;

import com.sx.beatles.prize.PrizeApplication;

/**
 * Created by 施行 on 2017/8/1.
 */

public class CommonPreferences extends PreferencesManager {
    private static final String KEY_PRIZE_INFO = "key_prize_info";
    private static final String NAME = "prize_commonpreferences";
    private static CommonPreferences mInstance = null;

    private CommonPreferences() {
        super(PrizeApplication.getInstance(), NAME, Context.MODE_PRIVATE);
    }

    public static CommonPreferences getInstance(){
        if(mInstance == null){
            mInstance = new CommonPreferences();
        }
        return mInstance;
    }

    public String getKeyPrizeInfo() {
        return getString(KEY_PRIZE_INFO,null);
    }

    public void setKeyPrizeInfo(String jsonStr){
        putString(KEY_PRIZE_INFO,jsonStr);
        commit();
    }
}
