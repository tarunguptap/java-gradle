package com.example.hibernate.xml.mapping.OneToMany.map.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;


import com.example.hibernate.xml.mapping.OneToMany.map.enums.ModelAttributeType;

public class ManufacturerModel extends PersistentEntity{
	private static final long serialVersionUID = 1L;

	private String description;
	private String modelNumber;
	private Boolean active = Boolean.FALSE;
	private Map<ModelAttributeType, ModelAttribute> modelAttributes = new HashMap<ModelAttributeType, ModelAttribute>();
	private String destination;
	private Boolean recycle = Boolean.FALSE;
	private Map<ModelAttributeType, String> modelAttributeTest = new HashMap<ModelAttributeType, String>();
	
	public ManufacturerModel(){
		
	}
	public ManufacturerModel(String description,String modelNumber,Boolean active,Map<ModelAttributeType, ModelAttribute> modelAttributes,String destination,Boolean recycle){
		this.description=description;
		this.modelNumber= modelNumber;
		this.active=active;
		this.modelAttributes=modelAttributes;
		this.description=destination;
		this.recycle=recycle;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Map<ModelAttributeType, ModelAttribute> getModelAttributes() {
		return modelAttributes;
	}
	public void setModelAttributes(Map<ModelAttributeType, ModelAttribute> modelAttributes) {
		this.modelAttributes = modelAttributes;
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
	public void addModelAttribute(ModelAttribute modelAttribute) {
		modelAttribute.setManufacturerModel(this);
		modelAttributes.put(modelAttribute.getModelAttributeType(), modelAttribute);
	}
	public void setModelAtribute(ModelAttributeType attributeName, String attributeValue) {
		ModelAttribute attribute = getModelAttribute(attributeName);
		if (attribute != null) {
			attribute.setValue(attributeValue);
		} else {
			attribute = new ModelAttribute();
			attribute.setModelAttributeType(attributeName);
			attribute.setValue(attributeValue);
			addModelAttribute(attribute);
		}
	}
	public ModelAttribute getModelAttribute(ModelAttributeType attributeName) {
		return modelAttributes.get(attributeName);
	}
	public String getModelAttributeValue(final ModelAttributeType attributeName) {
		String value = null;
		ModelAttribute attribute = getModelAttribute(attributeName);
		if (attribute != null) {
			value = attribute.getValue();
			if (value != null) {
				value = StringUtils
						.remove(StringUtils.remove(value, "\""), "'");
			}
		}
		return value;
	}
	public String getModelAttributeValue(final ModelAttributeType attributeName,
			String defaultValue) {
		String value = defaultValue;
		ModelAttribute attribute = getModelAttribute(attributeName);
		if (attribute != null) {
			value = StringUtils.defaultIfEmpty(StringUtils.trimToNull(attribute
					.getValue()), defaultValue);
			value = StringUtils.remove(StringUtils.remove(value, "\""), "'");
		}
		return value;
	}

	public void setModelAtribute(ModelAttributeType attributeName, Boolean attributeValue) {
		setModelAtribute(attributeName, BooleanUtils.toString(attributeValue,
				"Yes", "No", null));
	}
	
	/**
	 * @return the modelAttributeTest
	 */
	public Map<ModelAttributeType, String> getModelAttributeTest() {
		return modelAttributeTest;
	}
	/**
	 * @param modelAttributeTest the modelAttributeTest to set
	 */
	public void setModelAttributeTest(
			Map<ModelAttributeType, String> modelAttributeTest) {
		this.modelAttributeTest = modelAttributeTest;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return description + "|" +modelNumber+ "|"+	active + "|" + recycle ;
	}

}
