package com.ath.solutions.race.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.ath.solutions.race.domain.RaceInput;
import com.ath.solutions.race.domain.HorseRaceResult;
import com.ath.solutions.race.exception.BaseAppException;
import com.ath.solutions.race.exception.InvalidInputException;
import com.ath.solutions.race.service.RaceService;




@RestController
@RequestMapping("/java/api")
public class RaceController {

    @Autowired
    public RaceService raceService;

    private static final Logger LOGGER= LoggerFactory.getLogger(RaceController.class);

    @PostMapping(path = "/play", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HorseRaceResult playrace(@RequestBody RaceInput inputXML) {
        LOGGER.info("Enter playrace ");
        try {
            InputValidator.validateInput(inputXML);
            return raceService.computeRank(inputXML);

        } catch (BaseAppException e) {
            LOGGER.error("Exception  "+e.getMessage());
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        } catch (InvalidInputException e) {
            LOGGER.error("InvalidInputException  "+e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
        }

    }


}
