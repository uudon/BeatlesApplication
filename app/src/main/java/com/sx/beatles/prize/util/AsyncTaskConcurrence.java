package com.sx.beatles.prize.util;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;

public abstract class AsyncTaskConcurrence<Params, Progress, Result> extends
        AsyncTask<Params, Progress, Result> {
	
	/**
	 * 并发执行
	 * 由于api11及以上的AsyncTask是串行的，需要执行并发的异步任务时请使用executeConcurrence
	 * @param params
	 * @return
	 */
	@SuppressLint("InlinedApi")
	public final AsyncTask<Params, Progress, Result> executeConcurrence(
			Params... params) {
		if(Build.VERSION.SDK_INT >= 11){
			return executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
		}else{
			return execute(params);
		}
	}
}
