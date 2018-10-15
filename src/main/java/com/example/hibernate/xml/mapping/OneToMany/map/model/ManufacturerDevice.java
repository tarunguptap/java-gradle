package com.example.hibernate.xml.mapping.OneToMany.map.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;


import com.example.hibernate.xml.mapping.OneToMany.map.enums.DeviceAttributeType;

public class ManufacturerDevice extends PersistentEntity{
	private static final long serialVersionUID = 1L;

	private String description;
	private String deviceNumber;
	private Boolean active = Boolean.FALSE;
	private Map<DeviceAttributeType, DeviceAttribute> deviceAttributes = new HashMap<DeviceAttributeType, DeviceAttribute>();
	private String destination;
	private Boolean recycle = Boolean.FALSE;
	private Map<DeviceAttributeType, String> deviceAttributeTest = new HashMap<DeviceAttributeType, String>();
	
	public ManufacturerDevice(){
		
	}
	public ManufacturerDevice(String description,String deviceNumber,Boolean active,Map<DeviceAttributeType, DeviceAttribute> deviceAttributes,String destination,Boolean recycle){
		this.description=description;
		this.deviceNumber= deviceNumber;
		this.active=active;
		this.deviceAttributes=deviceAttributes;
		this.description=destination;
		this.recycle=recycle;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Map<DeviceAttributeType, DeviceAttribute> getDeviceAttributes() {
		return deviceAttributes;
	}
	public void setDeviceAttributes(Map<DeviceAttributeType, DeviceAttribute> deviceAttributes) {
		this.deviceAttributes = deviceAttributes;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Boolean getRecycle() {
		return recycle;
	}
	public void setRecycle(Boolean recycle) {
		this.recycle = recycle;
	}
	public void addDeviceAttribute(DeviceAttribute deviceAttribute) {
		deviceAttribute.setManufacturerDevice(this);
		deviceAttributes.put(deviceAttribute.getDeviceAttributeType(), deviceAttribute);
	}
	public void setDeviceAtribute(DeviceAttributeType attributeName, String attributeValue) {
		DeviceAttribute attribute = getDeviceAttribute(attributeName);
		if (attribute != null) {
			attribute.setValue(attributeValue);
		} else {
			attribute = new DeviceAttribute();
			attribute.setDeviceAttributeType(attributeName);
			attribute.setValue(attributeValue);
			addDeviceAttribute(attribute);
		}
	}
	public DeviceAttribute getDeviceAttribute(DeviceAttributeType attributeName) {
		return deviceAttributes.get(attributeName);
	}
	public String getModelAttributeValue(final DeviceAttributeType attributeName) {
		String value = null;
		DeviceAttribute attribute = getDeviceAttribute(attributeName);
		if (attribute != null) {
			value = attribute.getValue();
			if (value != null) {
				value = StringUtils
						.remove(StringUtils.remove(value, "\""), "'");
			}
		}
		return value;
	}
	public String getDeviceAttributeValue(final DeviceAttributeType attributeName,
			String defaultValue) {
		String value = defaultValue;
		DeviceAttribute attribute = getDeviceAttribute(attributeName);
		if (attribute != null) {
			value = StringUtils.defaultIfEmpty(StringUtils.trimToNull(attribute
					.getValue()), defaultValue);
			value = StringUtils.remove(StringUtils.remove(value, "\""), "'");
		}
		return value;
	}

	public void setModelAtribute(DeviceAttributeType attributeName, Boolean attributeValue) {
		setDeviceAtribute(attributeName, BooleanUtils.toString(attributeValue,
				"Yes", "No", null));
	}
	
	public Map<DeviceAttributeType, String> getModelAttributeTest() {
		return deviceAttributeTest;
	}
	
	public void setDeviceAttributeTest(
			Map<DeviceAttributeType, String> deviceAttributeTest) {
		this.deviceAttributeTest = deviceAttributeTest;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return description + "|" +deviceNumber+ "|"+	active + "|" + recycle ;
	}

}
