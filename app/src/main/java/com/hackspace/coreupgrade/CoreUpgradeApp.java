package com.hackspace.coreupgrade;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


/**
 * Created by user on 5/01/17.
 */

public class CoreUpgradeApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/pna_light.otf")
                .setFontAttrId(R.attr.fontPath)
                .build());

    }


}
