package com.pp.assignment.creditcardchecker.service;

import com.pp.assignment.creditcardchecker.entity.CardDetails;
import com.pp.assignment.creditcardchecker.model.CardDetailsObj;
import com.pp.assignment.creditcardchecker.repository.CardDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardDetailsService {

    @Autowired
    private CardDetailsRepository cardDetailsRepository;

    public CardDetails saveCardDetails(CardDetailsObj cardDetailsObj) {
        return cardDetailsRepository.save(getCardDetails(cardDetailsObj));
    }

    private CardDetails getCardDetails(CardDetailsObj cardDetailsObj) {
        final CardDetails  cardDetails = new CardDetails();
        cardDetails.setCardHolderName(cardDetailsObj.getCardHolderName());
        cardDetails.setCardNumber(cardDetailsObj.getCardNumber());
        cardDetails.setCardLimit( cardDetailsObj.getCardLimit() );
        return cardDetails;
    }

    public List<CardDetails> getCardDetails() {
        List<CardDetails> cardDetails = cardDetailsRepository.findAll();
        if(!CollectionUtils.isEmpty(cardDetails)) {

            cardDetails =  formateCardNumber(cardDetails);
        }
        return cardDetails;
    }

    /**
     *
     * @param cardDetails list of CardDetails
     * @return list of cardDetails
     */
    private List<CardDetails> formateCardNumber(List<CardDetails> cardDetails) {
        if(!CollectionUtils.isEmpty(cardDetails)) {
            cardDetails =    cardDetails.stream().map(x -> {
                        String[] strArray = x.getCardNumber().split("-");
                        for (int i = 1; i < strArray.length; i++) {
                            strArray[i] = strArray[i].replaceAll("\\d", "x");
                        }
                        x.setCardNumber(String.join("-", strArray));
                        return x;
                    }
            ).collect(Collectors.toList());
        }
        return cardDetails;
    }

    public List<CardDetails> saveAllCardDetail(List<CardDetails> cardDetails) {
        cardDetailsRepository.saveAll(cardDetails);
        return getCardDetails();
    }
}
