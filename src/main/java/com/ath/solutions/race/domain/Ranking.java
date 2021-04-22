package com.ath.solutions.race.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Ranking implements Comparable<Ranking> {

    private Integer position;
    private String horseName;
    @JsonIgnore
    private Double timeTaken;
    @JsonIgnore
    private Boolean isOutOfRace;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public Ranking(Integer position, String horseName, Double timeTaken) {
        this.position = position;
        this.horseName = horseName;
        this.timeTaken = timeTaken;
        this.isOutOfRace= Boolean.FALSE;
    }

    public Double getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Double timeTaken) {
        this.timeTaken = timeTaken;
    }

    @Override
    public int compareTo(Ranking other) {
        if(this.getTimeTaken() == other.getTimeTaken())
            return 0;
        else if(this.getTimeTaken() > other.getTimeTaken())
            return 1;
        else
            return -1;
    }
    @JsonIgnore
    public Boolean getOutOfRace() {
        return isOutOfRace;
    }

    public void setOutOfRace(Boolean outOfRace) {
        isOutOfRace = outOfRace;
    }
}
