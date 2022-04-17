package com.pp.assignment.creditcardchecker.controller;

import com.pp.assignment.creditcardchecker.entity.CardDetails;
import com.pp.assignment.creditcardchecker.model.CardDetailsObj;
import com.pp.assignment.creditcardchecker.service.CardDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = {CardDetailsControllerTest.class})
@WebMvcTest(CardDetailsController.class)
@ComponentScan(basePackages = "com.pp")
class CardDetailsControllerTest {
    @Autowired
    WebApplicationContext wac;

    @MockBean
    private CardDetailsService cardDetailsService;

    @Autowired private MockMvc mockMvc;
    @Test
    void saveCardDetails() throws Exception {

        String json =  "{\"cardHolderName\": \"Test Test\",\n" +
                "                \"cardNumber\": \"4111111111111111\",\n" +
                "                \"cardLimit\": \"1200\"\n" +
                "    }";
        CardDetailsObj cardDetailsObj = new CardDetailsObj();
        cardDetailsObj.setCardHolderName("Test Test");
        cardDetailsObj.setCardNumber("1234123412341234");
        cardDetailsObj.setCardLimit("1200");
        Mockito.when(cardDetailsService.saveCardDetails(cardDetailsObj)).thenReturn(getDetails());
        mockMvc.perform(post("/card/add").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk());
    }

    @Test
    void getCardDetails() throws Exception {
        List<CardDetails> list = (List<CardDetails>) Arrays.asList(getDetails());
        Mockito.when(cardDetailsService.getCardDetails()).thenReturn(list);
        mockMvc.perform(get("/card/getall"))
                .andExpect(status().isOk());

    }

    private CardDetails getDetails(){
        return new CardDetails(
                "Test Test",
                "1234123412341234",
                "1200");
    }
}