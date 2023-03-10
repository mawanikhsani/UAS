package com.example.finalprojectjava.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {
    private static PreferencesHelper INSTANCE;
    private SharedPreferences sharedPreferences;

    private PreferencesHelper(Context context) {
        sharedPreferences = context
                .getApplicationContext()
                .getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);
    }

    public static PreferencesHelper getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new PreferencesHelper(context);
        }
        return INSTANCE;
    }

    public SharedPreferences preferences() {
        return sharedPreferences;
    }

    public void setLogin(boolean islogin){
        sharedPreferences.edit().putBoolean("isLogin", islogin).apply();
    }

    public Boolean isLogin() {
        return sharedPreferences.getBoolean("isLogin", false);
    }
}
