package com.venkateshpamarthi.advancedprefrencemanager.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.venkateshpamarthi.advancedprefrencemanager.manager.AdvancedPreferenceManager;
import com.venkateshpamarthi.advancedprefrencemanager.R;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdvancedPreferenceManager.getInstance(this)
                .storeString("firstName","venky")
                .storeString("lastName","smith")
                .storeInt("age",25)
                .storeBoolean("isValidUser",true);

        Set<String> names = new HashSet<>();
        names.add("John");
        names.add("Peter");
        names.add("Ravi");

        AdvancedPreferenceManager.getInstance(this).storeStringSet("names",names);

        User user = new User("Betty", 23, 405);
        AdvancedPreferenceManager.getInstance(this).storeObjectValue("user",user);
        AdvancedPreferenceManager.getInstance(this).storeLong("number",345678903L);
        AdvancedPreferenceManager.getInstance(this).storeFloat("fNum",345678.90F);

        retrieveValues();
    }

    /**
     * Retrieve values from Advanced Preference Manager.
     */
    private void retrieveValues() {
        String firstName  = AdvancedPreferenceManager.getInstance(this).getString("firstName");
        int age  = AdvancedPreferenceManager.getInstance(this).getInt("age");
        boolean isValidUser  = AdvancedPreferenceManager.getInstance(this).getBoolean("isValidUser", false);
        Set<String> rNames = AdvancedPreferenceManager.getInstance(this).getStringSet("names");
        Float fNum = AdvancedPreferenceManager.getInstance(this).getFloat("fNum");
        Long lNum = AdvancedPreferenceManager.getInstance(this).getLong("number");
        for (String name :
                rNames) {
            Log.i(TAG, "retrieveValues: name : " + name);
        }
        Log.i(TAG, "retrieveValues: first name : " + firstName);
        Log.i(TAG, "retrieveValues: age : " + age);
        Log.i(TAG, "retrieveValues: is valid user : " + isValidUser);
        Log.i(TAG, "retrieveValues: float " + fNum);
        Log.i(TAG, "retrieveValues: long " + lNum);

        User sameUser = (User) AdvancedPreferenceManager.getInstance(this).getObjectValue("user");
        Log.i(TAG, "retrieveValues: user " + sameUser.name + " age : " + sameUser.age + " no. " + sameUser.phoneNo);

    }
}
