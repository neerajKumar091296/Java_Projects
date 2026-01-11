package Bank;

public class Main {

    static void main(String[] args) {
        Bank bank = new Bank ();

        BankAccount TestAccount1 = new BankAccount ("1234","TestAccount", 100);
        bank.addAccount(TestAccount1);

        BankAccount found = bank.findAccountByNumber("768");

        if (found != null) {
            System.out.println("Account found:");
            System.out.println(found);
        } else {
            System.out.println("Account not found");
        }


    }
}
