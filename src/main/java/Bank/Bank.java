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


    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount) {

        if (amount <= 0) {
            System.out.println("Amount must be greater than Zero ");
            return;
        }

        // question why does not code booklist.contains(fromaccountNumber). This is not valid
        // In any if I change banklist to new linkedList i need to change this code which is lot of work in real time

        /*
        Because:
            bankList is an implementation detail
            transferFunds() should depend on behavior, not storage
            Today it’s a HashMap
            Tomorrow it could be:
            a database
            a cache
            a remote service
        */

        BankAccount sourceAmount = findAccountByNumber(fromAccountNumber);
        BankAccount destinationAmount = findAccountByNumber(toAccountNumber);

        // Validate account existence
        if (sourceAmount == null || destinationAmount == null) {
            System.out.println("Invalid Source or destination account");
            return;

        }

        /*
        if (fromAccountNumber.isEmpty() || toAccountNumber.isEmpty()){
            System.out.println("Account number should not be empty");
            return;
        }
            - code:
                 BankAccount sourceAmount = findAccountByNumber(fromAccountNumber);
                 BankAccount destinationAmount = findAccountByNumber(toAccountNumber);
                 the above code already handles this case
        */

        if (sourceAmount == destinationAmount) {
            System.out.println("Source and destination cannot be same");
            return;
        }



        BankAccount firstLock;
        BankAccount secondLock;


        if(sourceAmount.getAccountNumber().compareTo(destinationAmount.getAccountNumber()) < 0) {
            firstLock = sourceAmount;
            secondLock = destinationAmount;
        } else {
            firstLock = destinationAmount;
            secondLock = sourceAmount;
        }


        synchronized (firstLock) {
            synchronized (secondLock) {

                if (sourceAmount.getBalance() < amount) {
                    System.out.println("Insufficient balance");
                    return;
                }

            }
        }



        sourceAmount.withdraw(amount);
        destinationAmount.deposit(amount);
        System.out.println("Transfer Successfull");





        }


    }




