package com.bank.service;

import com.bank.model.Account;

public interface BankService {
    void createAccount();
    void depositMoney();
    void withdrawMoney();
    void showAccountDetail();
    void showAllAccount();
}
