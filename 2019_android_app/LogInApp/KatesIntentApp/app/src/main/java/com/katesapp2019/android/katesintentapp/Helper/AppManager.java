package com.katesapp2019.android.katesintentapp.Helper;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

public class AppManager {


    private static Stack<Activity> activityStack;
    private static AppManager instance;

    private AppManager() {
    }

    public static Stack<Activity> getActivityStack() {
        return activityStack;
    }


    /**
     * Singleton
     */
    public static AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    /**
     * add Activity to the Stack of Activities.
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * get current || top Activity
     */
    public Activity getCurrentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * close current || top Activity
     */
    public void finishCurrentActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * finish the specific activity
     */

    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
//            activity = null; 覺得可以不用這句，但還在懷疑自己...
        }
    }

    /**
     * close the specific activity with its Class Name
     */
    public void closeActivitysClass(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * close all the Activities
     */

    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (activityStack.get(i) != null) {
                activityStack.get(i).finish();
            }
        }

        activityStack.clear();

    }

    /**
     * exit the App
     */

    public void appExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


