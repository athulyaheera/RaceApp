package com.ath.solutions.race.service;

import com.ath.solutions.race.domain.RaceInput;
import com.ath.solutions.race.domain.Ranking;
import com.ath.solutions.race.rest.RaceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ath.solutions.race.domain.HorseRaceResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class RaceService {

    private static Double LENGTH_OF_TRACK= 1000.00;
    private static final Logger LOGGER= LoggerFactory.getLogger(RaceController.class);

    public RaceService() {
    }

    /**
     *
     * @param raceInput
     * @return
     */
    public HorseRaceResult computeRank(RaceInput raceInput){
        LOGGER.info("Enter Service");
        ArrayList<Ranking> rankingList= new ArrayList<>();
        raceInput.getStartList().forEach(participant ->{
            Ranking ranking= new Ranking(0,participant.getName(),
                    LENGTH_OF_TRACK/(participant.getBaseSpeed()));
            raceInput.getPowerUps().stream().forEach(loop ->
            loop.getLanes().stream().filter
                    (lane-> lane.getNumber()==participant.getLane()).forEach(lane-> {
              int newSpeed =  participant.getBaseSpeed() + lane.getPowerValue();
              if(newSpeed<=0){
                  ranking.setOutOfRace(Boolean.TRUE);
              }
              else {
                  participant.setBaseSpeed(newSpeed);
                  ranking.setTimeTaken(ranking.getTimeTaken()
                          + (LENGTH_OF_TRACK / ((participant.getBaseSpeed()))));
              }
            }));

            rankingList.add(ranking);
            });
        rankingList.removeIf(ranking -> ranking.getOutOfRace()==Boolean.TRUE);
        Collections.sort(rankingList);
        int rankNUmber=1;
        rankingList.get(0).setPosition(rankNUmber);
        for(int index=1; index<rankingList.size();index++){
            if(rankingList.get(index).getTimeTaken()==rankingList.get(index-1).getTimeTaken()){
                rankingList.get(index).setPosition(rankNUmber);
            }
            else
                rankingList.get(index).setPosition(++rankNUmber);

        }
        LOGGER.info("Exit Service");
      return  new HorseRaceResult(rankingList.stream().filter(ranking -> ranking.getPosition()<=3).collect(Collectors.toList()));

    }

}
