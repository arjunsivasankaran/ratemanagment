package com.example.ratemanagment.controller;

import com.example.ratemanagment.model.RateModel;
import com.example.ratemanagment.model.Surcharge;
import com.example.ratemanagment.model.SurchargeResponse;
import com.example.ratemanagment.service.RMGService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;


@RunWith(MockitoJUnitRunner.class)
public class RMGControllerTest {


    @Test
    void testAddRate() {
        RMGService service=Mockito.mock(RMGService.class);
        RMGController rmgController=Mockito.mock(RMGController.class);
        RateModel rateModel = new RateModel();
        rateModel.setRateId(1001);
        rateModel.setRateEffectiveDate(LocalDateTime.now());
        rateModel.setRateExpirationDate(LocalDateTime.now());
        rateModel.setDescription("Test");
        rateModel.setAmount(10000);
        Mockito.when(service.saveRate(rateModel)).thenReturn(rateModel);
        rmgController.addRate(rateModel);
    }

    @Test
    void testupdateRate() {
        RMGService service=Mockito.mock(RMGService.class);
        RMGController rmgController=Mockito.mock(RMGController.class);
        RateModel rateModel = new RateModel();
        rateModel.setRateId(1001);
        rateModel.setRateEffectiveDate(LocalDateTime.now());
        rateModel.setRateExpirationDate(LocalDateTime.now());
        rateModel.setDescription("Test");
        rateModel.setAmount(10000);
        Mockito.when(service.updateRate(rateModel)).thenReturn(rateModel);
        rmgController.updateRate(rateModel);
    }

    @Test
    void testgetRateById() {
        RMGService service=Mockito.mock(RMGService.class);
        RMGController rmgController=Mockito.mock(RMGController.class);
        RateModel rateModel = new RateModel();
        SurchargeResponse surchargeResponse=new SurchargeResponse();

        rateModel.setRateId(1);
        rateModel.setRateEffectiveDate(LocalDateTime.now());
        rateModel.setRateExpirationDate(LocalDateTime.now());
        rateModel.setDescription("Test");
        rateModel.setAmount(10000);

        surchargeResponse.setRateId(1);
        surchargeResponse.setEffectiveDate(LocalDateTime.now());
        surchargeResponse.setEffectiveDate(LocalDateTime.now());
        surchargeResponse.setDescription("Test");
        surchargeResponse.setAmount(10000);
        Surcharge surcharge = new Surcharge();
        surcharge.setSurchargeRate(100);
        surcharge.setSurchargeDescription("VAT");

        Mockito.when(service.getRateSurcharge(rateModel.getRateId())).thenReturn(surchargeResponse);
        rmgController.getRateById(rateModel.getRateId());
    }


}
