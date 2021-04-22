package com.ath.solutions.race.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "raceStartPositions")
public class RaceInput {
   private Integer numberOfLoops;
    private ArrayList<Participant> startList;
    private ArrayList<Loop> powerUps;

    public Integer getNumberOfLoops() {
        return numberOfLoops;
    }

    public void setNumberOfLoops(Integer numberOfLoops) {
        this.numberOfLoops = numberOfLoops;
    }

    public ArrayList<Participant> getStartList() {
        return startList;
    }

    public void setStartList(ArrayList<Participant> startList) {
        this.startList = startList;
    }

    public ArrayList<Loop> getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(ArrayList<Loop> powerUps) {
        this.powerUps = powerUps;
    }

    public RaceInput(Integer numberOfLoops, ArrayList<Participant> startList, ArrayList<Loop> powerUps) {
        this.numberOfLoops = numberOfLoops;
        this.startList = startList;
        this.powerUps = powerUps;
    }
}
