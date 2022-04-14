package com.pp.assignment.creditcardchecker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * This is classic POJO class with member variable as
 * cardHolderName
 * cardNumber
 * cardLimit
 *
 *
 *
 * @author  Prakash Pandey
 * @version 1.0
 * @since   2022-04-14
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDetailsObj {

    @Size(min=1, max=32, message="Name must be between 1 and 32 characters")
    private String cardHolderName;

    @Digits(fraction=0,integer = 19)
    @Size(min=12, max=19, message="Card must be between 12 and 19 digit")
    private String cardNumber;

    @NotEmpty(message="Limit cannot be blank")
    @Size(min=1, max=5, message="Card Limit must be between 3 and 5 digit")
    private String cardLimit;
}
