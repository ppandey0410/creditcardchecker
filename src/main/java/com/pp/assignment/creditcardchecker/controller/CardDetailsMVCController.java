package com.pp.assignment.creditcardchecker.controller;

import com.pp.assignment.creditcardchecker.entity.CardDetails;
import com.pp.assignment.creditcardchecker.model.CardDetailsObj;
import com.pp.assignment.creditcardchecker.service.CardDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * CardDetailsMVCController is usual Http controller for handling request/response
 * This is written addionally to show a working applicaton although the rest controller also serves
 * the purpose.
 */

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
    public String addCardDetails(@Valid CardDetailsObj cardDetailsObj, Errors bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            System.out.println("Errors...");
            System.out.println(bindingResult.getAllErrors());
            model.addAttribute("cardDetailsObj",new CardDetailsObj());
            return "redirect:/show-card-details";
        }
        cardDetailsService.saveCardDetails(cardDetailsObj);
        return "redirect:/show-card-details";
    }

}
