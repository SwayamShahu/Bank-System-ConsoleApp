package com.bank.service;

import com.bank.exception.AccountNotFound;
import com.bank.model.Account;
import com.bank.model.CurrentAccount;
import com.bank.model.SavingAccount;
import com.bank.model.User;
import com.bank.repository.BankRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

        System.out.print("Enter mobile number: ");
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
        System.out.println("Account Created.");
        String record = LocalDateTime.now() + " | " + " credit " + " | " + balance;
        ArrayList<String> list = new ArrayList<>();
        list.add(record);
        BankRepository.transactions.put(acc.getAccountNumber(),list);
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
        BankRepository.transactions.get(acc.getAccountNumber()).add(record);
        System.out.println("Amount deposited succesfully");
    }

    @Override
    public void withdrawMoney() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account Number: ");
        String accountNumber = sc.nextLine();
        System.out.println();

        Account acc = BankRepository.accouts.get(accountNumber);
        if (acc == null){
            throw new AccountNotFound();
        }
        System.out.print("Enter the amount to be withdraw: ");
        double amount = sc.nextDouble();
        System.out.println();
        acc.withdraw(amount);

        String record = LocalDateTime.now() + " | " + " debited " + " | " + amount + " | ";
        BankRepository.transactions.get(acc.getAccountNumber()).add(record);
        System.out.println("Amount withdraw succesfully");
    }

    @Override
    public void showAccountDetail() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the account number: ");
        String accountNumber = sc.nextLine();
        System.out.println();

        Account acc = BankRepository.accouts.get(accountNumber);
        System.out.println(acc);

        String record = LocalDateTime.now() + " | " + " check detail " ;
        BankRepository.transactions.get(acc.getAccountNumber()).add(record);
        System.out.println("Account detail display successfully");
    }

    @Override
    public void showAllAccount() {
        System.out.println("Account available: ");

        for (String accountNumber: BankRepository.accouts.keySet()){
            Account acc = BankRepository.accouts.get(accountNumber);
            System.out.println(acc);
        }
    }

    @Override
    public void showTransaction() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the page limit: ");
        int limit = sc.nextInt();

        System.out.println("Enter the page number: ");
        int pageNumber = sc.nextInt();
        int startIndex = (pageNumber - 1) * limit;

        sc.nextLine();

        System.out.println("Enter account number: ");
        String accountNumber = sc.nextLine();

        ArrayList<String> list = BankRepository.transactions.get(accountNumber);

        for (int i = startIndex; i < startIndex + limit && i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
