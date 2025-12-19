package com.bank.model;

import com.bank.constant.AccountType;

public class CurrentAccount extends Account{
    private final double MAX_BALANCE = 10000000;

    public CurrentAccount(User user, double balance){
        super(user, balance, AccountType.CURRENT);
    }

    public double getMaxBalance(){
        return MAX_BALANCE;
    }
}
