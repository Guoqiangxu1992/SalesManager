/**
 * 项   目  名：IOT
 * 包       名：com.midea.smart.base.rpc.trans
 * 文   件  名：a.java
 * 版本信息：	V2.0
 * 日       期：2016年4月2日-上午11:08:05
 * Copyright (c)  2016 Midea Smart版权所有
 * 
 */
package com.task;
/**
 * 
 * @author  xulong
 * @version  [2016年4月2日]
 */
public class ResultObject {
    private long time;
    
    private String msg;
    
    public ResultObject(long time, String msg) {
        super();
        this.time = time;
        this.msg = msg;
    }
    
    public long getTime() {
        return time;
    }
    
    public void setTime(long time) {
        this.time = time;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "[time=" + time + ", msg=" + msg + "]";
    }
}