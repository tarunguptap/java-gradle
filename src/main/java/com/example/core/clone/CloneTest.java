package com.example.core.clone;
public class CloneTest implements Cloneable {
	
	int age;
	String name;
	
	CloneTest(int a,String n){
		age=a;
		name=n;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CloneTest obj1=new CloneTest(2, "j");
		CloneTest obj2=null;
		try {
			obj2=(CloneTest) obj1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj1.getAge());
		System.out.println(obj2.getAge());
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());

	}
	

}
