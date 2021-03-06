package com.cephmonitor.cephmonitor.model.network;

import android.os.Handler;

import com.android.volley.Response;

/**
 * Created by User on 2015/6/19.
 */
public abstract class AnalyzeListener<T> implements Response.Listener<T> {
    Handler handler = new Handler();

    @Override
    public void onResponse(final T o) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final boolean isSuccess = doInBackground(o);
                if (isSuccess) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            onPostExecute();
                            requestFinish(isSuccess);
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            requestFinish(isSuccess);
                        }
                    });
                }

            }
        }).start();
    }

    public abstract boolean doInBackground(T o);

    public abstract void onPostExecute();

    public void requestFinish(boolean isAnalyzeSuccess) {

    }
}
