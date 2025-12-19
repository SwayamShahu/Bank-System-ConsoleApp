package com.bank.model;

import com.bank.constant.AccountType;

public class SavingAccount extends Account{

    private static final double MIN_BALANCE = 1000;

    public SavingAccount(User user, double balance){
        super(user, balance, AccountType.SAVING);
    }

    public double getMinBalance(){
        return MIN_BALANCE;
    }

}
