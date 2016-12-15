package com.roger.util;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by luoweiyi on 2016/12/14.
 */
public class CacheUtils {
    private static final ConcurrentHashMap<String,Object> cacheMap = new ConcurrentHashMap<String,Object>();

    public static Object put(String key,Object value){
        return cacheMap.put(key, value);
    }

    public static Object putIfAbsent(String key,Object value){
        return cacheMap.putIfAbsent(key,value);
    }

    public static Object get(String key){
        return cacheMap.get(key);
    }

    public static boolean containsKey(String key){
        return cacheMap.containsKey(key);
    }
}
