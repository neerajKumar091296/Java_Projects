package Bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private  List<BankAccount> bankList;

    public Bank() {
        bankList = new ArrayList<>();
        System.out.println("Bank System initialized");
    }

    public void addAccount(BankAccount account) {

        if (account == null) {
            System.out.println("Account is not present in bankList");
            return;
        }

        if (bankList.contains(account)) {
            System.out.println("Account already exists");
            return;
        }

        bankList.add(account);
        System.out.println("Account added successfully");


    }

    public void displayAllAccounts() {

        if(bankList.isEmpty()) {
            System.out.println("No accounts available");
            return;
        }


        for(BankAccount Account: bankList) {
            System.out.println(Account);
        }

    }







}
