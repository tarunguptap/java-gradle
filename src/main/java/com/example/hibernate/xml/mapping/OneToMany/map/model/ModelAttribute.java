package com.example.hibernate.xml.mapping.OneToMany.map.model;

import com.example.hibernate.xml.mapping.OneToMany.map.model.PersistentEntity;

import com.example.hibernate.xml.mapping.OneToMany.map.enums.ModelAttributeType;

public class ModelAttribute extends PersistentEntity{
	 private static final long serialVersionUID = 1L;

	    private ModelAttributeType modelAttributeType;

	    private String value;

	    private ManufacturerModel manufacturerModel;
	    
	    public  ModelAttribute(){
	    	
	    }
	    
	    public  ModelAttribute(ModelAttributeType modelAttributeType,String value){
	    	this.modelAttributeType=modelAttributeType;
	    	this.value=value;
	    }
	    
	    public ManufacturerModel getManufacturerModel() {
	        return manufacturerModel;
	    }

	    public void setManufacturerModel(ManufacturerModel manufacturerModel) {
	        this.manufacturerModel = manufacturerModel;
	    }

		/**
		 * @return the modelAttributeType
		 */
		public ModelAttributeType getModelAttributeType() {
			return modelAttributeType;
		}

		/**
		 * @param modelAttributeType the modelAttributeType to set
		 */
		public void setModelAttributeType(ModelAttributeType modelAttributeType) {
			this.modelAttributeType = modelAttributeType;
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
	    	return modelAttributeType + "|" + value + "||   " + manufacturerModel;
	    }
}
