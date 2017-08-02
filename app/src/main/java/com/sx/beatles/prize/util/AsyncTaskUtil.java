package com.sx.beatles.prize.util;

import android.util.Log;

/**
 * Created by 施行 on 2017/2/3.
 */

public class AsyncTaskUtil {

    public static final String TAG = "AsyncTaskUtil";

    public interface CallPre<T> {
        public void onCallPre() throws Exception;
    }

    public interface CallDoInBackground<T> {
        public T call() throws Exception;
    }

    public interface CallPost<T> {
        public void onCallPost(final T value);
    }

    public static <T> void doAsync(final CallPre<T> callPre, final CallDoInBackground<T> callDoInBackground, final CallPost<T> callPost){

        new AsyncTaskConcurrence<Void, Void, T>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                try{
                    callPre.onCallPre();
                } catch (Exception e){
                    Log.e(TAG,e.toString());
                }
            }

            @Override
            protected T doInBackground(Void... params) {
                try {
                    return callDoInBackground.call();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(T result) {
                super.onPostExecute(result);
                callPost.onCallPost(result);
            }
        }.execute((Void[]) null);
    }

}
