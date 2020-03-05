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
        Nullify nullify1 = new Nullify("n1");

        /* g1 being used for some purpose in program */

        /* When there is no more use of t1, make the object
           referred by g1 eligible for garbage collection */

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

