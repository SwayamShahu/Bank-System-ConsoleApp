package com.bank.app;

import com.bank.model.Account;
import com.bank.model.CurrentAccount;
import com.bank.model.SavingAccount;
import com.bank.model.User;
import com.bank.repository.BankRepository;
import com.bank.service.BankServiceImpl;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        BankServiceImpl bs = new BankServiceImpl();
        while (true){
            System.out.println("----- Bank Application -----");
            System.out.println("Enter 1: To create a new account");
            System.out.println("Enter 2: To deposit money");
            System.out.println("Enter 3: To withdraw amount");
            System.out.println("Enter 4: To show account detail");
            System.out.println("Enter 5: To show all account detail");
            System.out.println("Enter 6: Exit");
            System.out.print("Please Enter: ");
            choice = sc.nextInt();
            System.out.println();
            System.out.println("----------------------------");

            switch (choice){
                case 1:
                    bs.createAccount();
                    break;
                case 2:
                    bs.depositMoney();
                    break;
                case 3:
                    bs.withdrawMoney();
                    break;
                case 4:
                    bs.showAccountDetail();
                    break;
                case 5:
                    bs.showAllAccount();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid Input.");
                    break;
            }
        }
    }
}
