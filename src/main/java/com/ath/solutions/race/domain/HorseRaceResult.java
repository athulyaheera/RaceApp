package com.ath.solutions.race.domain;

import java.io.Serializable;
import java.util.List;

public class HorseRaceResult implements Serializable {
    private List<Ranking> ranking;

    public HorseRaceResult(List<Ranking> ranking) {
        this.ranking = ranking;
    }

    public List<Ranking> getRanking() {
        return ranking;
    }

    public void setRanking(List<Ranking> ranking) {
        this.ranking = ranking;
    }
}
