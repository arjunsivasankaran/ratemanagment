package com.example.ratemanagment.repository;

import com.example.ratemanagment.model.RateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateManagmentRepository extends JpaRepository<RateModel,Integer> {
}
