package com.garbagecollection;

public class GarbageCollection {

    public static void main(String[] args) throws Throwable {

        Reassign rv = new Reassign();
        Nullify nv = new Nullify();

        Reassign.reassignVariable();
        rv.finalize();

        Nullify.nullifyVariable();
        nv.finalize();
    }
}

class Reassign
        /*
        When reference id of one object is referenced to reference id of some other object then the previous object
        has no any longer reference to it and becomes unreachable and thus becomes eligible for garbage collection
        */
{
    String obj_name;

    public Reassign(String obj_name)
    {
        this.obj_name = obj_name;
    }

    public Reassign() {

    }

    public static void reassignVariable() throws InterruptedException {
        Reassign variable1 = new Reassign("variable1");
        Reassign variable2 = new Reassign("variable2");
        variable1=variable2;
        System.gc();
        Thread.sleep(1000);
    }

    /*
    finalize() method is a protected and non-static method of java.lang.Object class. This method will be available in all objects you create in java.
    This method is used to perform some final operations or clean up operations on an object before it is removed from the memory.
    You can override the finalize() method to keep those operations you want to perform before an object is destroyed.
    Here is the general form of finalize() method.
    */

    @Override
    protected void finalize()
    {
        System.out.println(this.obj_name + " successfully garbage collected");
    }

}

class Nullify
        /*
        When all the reference variables of an object are changed to NULL, it becomes
        unreachable and thus becomes eligible for garbage collection
        */
{
    String obj_name;

    public Nullify(String obj_name)
    {
        this.obj_name = obj_name;
    }

    public Nullify() {

    }

    public static void nullifyVariable () throws InterruptedException {
        Nullify nullify1 = new Nullify("nullify1");
        nullify1=null;
        System.gc();
        Thread.sleep(1000);
    }

    @Override
    protected void finalize()
    {
        System.out.println(this.obj_name + " successfully garbage collected");
    }
}

