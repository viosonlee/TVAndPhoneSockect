package lee.vioson.network.utils;

import android.content.Context;

import java.util.HashSet;

/**
 * Created by viosonlee
 * on 2017/7/25.
 * for
 */

public class SpUtil {

    public static SpWorker with(Context context) {
        return new SpWorker(context);
    }

    public static class SpWorker {
        private Context context;

        private SpWorker(Context context) {
            this.context = context;
        }

        public void saveString(String tableName, String key, String value) {
            context.getSharedPreferences(tableName, Context.MODE_PRIVATE)
                    .edit().putString(key, value).apply();
        }

        public void saveBoolean(String tableName, String key, boolean b) {
            context.getSharedPreferences(tableName, Context.MODE_PRIVATE)
                    .edit().putBoolean(key, b).apply();
        }

        public String getString(String tableName, String key) {
            return context.getSharedPreferences(tableName, Context.MODE_PRIVATE)
                    .getString(key, "");
        }

        public boolean getBoolean(String tableName, String key, boolean defaultValue) {
            return context.getSharedPreferences(tableName, Context.MODE_PRIVATE)
                    .getBoolean(key, defaultValue);
        }

        public void saveStringSet(String tableName, String key, HashSet<String> value) {
            context.getSharedPreferences(tableName, Context.MODE_PRIVATE)
                    .edit().putStringSet(key, value).apply();
        }

        public HashSet<String> getStringSet(String tableName, String key) {
            return (HashSet<String>) context.getSharedPreferences(tableName, Context.MODE_PRIVATE)
                    .getStringSet(key, new HashSet<>());
        }

        public void saveLong(String tableName, String key, long l) {
            context.getSharedPreferences(tableName, Context.MODE_PRIVATE)
                    .edit().putLong(key, l).apply();
        }

        public Long getLong(String tableName, String key) {
            return context.getSharedPreferences(tableName, Context.MODE_PRIVATE).getLong(key, -1);
        }
    }

}
