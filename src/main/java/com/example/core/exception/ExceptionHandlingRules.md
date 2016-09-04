# ExceptionHandling with MethodOverriding in Java
* Rule 1 : If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception.
* Rule 2 : If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but can declare unchecked exception.
* Rule 3 : If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception. 
* Rule 4 : If you are calling a method that declares an exception, you must either caught or declare the exception.