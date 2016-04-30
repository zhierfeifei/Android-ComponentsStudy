package com.xu.androidcomponents.BroadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by xuzhebao on 2016/4/22.
 *
 */
public class MyBroadCastRecever extends BroadcastReceiver{
    @Override
    public IBinder peekService(Context myContext, Intent service) {
        return super.peekService(myContext, service);
    }

    public MyBroadCastRecever() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        abortBroadcast();
    }
}
