/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.ericsson.springcourse.model;

/**
 *
 * @author Training
 */
public enum AccountType {

    LOAN(100), CREDIT(200);

    private final Integer code;

    private AccountType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
