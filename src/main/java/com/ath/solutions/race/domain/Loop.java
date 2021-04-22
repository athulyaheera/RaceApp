package com.ath.solutions.race.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;

public class Loop {
    @JacksonXmlProperty(isAttribute = true)
   private Integer  number;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "lane")
    private ArrayList<Lane> lanes;

    public Integer getNumber() {
        return number;
    }

    public Loop(Integer number, ArrayList<Lane> lanes) {
        this.number = number;
        this.lanes = lanes;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public ArrayList<Lane> getLanes() {
        return lanes;
    }

    public void setLanes(ArrayList<Lane> lanes) {
        this.lanes = lanes;
    }
}
