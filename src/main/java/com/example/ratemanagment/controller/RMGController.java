package com.example.ratemanagment.controller;

import com.example.ratemanagment.exception.InvalidRateException;
import com.example.ratemanagment.exception.ServiceException;
import com.example.ratemanagment.model.DeleteResponse;
import com.example.ratemanagment.model.RateModel;
import com.example.ratemanagment.model.SurchargeResponse;
import com.example.ratemanagment.service.RMGService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class RMGController {

    @Autowired
    RMGService rmgService;

    @Autowired
    RestTemplate restTemplate;

    Logger LOGGER = Logger.getLogger(RMGController.class);

    @PostMapping(consumes = "application/json", value = "/addrate")
    public ResponseEntity<RateModel> addRate(@RequestBody RateModel rateModel) throws ServiceException {
        LOGGER.info("addRate Function");
        return new ResponseEntity<RateModel>(rmgService.saveRate(rateModel), HttpStatus.CREATED);
    }

    @RequestMapping(consumes = "application/json", value = "/updaterate")
    public ResponseEntity<RateModel> updateRate(@RequestBody RateModel rateModel) throws ServiceException, InvalidRateException {
        LOGGER.info("updateRate Function");
        return new ResponseEntity<RateModel>(rmgService.updateRate(rateModel), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<SurchargeResponse> getRateById(@PathVariable("id") Integer id) throws InvalidRateException {
        LOGGER.info("getSurcharge Function");
        // LOGGER.info("Requested employee id :: " + id);
           SurchargeResponse surchargeResponse=rmgService.getRateSurcharge(id);
           return new ResponseEntity<SurchargeResponse>(surchargeResponse, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DeleteResponse> deleteRataById(@PathVariable("id") Integer id) throws InvalidRateException{
        LOGGER.info("Delete Rate Function");
        rmgService.deleteRate(id);
        DeleteResponse response=new DeleteResponse();
        response.setStatus("Deleted Successfully");
        return new ResponseEntity<DeleteResponse>(response, HttpStatus.OK);
    }

}

