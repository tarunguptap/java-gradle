package com.example.hibernate.annotation.inheritence.OneTablePerClassInheritance.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="ref_labelconstant")
@DiscriminatorValue("QC_STATUS")
public class QualityCheckStatus extends LabelConstant{

	private static final long serialVersionUID = 1L;
	
	public enum Code {
    	PASS_QUALITY_CONTROL
    }

	public QualityCheckStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QualityCheckStatus(String code, String localizedText,
			String nonLocalizedText) {
		super(code, localizedText, nonLocalizedText);
		// TODO Auto-generated constructor stub
	}
	
}
