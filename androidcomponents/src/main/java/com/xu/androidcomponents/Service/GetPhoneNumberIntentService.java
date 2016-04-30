package com.xu.androidcomponents.Service;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.xu.androidcomponents.R;

/**
 * Created by xuzhebao on 2016/4/29.
 * <p>
 * //获取手机电话本里的电话
 */
public class GetPhoneNumberIntentService extends IntentService {
    private static final int REQUEST_READ_CONTACTS = 0;

    public GetPhoneNumberIntentService() {
        super("GetPhoneNumberIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    /*
    * 注意：
    * 1、这个方法是在子线程里执行的，所以可以不用开启子线程，就能避免ANR；
    * 2、这个方法逻辑执行完之后会自动停止本服务（服务一旦停止就会执行OnDestory方法的）
    * */
    @Override
    protected void onHandleIntent(Intent intent) {

        ContentResolver mResolver = getContentResolver();
        mResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /*
    * 获取ContactsContract.Contacts表下的所有列名，也就是对应的常量字段名
    * */
    public  void getAllColumnName() {
        ContentResolver mResolver = getContentResolver();
        Cursor cursor = null;
        try {
            cursor = mResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            if (cursor != null) {
                int i = 0;
                while (cursor.moveToNext()) {
                    String columnName = cursor.getColumnName(i);
                    i++;
                    Log.e("columnName---11---", columnName);
                }

                //for循环方法
                int columnCount = cursor.getColumnCount();
                for (int j=0;j<columnCount;j++){
                    String columnName = cursor.getColumnName(j);
                    Log.e("columnName---22---", columnName);
                }
            }
        }catch (Exception e){e.printStackTrace();}finally {
            if (cursor != null){
                cursor.close();
            }
        }
    }

}
