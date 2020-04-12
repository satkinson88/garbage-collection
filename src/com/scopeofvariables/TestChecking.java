package com.scopeofvariables;


public class TestChecking
{
    public static void main( String[] args )
    {
        /*Without the toString override in BankAccount, printing account1 and account2 prints the hashcode values of the
        objects but we want to print the values of these objects. Since the java compiler internally calls toString() method,
        overriding this method will return the specified values.*/
        CheckingAccount account1 = new CheckingAccount(123, "John", 1000.0);
        CheckingAccount account2 = new CheckingAccount(12, "Bob", 500.0);

        System.out.println( "account1: " + account1 ); // uses toString() inherited from BankAccount
        System.out.println( "account2: " + account2 );

        BankAccount bank1 = new BankAccount(); // default constructor from BankAccount
        BankAccount bank2 = new BankAccount(12, "Jason", 5000.0); // second constructor with parameters

        System.out.println(bank1);
        System.out.println(bank2);

        //transfer 100 to bank
        //account 2 instantiated from CheckingAccount can access the transfer method in the parent class BankAccount
        //transfers into bank2 100.0 from account2 (not coded here)
        account2.transfer(bank2, 100.0);
        System.out.println(bank2);
        //transfer 10 from bank
        account2.transfer(bank2, -10.0);
        System.out.println(bank2);

        //static method lookupAccount does not require an object to be created
        BankAccount.lookupAccount("Bob");
    }
}
