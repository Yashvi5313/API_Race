package com.example.apirace.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FasttestLapTime {

    @SerializedName("time")
    @Expose
    private String time = "";

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
