package com.venkateshpamarthi.advancedprefrencemanager.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by venkateshpamarthi on 09/12/16.
 */
public class AdvancedPreferenceManager {

    private volatile static AdvancedPreferenceManager advancedPreferenceManager = null;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    /**
     * Gets instance.
     *
     * @param context the context
     * @return the instance
     */
    public static AdvancedPreferenceManager getInstance(Context context) {
        if (advancedPreferenceManager == null) {
            synchronized (AdvancedPreferenceManager.class) {
                if (advancedPreferenceManager == null)
                    advancedPreferenceManager = new AdvancedPreferenceManager(context);
            }
        }
        return advancedPreferenceManager;
    }

    public interface KEYS {
        String DEFAULT_STRING = "";
        Float DEFAULT_FLOAT = 0.0F;
        Long DEFAULT_LONG = 0L;
        Set<String> DEFAULT_STRING_SET = new HashSet<>();
    }

    /**
     * Instantiates a new Advanced preference manager.
     *
     * @param context the context
     */
    private AdvancedPreferenceManager(Context context) {
        preferences = context.getApplicationContext().getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    /**
     * Store int advanced preference manager.
     *
     * @param key   the key
     * @param value the value
     * @return the advanced preference manager
     */
    public AdvancedPreferenceManager storeInt(String key, int value) {
        editor.putInt(key, value).commit();
        return this;
    }

    /**
     * Gets int.
     *
     * @param key the key
     * @return the int
     */
    public int getInt(String key) {
        return preferences.getInt(key, 0);
    }

    /**
     * Store string advanced preference manager.
     *
     * @param key   the key
     * @param value the value
     * @return the advanced preference manager
     */
    public AdvancedPreferenceManager storeString(String key, String value) {
        editor.putString(key, value).commit();
        return this;
    }

    /**
     * Gets string.
     *
     * @param key the key
     * @return the string
     */
    public String getString(String key) {
        return preferences.getString(key, KEYS.DEFAULT_STRING);
    }

    /**
     * Store boolean advanced preference manager.
     *
     * @param key   the key
     * @param value the value
     * @return the advanced preference manager
     */
    public AdvancedPreferenceManager storeBoolean(String key, boolean value) {
        editor.putBoolean(key, value).commit();
        return this;
    }

    /**
     * Gets boolean.
     *
     * @param key          the key
     * @param defaultValue the default value
     * @return the boolean
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }

    /**
     * Store long advanced preference manager.
     *
     * @param key   the key
     * @param value the value
     * @return the advanced preference manager
     */
    public AdvancedPreferenceManager storeLong(String key, Long value) {
        editor.putLong(key, value).commit();
        return this;
    }

    /**
     * Gets long.
     *
     * @param key the key
     * @return the long
     */
    public Long getLong(String key) {
        return preferences.getLong(key, KEYS.DEFAULT_LONG);
    }

    /**
     * Store float advanced preference manager.
     *
     * @param key   the key
     * @param value the value
     * @return the advanced preference manager
     */
    public AdvancedPreferenceManager storeFloat(String key, float value) {
        editor.putFloat(key, value).commit();
        return this;
    }

    /**
     * Gets float.
     *
     * @param key the key
     * @return the float
     */
    public float getFloat(String key) {
        return preferences.getFloat(key, KEYS.DEFAULT_FLOAT);
    }

    public AdvancedPreferenceManager storeStringSet(String key, Set<String> value) {
        editor.putStringSet(key, value).commit();
        return this;
    }

    /**
     * Gets string set.
     *
     * @param key the key
     * @return the string set
     */
    public Set<String> getStringSet(String key) {
        return preferences.getStringSet(key, KEYS.DEFAULT_STRING_SET);
    }

    /**
     * Gets object value.
     *
     * @param key the key
     * @return the object value
     */
    public Object getObjectValue(String key) {
        String value = preferences.getString(key, KEYS.DEFAULT_STRING);
        return convertStringToObject(value);
    }

    /**
     * Store object value advanced preference manager.
     *
     * @param key    the key
     * @param object the object
     * @return the advanced preference manager
     */
    public AdvancedPreferenceManager storeObjectValue(String key, Serializable object){
        String value = convertObjectToString(object);
        return storeString(key,value);
    }

    /**
     * Remove advanced preference manager.
     *
     * @param key the key
     * @return the advanced preference manager
     */
    public AdvancedPreferenceManager remove(String key){
        editor.remove(key).commit();
        return this;
    }

    /**
     * Convert object to string string.
     *
     * @param object the object
     * @return the string
     */
    private String convertObjectToString(Serializable object){
        String value = "";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try{
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
        }catch (Exception e){
            e.getMessage();
        }
        value = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
        return value;
    }

    /**
     * Convert string to object object.
     *
     * @param value the value
     * @return the object
     */
    private Object convertStringToObject(String value){
        Object object = null;
        try {
            byte[] data = Base64.decode(value, Base64.DEFAULT);
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new ByteArrayInputStream(data));
            object = objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
