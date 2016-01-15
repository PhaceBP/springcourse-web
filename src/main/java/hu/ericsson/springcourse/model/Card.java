/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ericsson.springcourse.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Training
 */
public class Card extends BusinessObject {
    
    private String cardNumber;
    
    private Long accountId;
    
    private Long customerId;
    
    private CardType cardType;
    
    private Date validTo;
    

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 53 * hash + Objects.hashCode(this.cardNumber);
        hash = 53 * hash + Objects.hashCode(this.accountId);
        hash = 53 * hash + Objects.hashCode(this.customerId);
        hash = 53 * hash + Objects.hashCode(this.cardType);
        hash = 53 * hash + Objects.hashCode(this.validTo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (!Objects.equals(this.cardNumber, other.cardNumber)) {
            return false;
        }
        if (!Objects.equals(this.accountId, other.accountId)) {
            return false;
        }
        if (!Objects.equals(this.customerId, other.customerId)) {
            return false;
        }
        if (!Objects.equals(this.validTo, other.validTo)) {
            return false;
        }
        return true;
    }
    
    
    
}
