package com.pp.assignment.creditcardchecker.service;

import com.pp.assignment.creditcardchecker.entity.CardDetails;
import com.pp.assignment.creditcardchecker.model.CardDetailsObj;
import com.pp.assignment.creditcardchecker.repository.CardDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * CardDetailsService is the service class which exposes methods to save/add new card details
 * and list all the existing card information.
 *
 * @author  Prakash Pandey
 * @version 1.0
 * @since   2022-04-14
 */
@Service
public class CardDetailsService {

    @Autowired
    private CardDetailsRepository cardDetailsRepository;

    /**
     * @param cardDetailsObj
     * @return CardDetails
     *
     * @author  Prakash Pandey
     * @version 1.0
     * @since   2022-04-14
     */
    public CardDetails saveCardDetails(CardDetailsObj cardDetailsObj) {
        return cardDetailsRepository.save(getCardDetails(cardDetailsObj));
    }

    /**
     * @param cardDetailsObj - Object of CardDetailsObj class
     * @return CardDetails
     *
     * @author  Prakash Pandey
     * @version 1.0
     * @since   2022-04-14
     */
    private CardDetails getCardDetails(CardDetailsObj cardDetailsObj) {
        final CardDetails  cardDetails = new CardDetails();
        cardDetails.setCardHolderName(cardDetailsObj.getCardHolderName());
        cardDetails.setCardNumber(cardDetailsObj.getCardNumber());
        cardDetails.setCardLimit( cardDetailsObj.getCardLimit() );
        return cardDetails;
    }

    /**
     *
     * @return List of CardDetails Objects
     *
     * @author  Prakash Pandey
     * @version 1.0
     * @since   2022-04-14
     */
    public List<CardDetails> getCardDetails() {
        List<CardDetails> cardDetails = cardDetailsRepository.findAll();
        return cardDetails;
    }

/*
    public List<CardDetails> saveAllCardDetail(List<CardDetails> cardDetails) {
        cardDetailsRepository.saveAll(cardDetails);
        return getCardDetails();
    }

*/

}
