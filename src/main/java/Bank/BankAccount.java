package Bank;

public class BankAccount {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount (String accountNumber, String accountHolderName, double balance) {


        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }

        if (accountHolderName == null || accountHolderName.isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }




        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {

        if (amount <= 0 ) {
            System.out.println("Your deposit value should not be less than zero");
            return;
        }

        this.balance += amount;
        System.out.println("You Available balance is : "+ this.balance);

    }

    public  void  withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdraw should not be equal to zero or less than zero");
            return;
        }
        if (amount > balance) {
            System.out.println("Enter a Valid Withdraw amount");
            return;
        }

        this.balance -= amount;

    }

    @Override

    public String toString() {

        return  "Bank Account Details \n" +
                "Account Number: "  + accountNumber + "\n" +
                "Account Holder Name: " + accountHolderName + "\n"+
                "Balance: " + balance;

    }

    public  double getBalance() {
        return  balance;
    }

    @Override
    public boolean equals(Object object) {

        if(this == object) {
            return  true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        BankAccount other = (BankAccount) object;

        return this.accountNumber.equals(other.accountNumber);


    }

    @Override
    public  int hashCode() {
        return  accountNumber.hashCode();
    }






}
