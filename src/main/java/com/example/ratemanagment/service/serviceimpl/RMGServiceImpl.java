package com.example.ratemanagment.service.serviceimpl;

import com.example.ratemanagment.exception.InvalidRateException;
import com.example.ratemanagment.exception.ServiceException;
import com.example.ratemanagment.model.RateModel;
import com.example.ratemanagment.model.Surcharge;
import com.example.ratemanagment.model.SurchargeResponse;
import com.example.ratemanagment.repository.RateManagmentRepository;
import com.example.ratemanagment.service.RMGService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class RMGServiceImpl implements RMGService {

    @Autowired
    RateManagmentRepository rateManagmentRepository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public RateModel saveRate(RateModel entity) throws ServiceException {
        Optional<RateModel> rateEntity = rateManagmentRepository.findById(entity.getRateId());
        if(rateEntity.isPresent())
            throw new ServiceException("Duplicate rate Found / Please check the rate Id");
        return rateManagmentRepository.save(entity);
    }

    @Override
    public RateModel updateRate(RateModel entity) throws InvalidRateException {
       RateModel rateEntity = rateManagmentRepository.findById(entity.getRateId()).orElse(null);
        if(rateEntity == null)
            throw new InvalidRateException("Rate ID Not Found In RMS");
        new ModelMapper().map(entity,rateEntity);
        return rateManagmentRepository.save(rateEntity);
    }

    @Override
    public SurchargeResponse getRateSurcharge(int id) throws InvalidRateException {
        RateModel rateEntity = rateManagmentRepository.findById(id).orElse(null);
        if(rateEntity==null)
            throw new InvalidRateException("Rate ID Not Found In RMS");
        final String uri = "https://surcharge.free.beeceptor.com/surcharge";
        Surcharge surcharge=restTemplate.getForObject(uri, Surcharge.class);
        SurchargeResponse surchargeResponse=new SurchargeResponse();
        new ModelMapper().map(rateEntity,surchargeResponse);
        surchargeResponse.setSurcharge(surcharge);
        return  surchargeResponse;
    }

    @Override
    public void deleteRate(int id) throws InvalidRateException {
        RateModel rateEntity = rateManagmentRepository.findById(id).orElse(null);
        if(rateEntity==null)
            throw new InvalidRateException("Rate ID Not Found In RMS");
        rateManagmentRepository.delete(rateEntity);
    }
}
