# Serialization : Its a mechanism of writing the state of an object into a byte stream.
# De-Serialization : is the process of re-constructing the object from the serialized state.
# Serializable interface:Serializable is a marker interface (has no data member and method). 
						It is used to "mark" java classes so that objects of these classes may get certain capability.
						It must be implemented by the class whose object you want to persist. 
						It must be implemented by the class whose object you want to persist. 
# Java Serialization with Inheritance (IS-A Relationship) : 
	If a class implements serializable then all its sub classes will also be serializable.