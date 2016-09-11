package com.example.core.garbagecollection;
/**
 * Garbage collection is process of reclaiming the run time unused memory automatically.
 * Garbage collector of jvm collects only those objects that are created by new keyword. 
 * If any object created without that, you can use finalize method for cleanup.
 * There are 3 ways to unreferenced an object :
 * 1. By Nulling the reference (User u1 = new User(); u1==null)
 * 2.By assigining a reference to another object (User u1 = new User(); User u2 = new User(); u1==u2)
 * 			Now first object is available fo gc
 * By Annonymous Object (new User();)
 */
public class TestGarbage {
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Object is garbage collected");
		super.finalize();
	}
	public static void main(String[] args) {
		TestGarbage s1 =  new TestGarbage();
		TestGarbage s2 =  new TestGarbage();
		s1 = null;
		s2 = null;
		System.gc();
	}
}
