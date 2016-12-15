package com.roger.util;

import com.roger.statistics.ServiceCalculate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luoweiyi on 2016/12/7.
 */
public class CalculateUtils {
    private static final Map<String,ServiceCalculate> serviceCallMap = new HashMap<String,ServiceCalculate>();
    private static Object callServiceObj = new Object();

    public static Map<String,ServiceCalculate> getServiceCallMap(){
        Map<String,ServiceCalculate> copy = new HashMap<String,ServiceCalculate>();
        for(String key : serviceCallMap.keySet()){
            copy.put(key,new ServiceCalculate(serviceCallMap.get(key).getCount(),serviceCallMap.get(key).getTime()));
        }
        return copy;
    }

    public static void callService(String service,Long time){
        synchronized (callServiceObj){
            if(serviceCallMap.containsKey(service)){
                serviceCallMap.get(service).setCount(serviceCallMap.get(service).getCount()+1);
                serviceCallMap.get(service).setTime(serviceCallMap.get(service).getTime()+time);
            }else{
                ServiceCalculate serviceCalculate = new ServiceCalculate(1L,time);
                serviceCallMap.put(service,serviceCalculate);
            }
        }
    }
}
