package com.gsmeuav.steam_stats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {
    @JsonProperty("appid")
    private int appId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("playtime_forever")
    private int playTime;
    @JsonProperty("rtime_last_played")
    private long lastPlayed;

    public int getAppId() {
        return appId;
    }

    public int getPlayTimeMinutes() {
        return playTime;
    }

    public int getPlayTimeHours(){
        return playTime / 60;
    }

    public String getName() {
        return name;
    }

    public long getLastPlayed() {
        return lastPlayed;
    }


    public void setAppId(int appId) {
        this.appId = appId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public void setLastPlayed(long lastPlayed) {
        this.lastPlayed = lastPlayed;
    }


}
