package com.example.apirace.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultTime {

    @SerializedName("millis")
    @Expose
    private String millis = " ";
    @SerializedName("time")
    @Expose
    private String time = "";

    public String getMillis() {
        return millis;
    }

    public void setMillis(String millis) {
        this.millis = millis;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
