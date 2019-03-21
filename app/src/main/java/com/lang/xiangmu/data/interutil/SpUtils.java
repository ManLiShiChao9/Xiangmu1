package com.ww.wangwei.jingbasmall.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.ww.wangwei.jingbasmall.net.App;

/**
 * Created by 汪巍
 * on 2018/12/12
 *
 * SpUtils工具
 */
public class SpUtils {
    private static final String file_name = "sp_name";
    private static int sp_mode = Context.MODE_PRIVATE;
    private static Context context = App.context;

    //存值的方法
    public static boolean put(String key,Object value){
        SharedPreferences sp = context.getSharedPreferences(file_name, sp_mode);
        SharedPreferences.Editor edit = sp.edit();

        if (value instanceof String){
            if (!TextUtils.isEmpty((CharSequence) value)){
                edit.putString(key, (String) value);
            }
        }else if (value instanceof Boolean){
            edit.putBoolean(key, (Boolean) value);
        }else if (value instanceof Float){
            edit.putFloat(key, (Float) value);
        }else if (value instanceof Integer){
            edit.putInt(key, (Integer) value);
        }else {
            edit.putLong(key, (Long) value);
        }

        boolean commit = edit.commit();
        return commit;
    }
    //取值的方法
    public static String getString(String key,String defult){
        SharedPreferences sp = context.getSharedPreferences(file_name, sp_mode);
        return sp.getString(key,defult);
    }

    public static int getInt(String key,Integer defult){
        SharedPreferences sp = context.getSharedPreferences(file_name, sp_mode);
        return sp.getInt(key,defult);
    }
    public static boolean getBoolean(String key, Boolean defult){
        SharedPreferences sp = context.getSharedPreferences(file_name, sp_mode);
        return sp.getBoolean(key,defult);
    }
    //销毁
    public static void remove(String key){
        SharedPreferences sp = context.getSharedPreferences(file_name, sp_mode);
        SharedPreferences.Editor edit = sp.edit();
        edit.remove(key);
        edit.commit();
    }
}
