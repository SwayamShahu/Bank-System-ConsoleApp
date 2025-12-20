package com.bank.app;

import com.bank.service.BankServiceImpl;
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
            System.out.println("Enter 6: To see transaction");
            System.out.println("Enter 7: Exit");
            System.out.print("Please Enter: ");
            choice = sc.nextInt();
            System.out.println("----------------------------");

            switch (choice){
                case 1:
                    bs.createAccount();
                    System.out.println("----------------------------");
                    break;
                case 2:
                    bs.depositMoney();
                    System.out.println("----------------------------");
                    break;
                case 3:
                    bs.withdrawMoney();
                    System.out.println("----------------------------");
                    break;
                case 4:
                    bs.showAccountDetail();
                    System.out.println("----------------------------");
                    break;
                case 5:
                    bs.showAllAccount();
                    System.out.println("----------------------------");
                    break;
                case 6:
                    bs.showTransaction();
                    System.out.println("----------------------------");
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid Input.");
                    System.out.println("----------------------------");
                    break;
            }
        }
    }
}
