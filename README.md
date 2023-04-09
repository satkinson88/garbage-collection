### **Concepts behind stack memory**
The stack memory is functions as a last in first out order, hence the name stack, and it contains primitive values (int, double, boolean etc) and references to objects in the heap.
This last in first out function makes the stack memory much quicker to access. Variables inside stack exist only as long as the method that created them is running.
Examples of this in the Demo class would be the var1, var2, nullify and anon variables which are the references to the objects themselves in the heap memory.

### **Concepts behind heap memory**

The heap memory on the other hand is a dynamic form of memory for java objects and classes at runtime. This is where the new objects are actually created. It is separated into
further parts namely young generation, old generation and permanent generation. The young generation is where all new objects are allocated. Here we have eden space, where objects
using keyword new are put and survivor space, where objects which survived garbage collection then go. For the young generation the minor garbage collector is running continuously (or more
accurately when it needs to). The old generation is for objects which survived garbage collection from young generation. Eventually the old generation needs to be collected and
this event is called a major garbage collection. This contains the tenured space for objects that survived multiple garbage collections from the young generation. The permanent
generation is for permanent class metadata and descriptors.

### **The finalize method**

In the Demo example we forcefully call the garbage collector so that we can see what is being garbage collected. Upon calling the garbage collector the finalize method runs
and releases resources used by objects before they're removed from the memory. The finalizer may perform any operations, including bringing the object back to life. In Demo we merely
print what is being collected.

https://stackoverflow.com/questions/2129044/java-heap-terminology-young-old-and-permanent-generations
https://www.baeldung.com/java-stack-heap
https://www.baeldung.com/java-finalize
