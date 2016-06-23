package com.example.common.pojo;

public class ModelSub 
{
	private String uid;
	private String uname;
	
	public ModelSub(){
		
	}
	
	public ModelSub(String uid, String uname){
		this.uid=uid;
		this.uname=uname;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString()
	{
		return new StringBuffer()
		.append(" userid : "+uid)
		.append(" | username : "+uname).toString();
	}
}
