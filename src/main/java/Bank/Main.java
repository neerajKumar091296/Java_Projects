package Bank;

public class Main {

    static void main(String[] args) {
        Bank bank = new Bank ();

        BankAccount TestAccount1 = new BankAccount ("1234","TestAccount", 100);
        bank.addAccount(TestAccount1);


    }


}

