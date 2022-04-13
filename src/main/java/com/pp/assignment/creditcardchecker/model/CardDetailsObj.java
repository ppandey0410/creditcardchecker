package com.pp.assignment.creditcardchecker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDetailsObj {

    private String cardHolderName;
    private String cardNumber;
    private String cardLimit;
}
