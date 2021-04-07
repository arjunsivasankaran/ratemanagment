package com.example.ratemanagment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "RATE")
public class RateModel {

    @Id
    @Column(name = "RATEID")
    @JsonProperty("rateId")
    private int rateId;

    @Column(name = "RATEDESCRIPTION")
    @JsonProperty("ratedescription")
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "RATEEFFECTIVEDATE", nullable = false)
    private LocalDateTime rateEffectiveDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "RATEEXPIRATIONDATE", nullable = false)
    private LocalDateTime rateExpirationDate;

    @Column(name = "AMOUNT", nullable = false)
    @JsonProperty("amount")
    private int amount;
}
