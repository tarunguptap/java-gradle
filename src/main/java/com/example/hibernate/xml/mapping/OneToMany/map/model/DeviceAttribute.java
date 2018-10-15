package com.example.hibernate.xml.mapping.OneToMany.map.model;

import com.example.hibernate.xml.mapping.OneToMany.map.model.PersistentEntity;

import com.example.hibernate.xml.mapping.OneToMany.map.enums.DeviceAttributeType;

public class DeviceAttribute extends PersistentEntity{
	 private static final long serialVersionUID = 1L;

	    private DeviceAttributeType deviceAttributeType;

	    private String value;

	    private ManufacturerDevice manufacturerDevice;
	    
	    public  DeviceAttribute(){
	    	
	    }
	    
	    public  DeviceAttribute(DeviceAttributeType deviceAttributeType,String value){
	    	this.deviceAttributeType=deviceAttributeType;
	    	this.value=value;
	    }
	    
	    public ManufacturerDevice getManufacturerDevice() {
	        return manufacturerDevice;
	    }

	    public void setManufacturerDevice(ManufacturerDevice manufacturerDevice) {
	        this.manufacturerDevice = manufacturerDevice;
	    }
		public DeviceAttributeType getDeviceAttributeType() {
			return deviceAttributeType;
		}

		public void setDeviceAttributeType(DeviceAttributeType deviceAttributeType) {
			this.deviceAttributeType = deviceAttributeType;
		}

		public String getValue() {
	        return value;
	    }

	    public void setValue(String value) {
	        this.value = value;
	    }
	    
	    @Override
	    public String toString() {
	    	// TODO Auto-generated method stub
	    	return deviceAttributeType + "|" + value + "||   " + manufacturerDevice;
	    }
}
