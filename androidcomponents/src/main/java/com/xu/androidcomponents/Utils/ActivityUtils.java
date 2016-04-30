package com.xu.androidcomponents.Utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuzhebao on 2016/4/22.
 * //用于管理app中所有的activity的
 */
public class ActivityUtils {

    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAllActivity(){
        for (Activity activity:activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
