package com.scopeofvariables;

public class BankAccount {

    // instance variables at class level
    // Instance variables are created when an object is created with the use of the keyword 'new' and destroyed when the object is destroyed.
    protected int accNum;            // protected access
    protected String name;           // -- accessible inside "BankAccount"
    protected double balance;        // -- and inside any derived class

    /* ====================================================
       Default Constructor
       ==================================================== */

    public BankAccount( )
    {
        accNum = -1;
        name = "Nobody";
        balance = 0.0;
    }
    /* ====================================================
       2nd Constructor: initializes all 3 instance variables
       ==================================================== */
    public BankAccount(int a, String n, double amount)
    {
        accNum = a;
        name = n;
        balance = amount;
    }

    /* ==============================================
       transact(amount): Add "amount" to balance
       ============================================== */
    //void methods do not need to return a value
    public void transaction( double amount )
    {
        balance += amount;
    }
    //static methods can be accessed before any object is created
    //make this method static since we want to look up an account without creating an instance of the BankAccount class
    public static void lookupAccount (String accName) {
        System.out.println("Looking for account " + accName + " ...");
    }

    /* ==============================================
       toString(): allows us to represent any object as a string.
       This particular method returns a String containing information of BankAccount.
       ============================================== */
    public String toString(  )
    {
        return( "Account number: "  + accNum
                + ", Name: "  + name
                + ", Balance: " + balance);
    }
}
