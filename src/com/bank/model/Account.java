package com.bank.model;

import com.bank.constant.AccountType;
import com.bank.util.IdGenerator;

public class Account {
    protected String accountNumber;
    protected User user;
    protected double balance;
    protected AccountType accountType;

    IdGenerator idg = new IdGenerator();

    public Account(User user, double balance, AccountType accountType) {
        this.user = user;
        this.balance = balance;
        this.accountType = accountType;
        accountNumber = idg.generateAccountNumber(accountType);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }

    public void deposit(double amount){
        balance = balance + amount;
    }

    public String withdraw(double amount){
        if (amount > balance) return "Insufficient Balance";
        balance -= amount;
        return "Successfully withdraw";
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                '\'' +
                ", user=" + user +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
