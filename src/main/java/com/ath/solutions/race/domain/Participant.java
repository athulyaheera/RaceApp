package com.ath.solutions.race.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Participant {
    @JacksonXmlProperty
    private Integer  lane;
    @JacksonXmlProperty
   private String name;
    @JacksonXmlProperty
    private Integer  baseSpeed;

    public Integer getLane() {
        return lane;
    }

    public Participant(Integer lane, String name, Integer baseSpeed) {
        this.lane = lane;
        this.name = name;
        this.baseSpeed = baseSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(Integer baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    public void setLane(Integer lane) {
        this.lane = lane;
    }
}
