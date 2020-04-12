package com.scopeofvariables;

public class CheckingAccount extends BankAccount
{
    /* Inherits the following from BankAccount class:
       Variables: accNum, name, balance
       Methods: transaction(amount)
    */

    /* ----------------------------------------------
       Constructor: CheckingAccount(a, n, amount)
       ---------------------------------------------- */
    public CheckingAccount(int a, String n, double amount)
    {
        accNum = a;          // Protected variables can be accessed by the CheckingAccount child class
        name = n;            // Change to private in BankAccount and notice the error
        balance = amount;
    }

    public void transfer( BankAccount toAccount, double amount )
    {
        //this.withdraw(amount);      // deduct amount from this account;
        toAccount.transaction(amount);  // add amount to "toAccount";
    }
}
