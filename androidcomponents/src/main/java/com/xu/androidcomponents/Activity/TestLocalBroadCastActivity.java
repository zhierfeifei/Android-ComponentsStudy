package com.xu.androidcomponents.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.xu.androidcomponents.R;

/**
 * Created by xuzhebao on 2016/4/22.
 */
public class TestLocalBroadCastActivity extends BaseActivity{
    private Button send_broadcast;

    private LocalBroadcastManager mLocalBroadCastManager;
    private MyLocalBroadCastReceiver myLocalBroadCastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_test_broadcast);
        send_broadcast = (Button)findViewById(R.id.send_broadcast);
        send_broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送一个广播
                Intent intent = new Intent("Local.BroadCast.Test");
                mLocalBroadCastManager.sendBroadcast(intent);
            }
        });

        myLocalBroadCastReceiver = new MyLocalBroadCastReceiver();
        mLocalBroadCastManager = LocalBroadcastManager.getInstance(this);
        //注册广播
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction("Local.BroadCast.Test");
        mLocalBroadCastManager.registerReceiver(myLocalBroadCastReceiver,mFilter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalBroadCastManager.unregisterReceiver(myLocalBroadCastReceiver);
    }

    /*
        * 用于接收发送的本地广播
        * */
    class MyLocalBroadCastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("localReceiver","receive local broadcast");
        }
    }
}
