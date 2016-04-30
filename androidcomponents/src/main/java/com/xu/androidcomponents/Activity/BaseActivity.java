package com.xu.androidcomponents.Activity;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.xu.androidcomponents.Utils.ActivityUtils;

/**
 * Created by xuzhebao on 2016/4/22.
 * 所有Activity的父类
 */
public class BaseActivity extends AppCompatActivity{
    public final static int MY_PERMISSIONS_REQUEEST_READ_CONTACTS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityUtils.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityUtils.removeActivity(this);
    }

    //------------运行时权限

    public void checkPermission(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    MY_PERMISSIONS_REQUEEST_READ_CONTACTS);
        }else {
            //做CallPhone?
            getAllColumnName();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
            //callPhone?
            getAllColumnName();
        }else {
            Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
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
             /*   int i = 0;
                while (cursor.moveToNext()) {
                    String columnName = cursor.getColumnName(i);
                    i++;
                    Log.e("columnName---11---", columnName);
                }*/

                //for循环方法
                int columnCount = cursor.getColumnCount();
                for (int j=0;j<columnCount;j++){
                    String columnName = cursor.getColumnName(j);
                    Log.e("columnName---22--->",j+"   " + columnName);
                }
            }
        }catch (Exception e){e.printStackTrace();}finally {
            if (cursor != null){
                cursor.close();
            }
        }
    }

    public void callPhone(){
       /* Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:"+"123456");
        intent.setData(data);
        startActivity(intent);*/

    }
}
