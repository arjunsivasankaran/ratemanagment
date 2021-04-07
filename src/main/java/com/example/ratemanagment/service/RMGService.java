package com.example.ratemanagment.service;

import com.example.ratemanagment.exception.InvalidRateException;
import com.example.ratemanagment.exception.ServiceException;
import com.example.ratemanagment.model.RateModel;
import com.example.ratemanagment.model.SurchargeResponse;
import org.springframework.stereotype.Service;


@Service
public interface RMGService {

    RateModel saveRate(RateModel entity) throws ServiceException;
    RateModel updateRate(RateModel entity) throws InvalidRateException;
    SurchargeResponse getRateSurcharge(int id) throws InvalidRateException;
    void deleteRate(int id) throws InvalidRateException;
}
