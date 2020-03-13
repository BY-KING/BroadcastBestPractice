package com.jby.broadcastbestpractice;

import android.app.Activity;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    private static List<Activity> activities=new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void finishAll(){
        activities.stream().forEach(activity->{
            if(!activity.isFinishing()){
                activity.finish();
            }
            activities.clear();
        });
    }
}
