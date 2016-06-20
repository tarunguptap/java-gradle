package com.example.hibernate.annotation.dbsequence.SequenceGeneratorOverrideDemo.model;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.example.hibernate.annotation.dbsequence.SequenceGeneratorOverrideDemo.enums.ItemType;


@Entity
@Table(name = "ITEM_INFO")
@AttributeOverride(name = "id", column = @Column(name = "itemid"))
@GenericGenerator (name = "demo_generator", strategy = "seqhilo", parameters = {@Parameter(name = "max_lo", value = "1"), @Parameter(name = "sequence", value = "item_seq")})
public class Item extends PersistentEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "item_name", nullable = false, length = 20)
	private String itemName;
	
	@Column(name = "price", nullable = false, length = 20)
	private BigDecimal itemPrice ;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	@Type(type = "commonutil.userType.EnumUserType", parameters={
				@Parameter(name="enumClassName", value="HibernateMappingAnnotation.SequenceGeneratorOverrideDemo.com.enums.RoleType")})
	private ItemType type;
	
	@Column(name = "price", nullable = false, length = 20)
	private BigDecimal quantity ;
	
	@Column(name = "active", nullable=false, columnDefinition = "boolean default true")
	private Boolean active;
	
	private Money totalAmount;

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the itemPrice
	 */
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	/**
	 * @return the type
	 */
	public ItemType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(ItemType type) {
		this.type = type;
	}
	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
}
