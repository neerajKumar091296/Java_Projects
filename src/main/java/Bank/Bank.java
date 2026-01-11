package Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private final Map<String, BankAccount> bankList;

    public Bank() {
        bankList = new HashMap<>();
        System.out.println("Bank System initialized");
    }

    public void addAccount(BankAccount account) {

        if(account == null || bankList.containsKey(account.getAccountNumber())) {
            System.out.println("Bank Account Already Added.!!");
            return;
        }

        bankList.put(account.getAccountNumber(),account);


    }

    public void displayAllAccounts() {

        if(bankList.isEmpty()) {
            System.out.println("No accounts available");
            return;
        }


        for(Map.Entry<String, BankAccount> entry: bankList.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }




    }

    public BankAccount findAccountByNumber(String accountNumber) {

        if (accountNumber == null || accountNumber.isEmpty()) {
            return  null;
        }

        return bankList.get(accountNumber);




        }

    }




