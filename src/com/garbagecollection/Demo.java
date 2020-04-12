package com.garbagecollection;

import com.scopeofvariables.BankAccount;

class Demo {

    // instance variable at class level to store object name
    String obj_name;

    //when we create a Demo object the constructor will be invoked requiring us to pass in a string for our object name
    public Demo(String obj_name) {
        //this keyword refers to the instance variable
        this.obj_name = obj_name;
    }
    /* When a method is called it goes inside the stack frame but the stack itself doesn't contain anything that can be garbage-collected. When
    the method is popped from the stack(completed its execution), all its members dies and if some references to objects were created inside it
    then these objects are now unreachable - thus eligible for garbage collection
     */
    //Note: Access to stack memory is fast when compared to heap memory

    static void show()
    {
        /* object reference 'ref1' is removed from the stack after show() has executed thus the object itself which,
        is stored in heap, is now unreachable thus eligible for garbage collection. We call the 'display' method here thus
        it will complete its execution before 'show' method therefore we'd expect to see it garbage collected first if we call 'show'.
        */
        Demo ref1 = new Demo("ref1");
        display();

    }
    static void display()
    {
        /* object reference 'ref2' is removed from the stack after display() has executed thus the object itself, which
        is stored in heap, is now unreachable thus eligible for garbage collection
         */
        Demo ref2 = new Demo("ref2");
    }

    public static void main(String args[]) throws InterruptedException {

        show();
        Thread.sleep(2000);
        System.gc();

        Demo var1 = new Demo("var1");
        Demo var2 = new Demo("var2");

        /* When reassigning a variable the reference id of one object is referenced to reference id of some other object then
        the previous object has no any longer reference to it and becomes unreachable and thus becomes eligible for garbage collection
        */
        //reference to var1 becomes unreachable when making it equal to var2 thus var1 becomes eligible for garbage collection
        var1=var2;
        Thread.sleep(2000);
        System.gc();

        /* When all the reference variables of an object are changed to NULL,
        it becomes unreachable and thus becomes eligible for garbage collection
        */
        Demo nullify = new Demo("nullify");
        nullify=null;
        Thread.sleep(2000);
        System.gc();

        /* The reference id of an anonymous object is not stored anywhere. Hence, it becomes unreachable.
        */
        new Demo("anon");
        Thread.sleep(2000);
        System.gc();

        BankAccount bank2 = new BankAccount(12, "Jason", 5000.0); // second constructor with parameters
        System.out.println(bank2);
    }

    @Override
    /* The finalize method is used to perform some final operations or clean up operations on an object before it is
    removed from the memory. Here we define a behaviour that's specific to the subclass type, which means the subclass
    can implement the parent class method based on its requirement. In this case we are asking the finalize method to
    print the name of the instance variable eligible for garbage collection.
    */
    protected void finalize() throws Throwable
    {
        System.out.println(this.obj_name + " successfully garbage collected");
    }
}



