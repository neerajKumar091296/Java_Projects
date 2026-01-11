package Bank;

public class Main {

    static void main(String[] args) {
        Bank bank = new Bank ();

        BankAccount TestAccount1 = new BankAccount ("1234","TestAccount", 100);
        BankAccount TestAccount2 = new BankAccount ("8723", "TestAccount2", -100);
        bank.addAccount(TestAccount1);
        bank.addAccount (TestAccount2);

        TestAccount2.withdraw(10);


    }
}
