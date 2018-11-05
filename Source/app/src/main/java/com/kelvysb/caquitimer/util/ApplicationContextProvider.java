package com.kelvysb.caquitimer.util;

import android.app.Application;
import android.content.Context;
import net.danlew.android.joda.JodaTimeAndroid;

public class ApplicationContextProvider extends Application {
    /**
     * Keeps a reference of the application context
     */
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        JodaTimeAndroid.init(this);
    }

    /**
     * Returns the application context
     *
     * @return application context
     */
    public static Context getContext() {
        return sContext;
    }

}
