package com.pp.assignment.creditcardchecker.controller;

import com.pp.assignment.creditcardchecker.entity.CardDetails;
import com.pp.assignment.creditcardchecker.model.CardDetailsObj;
import com.pp.assignment.creditcardchecker.service.CardDetailsService;
import com.pp.assignment.creditcardchecker.validation.LuhnCardValidator;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardDetailsController {

    @Autowired
    private CardDetailsService cardDetailsService;

    @PostMapping("/carddetails")
    public CardDetails saveCardDetails(@RequestBody CardDetailsObj cardDetailsObj) {
        boolean validateCard = LuhnCardValidator.validateCreditCardNumber(cardDetailsObj.getCardNumber());

        if(validateCard)
            return cardDetailsService.saveCardDetails(cardDetailsObj);
        else
            return new CardDetails();
    }


    @GetMapping("/carddetails")
    public List<CardDetails> getCardDetails() {
        return cardDetailsService.getCardDetails();
    }


}