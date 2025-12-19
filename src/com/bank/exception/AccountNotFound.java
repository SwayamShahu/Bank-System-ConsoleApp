package com.bank.exception;

public class AccountNotFound extends RuntimeException{
    public AccountNotFound(){
        super("Account Number is incorrect");
    }
}
