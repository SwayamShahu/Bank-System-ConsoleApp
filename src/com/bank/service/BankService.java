package com.bank.service;

import com.bank.model.Account;

public interface BankService {
    void createAccount();
    void depositMoney();
    void withdrawMoney(Account acc, double amount);
    void showAccountDetail();
    void showAllAccount();
}
