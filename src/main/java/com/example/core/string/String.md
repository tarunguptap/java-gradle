# String

There are slight differences between the various methods of creating a String object. String allocation, like all object allocation, proves costly in both time and memory. The JVM performs some trickery while instantiating string literals/objects to increase performance and decrease memory overhead. To cut down the number of String objects created, JVM maintains a special memory called String literal pool or String constant pool.
Each time your code creates a string literal, the JVM checks the string literal pool first. If the string already exists in the pool, a reference to the pooled instance is returned. If the string does not exist in the pool, a new String object is created and placed in the pool. JVM keeps at most one object of any String in this pool. String literals always refer to an object in the string pool.

public class StringConstantPool {
	public static void main(String[] args) {
	String s = "prasad";
	String s2 = "prasad";
	String s3 = new String("prasad"); 
 
	System.out.println(s.equals(s2));
	System.out.println(s == s2);
	System.out.println(s.equals(s3));
	System.out.println(s == s3);
	}
}
Output is :
true
true
true
false

Now lets know what happens here step by step :
1.	The class is loaded when JVM is invoked. 
2.	JVM will look for all the string literals in the program 
3.	First, it finds the variable s which refers to the  literal prasad and it will be created in the memory 
4.	A reference for the literal prasad will be placed in the string constant pool memory. 
5.	Then it finds another variable s2 which is referring to the same string literal prasad 
6.	Now that JVM has already found a string literal prasad, both the variables s and s2 wil refer to the same object i.e. prasad. 
7	Now we have looked into the case when string literals are created without using the new operator 
8	As we are invoking the new keyword, The object prasad will be created when the new String(prasad) is invoked. This is unlike the string literal prasad which is created when class is loaded. Now the values of objects referenced by variable s and variable s2 are the same i.e. prasad but those are not the same objects. They refer to different objects. 
    e.g. "Java". These double quoted literal is known as String literal and the cache which stored these String instances are known as as String pool.  In earlier version of Java, I think up-to Java 1.6 String pool is located in permgen area of heap, but in Java 1.7 updates its moved to main heap area.
10.	String objects created with the new operator do not refer to objects in the string pool but can be made to using Strings intern() method. The java.lang.String.intern() returns an interned String, that is, one that has an entry in the global String literal pool. If the String is not already in the global String literal pool, then it will be added. 
11. All the string literals are created and their references are placed in the pool while JVM loads the class. So, even before a statement like this String s1 = new String(iByteCode); is executed, the string literal pool contains a reference to iByteCode 
12.	An object is eligible for garbage collection when it is no longer referenced from an active part of the application. In the case of String literals, they always have a reference to them from the String Literal Pool and are, therefore, not eligible for garbage collection. 
13.	Because java uses the concept of string literal.Suppose there are 5 reference variables,all referes to one object "sachin".If one reference variable changes the value of the object, it will be affected to all the reference variables. That is why string objects are immutable in java. 
 