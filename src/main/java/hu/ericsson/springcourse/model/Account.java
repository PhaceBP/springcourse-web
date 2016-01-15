/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ericsson.springcourse.model;

import java.util.Objects;

/**
 *
 * @author Training
 */
public class Account extends BusinessObject {
    
    
    private String accountNumber;
    
    private Double currentBalance;
    
    private AccountType accountType;
    
    private Long customerId;
    

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    
    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 29 * hash + Objects.hashCode(this.accountNumber);
        hash = 29 * hash + Objects.hashCode(this.currentBalance);
        hash = 29 * hash + Objects.hashCode(this.accountType);
        hash = 29 * hash + Objects.hashCode(this.customerId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(!super.equals(obj)){
            return false;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.customerId, other.customerId)) {
            return false;
        }
        if (!Objects.equals(this.accountNumber, other.accountNumber)) {
            return false;
        }
        if (!Objects.equals(this.currentBalance, other.currentBalance)) {
            return false;
        }
        if (this.accountType != other.accountType) {
            return false;
        }
        return true;
    }

 
    
  


    
    
}
