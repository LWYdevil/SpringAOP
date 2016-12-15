package com.roger.statistics;

import java.io.Serializable;

/**
 * Created by luoweiyi on 2016/12/7.
 */
public class ServiceCalculate implements Serializable{
    private Long count;

    private Long time;

    public ServiceCalculate(Long count,Long time){
        this.count = count;
        this.time = time;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
