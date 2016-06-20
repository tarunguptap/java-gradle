package com.example.hibernate.annotation.inheritence.OneTablePerClassInheritance.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 
 * @hibernate.subclass discriminator-value="QC_STATUS_RESPONSE"
 */

@Entity
@Table(name="ref_labelconstant")
@DiscriminatorValue("QC_STATUS_RESPONSE")
public class QualityControlStatus extends LabelConstant{

	private static final long serialVersionUID = 1L;
	
	public enum Code {
    	PASS_QUALITY_CONTROL
    }

	public QualityControlStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QualityControlStatus(String code, String localizedText,
			String nonLocalizedText) {
		super(code, localizedText, nonLocalizedText);
		// TODO Auto-generated constructor stub
	}
	
}
