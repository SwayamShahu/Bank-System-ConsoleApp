package com.bank.service;

import com.bank.exception.AccountNotFound;
import com.bank.model.Account;
import com.bank.model.CurrentAccount;
import com.bank.model.SavingAccount;
import com.bank.model.User;
import com.bank.repository.BankRepository;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BankServiceImpl implements BankService {
    String name, mobileNumber, address, email;
    double balance;
    Account acc = null;

    @Override
    public void createAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Detail: ");
        System.out.print("Enter User name: ");
        name = sc.nextLine();
        System.out.println();

        System.out.print("Enter mobile number; ");
        mobileNumber = sc.nextLine();
        System.out.println();

        System.out.print("Enter User address: ");
        address = sc.nextLine();
        System.out.println();

        System.out.print("Enter email address: ");
        email = sc.nextLine();
        System.out.println();

        User u1 = new User(name, mobileNumber, address, email);

        System.out.print("Enter minimum balance amount to be added: ");
        balance = sc.nextDouble();
        System.out.println();

        System.out.println("Enter 1. Creating Saving Account");
        System.out.println("      2. Creating Current Account");

        int type = sc.nextInt();

        if (type == 1){
            while (balance < 1000){
                System.out.print("Balance should be greater than 1000");
                balance = sc.nextDouble();
                System.out.println();
            }
            acc = new SavingAccount(u1, balance);
        }else if (type == 2){
            acc = new CurrentAccount(u1, balance);
        }else{
            System.out.println("Wrong value... ");
        }

        BankRepository.accouts.put(acc.getAccountNumber(), acc);
        String record = LocalDateTime.now() + " | " + " credit " + " | " + balance;
        BankRepository.transaction.add(record);
    }

    @Override
    public void depositMoney() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();
        System.out.println();
        Account acc = BankRepository.accouts.get(accountNumber);
        if (acc == null){
            throw new AccountNotFound();
        }

        System.out.print("Enter the amount to be deposited: ");
        double amount = sc.nextDouble();
        System.out.println();

        acc.deposit(amount);

        String record = LocalDateTime.now() + " | " + " credit " + " | " + amount + " | ";
        BankRepository.transaction.add(record);
        System.out.println("Amount deposited succesfully");
    }

    @Override
    public void withdrawMoney(Account acc, double amount) {

    }

    @Override
    public void showAccountDetail() {

    }

    @Override
    public void showAllAccount() {

    }
}
