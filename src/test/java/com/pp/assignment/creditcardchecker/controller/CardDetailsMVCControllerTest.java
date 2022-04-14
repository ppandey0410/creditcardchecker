package com.pp.assignment.creditcardchecker.controller;

import com.pp.assignment.creditcardchecker.entity.CardDetails;
import com.pp.assignment.creditcardchecker.model.CardDetailsObj;
import com.pp.assignment.creditcardchecker.service.CardDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = {CardDetailsMVCController.class})
@WebMvcTest(CardDetailsMVCController.class)
class CardDetailsMVCControllerTest {
    @Autowired
    WebApplicationContext wac;

    @MockBean private CardDetailsService cardDetailsService;


    @Autowired private MockMvc mockMvc;

    @Test
    void index() throws Exception {
        MockitoAnnotations.openMocks(this);
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()).andExpect(view().name("index"));
    }

    @Test
    void showCardDetails() throws Exception {
        CardDetails cardDetails = getCardDetails();
        List<CardDetails> list =  Arrays.asList(cardDetails );
        Mockito.when(cardDetailsService.getCardDetails()).thenReturn(list);
        mockMvc.perform(get("/show-card-details"))
                .andExpect(status().isOk()).andExpect(view().name("index"));

    }


    @Test
    void addCardDetails() throws Exception {
        CardDetailsObj cardDetailsObj = new CardDetailsObj();
        cardDetailsObj.setCardHolderName("Test Test");
        cardDetailsObj.setCardNumber("1234123412341234");
        cardDetailsObj.setCardLimit("1200");
        Mockito.when(cardDetailsService.saveCardDetails(cardDetailsObj)).thenReturn(getCardDetails());
        mockMvc.perform(post("/add-card-details"))
                .andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/show-card-details"));
    }

    private CardDetails getCardDetails() {
        return new CardDetails(
                "Test Test",
                "1234123412341234",
                "1200");
    }

}