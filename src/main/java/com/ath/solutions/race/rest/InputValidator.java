package com.ath.solutions.race.rest;

import com.ath.solutions.race.domain.RaceInput;
import com.ath.solutions.race.domain.Loop;
import com.ath.solutions.race.exception.InvalidInputException;

import java.util.List;

public class InputValidator {
    public static void  validateInput(RaceInput input)  throws InvalidInputException{

        // Check if the each loop has a power up or not
        if(!input.getNumberOfLoops().equals(input.getPowerUps().size()+1)){
            throw new InvalidInputException("Power Up or Down value not provided for all");
        }
        // Check if the number of participant is equal to number of lanes
        if(input.getStartList().size()>=
                (input.getPowerUps().stream().map(Loop::getLanes).mapToInt(List::size).sum())){
         throw new  InvalidInputException("NUmber of Participant greater than number of lanes");
        }

    }
}
