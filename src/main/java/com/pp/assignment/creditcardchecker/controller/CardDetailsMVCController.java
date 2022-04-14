package com.pp.assignment.creditcardchecker.controller;

import com.pp.assignment.creditcardchecker.entity.CardDetails;
import com.pp.assignment.creditcardchecker.model.CardDetailsObj;
import com.pp.assignment.creditcardchecker.service.CardDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CardDetailsMVCController {

    @Autowired
    private CardDetailsService cardDetailsService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/show-card-details")
    public String showCardDetails(Model model) {

        List<CardDetails> cardDetails = cardDetailsService.getCardDetails();
        model.addAttribute("cardDetails",cardDetails);
        return "index";
    }

    @PostMapping("/add-card-details")
    public String addCardDetails(CardDetailsObj cardDetailsObj, Model model) {
        cardDetailsService.saveCardDetails(cardDetailsObj);
        return "redirect:/show-card-details";
    }

}
