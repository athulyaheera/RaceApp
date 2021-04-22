package com.ath.solutions.race.service;

import com.ath.solutions.race.domain.*;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceInputServiceTest {


    RaceService raceService = new RaceService();
    @Test
    public void testForInput1(){

        Participant participant= new Participant(1,"Test",10);
        Participant participant2= new Participant(2,"Test1",10);
        Participant participant3= new Participant(3,"Test3",10);
        ArrayList<Participant> list= new ArrayList<>();
        list.add(participant);
        list.add(participant2);
        list.add(participant3);
        ArrayList<Loop> loopList= new ArrayList<>();
        ArrayList<Lane> lanes= new ArrayList<>();
        Lane lane1 = new Lane(1,10);
        Lane lane2 = new Lane(2,-1);
        Lane lane3 = new Lane(3,4);
        lanes.add(lane1);
        lanes.add(lane2);
        lanes.add(lane3);
        Loop loop1 = new Loop(1,lanes);
        Loop loop2 = new Loop(2,lanes);
        loopList.add(loop1);
        loopList.add(loop2);
        RaceInput race= new RaceInput(3,list,loopList);
        HorseRaceResult result= raceService.computeRank(race);
        assertEquals(3,result.getRanking().size());
    }

}
