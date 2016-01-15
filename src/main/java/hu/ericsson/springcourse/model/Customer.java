/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ericsson.springcourse.model;


import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Training
 */
public class Customer extends BusinessObject {
    
    
    private String firstName;
    
    private String lastName;
    
    private Date birthDate;
    
    private String nameOfMother;
    
    private String identityCardNumber;
    
    private GenderType gender;
    
    private List<Long> accountIds;
    
    private List<Long> cardIds;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNameOfMother() {
        return nameOfMother;
    }

    public void setNameOfMother(String nameOfMother) {
        this.nameOfMother = nameOfMother;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public List<Long> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<Long> accountIds) {
        this.accountIds = accountIds;
    }

    public List<Long> getCardIds() {
        return cardIds;
    }

    public void setCardIds(List<Long> cardIds) {
        this.cardIds = cardIds;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 59 * hash + Objects.hashCode(this.firstName);
        hash = 59 * hash + Objects.hashCode(this.lastName);
        hash = 59 * hash + Objects.hashCode(this.birthDate);
        hash = 59 * hash + Objects.hashCode(this.nameOfMother);
        hash = 59 * hash + Objects.hashCode(this.identityCardNumber);
        hash = 59 * hash + Objects.hashCode(this.gender);
        hash = 59 * hash + Objects.hashCode(this.accountIds);
        hash = 59 * hash + Objects.hashCode(this.cardIds);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        if (!Objects.equals(this.nameOfMother, other.nameOfMother)) {
            return false;
        }
        if (!Objects.equals(this.identityCardNumber, other.identityCardNumber)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        if (!Objects.equals(this.accountIds, other.accountIds)) {
            return false;
        }
        if (!Objects.equals(this.cardIds, other.cardIds)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
      return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", nameOfMother=" + nameOfMother + ", identityCardNumber=" + identityCardNumber + ", gender=" + gender + "]";
    }
    
    
    
    
}
