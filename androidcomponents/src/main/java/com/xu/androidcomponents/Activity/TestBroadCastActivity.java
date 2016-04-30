package com.xu.androidcomponents.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xu.androidcomponents.R;

/**
 * Created by xuzhebao on 2016/4/22.
 */
public class TestBroadCastActivity extends Activity{

    private Button send_broadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_test_broadcast);
        send_broadcast = (Button)findViewById(R.id.send_broadcast);
        send_broadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送一个有序广播
                Intent intent = new Intent("Test.BroadCast.MyBroadCastRecever");
                sendOrderedBroadcast(intent,null);
            }
        });
    }
}
