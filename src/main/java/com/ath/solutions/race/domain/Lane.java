package com.ath.solutions.race.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Lane {
    @JacksonXmlProperty(isAttribute = true)
    private Integer number;
    @JacksonXmlText
    private Integer powerValue;

    public Integer getNumber() {
        return number;
    }

    public Lane(Integer number, Integer powerValue) {
        this.number = number;
        this.powerValue = powerValue;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPowerValue() {
        return powerValue;
    }

    public void setPowerValue(Integer powerValue) {
        this.powerValue = powerValue;
    }
}
