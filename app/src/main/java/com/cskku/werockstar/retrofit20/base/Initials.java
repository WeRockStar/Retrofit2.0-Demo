package com.cskku.werockstar.retrofit20.base;

import android.app.Application;

import com.cskku.werockstar.retrofit20.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Kotchaphan on 29/10/2558.
 */
public class Initials extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/sukhumvit.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
}
