package com.pp.assignment.creditcardchecker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CardDetails extends  BaseEntity{
    private String cardHolderName;
    private String cardNumber;
    private String cardLimit;
}
