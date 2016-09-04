# Inner Class

## Defination
Java inner class or nested class is a class i.e. declared inside the class or interface.
We use inner classes to logically group classes and interfaces in one place so that it can be more readable and maintainable.
Additionally, inner class can access all the members of outer class including private data members and methods.

## When to use
There are other situations when you actually need to write some code that seems like it belongs in it’s very own class. 
But, at the same time, the code that you want to write needs to be intimately tied to some other class’s code.

# Advantage of java inner classes
1) Nested classes represent a special type of relationship that is it can access all the members (data members and methods) 
of outer class including private.
2) Nested classes are used to develop more readable and maintainable code because it logically group classes 
and interfaces in one place only.
3) Code Optimization: It requires less code to write.

## Types of Nested classes
There are two types of nested classes non-static and static nested classes.The non-static nested classes are also known as inner classes.
### Non-static nested class(inner class)
        ###* Member inner class : It is a class created with in the class. The inner class can be private
        The java compiler creates two class files in case of inner class. The class file name of inner 
        class is "Outer$Inner". If you want to instantiate inner class, you must have to create the 
        instance of outer class. In such case, instance of inner class is created inside the instance of outer class.
        ###* Annomynous inner class : It is a class created out side of the class. The anonynous class cannot be private. It can public, abstract or final
        A class that have no name is known as anonymous inner class in java. It should be used if you have to override. 
        In case of anonymous inner classes, we declare and instantiate them at the same time.
        method of class or interface. Java Anonymous inner class can be created by two ways:
        ####* Class (may be abstract or concrete)
        ####* Interface
        ###* Local inner class : It is a class created inside of the method of the class.
### Static nested class : A static class i.e. created inside a class is called static nested class in java.
It can only access static data members or methods of outer class including private.

# Inner class is subset of nested classes. Inner class has access to all the members of outer class, where as if inner class 
is the static, then we use the term static nested class because it doesn't have access to all the data members of outer class except static 