package com.bank.repository;

import com.bank.model.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankRepository {
    public static Map<String, Account> accouts = new HashMap<>();
    public static List<String> transaction = new ArrayList<>();

    // prevent object creation
    private BankRepository(){

    }
}
