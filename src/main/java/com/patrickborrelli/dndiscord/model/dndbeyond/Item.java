package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for an item json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
	private long id;
	private long entityTypeId;
	private ItemDefinition definition;
	private int quantity;
	private boolean isAttuned;
	private boolean equipped;
	private LimitedUse limitedUse;
	private boolean displayAsAttack;
	
	public Item() {
		
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the entityTypeId
	 */
	public long getEntityTypeId() {
		return entityTypeId;
	}

	/**
	 * @param entityTypeId the entityTypeId to set
	 */
	public void setEntityTypeId(long entityTypeId) {
		this.entityTypeId = entityTypeId;
	}

	/**
	 * @return the definition
	 */
	public ItemDefinition getDefinition() {
		return definition;
	}

	/**
	 * @param definition the definition to set
	 */
	public void setDefinition(ItemDefinition definition) {
		this.definition = definition;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the isAttuned
	 */
	public boolean isAttuned() {
		return isAttuned;
	}

	/**
	 * @param isAttuned the isAttuned to set
	 */
	public void setAttuned(boolean isAttuned) {
		this.isAttuned = isAttuned;
	}

	/**
	 * @return the equipped
	 */
	public boolean isEquipped() {
		return equipped;
	}

	/**
	 * @param equipped the equipped to set
	 */
	public void setEquipped(boolean equipped) {
		this.equipped = equipped;
	}

	/**
	 * @return the limitedUse
	 */
	public LimitedUse getLimitedUse() {
		return limitedUse;
	}

	/**
	 * @param limitedUse the limitedUse to set
	 */
	public void setLimitedUse(LimitedUse limitedUse) {
		this.limitedUse = limitedUse;
	}

	/**
	 * @return the displayAsAttack
	 */
	public boolean isDisplayAsAttack() {
		return displayAsAttack;
	}

	/**
	 * @param displayAsAttack the displayAsAttack to set
	 */
	public void setDisplayAsAttack(boolean displayAsAttack) {
		this.displayAsAttack = displayAsAttack;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", entityTypeId=" + entityTypeId + ", definition=" + definition + ", quantity="
				+ quantity + ", isAttuned=" + isAttuned + ", equipped=" + equipped + ", limitedUse=" + limitedUse
				+ ", displayAsAttack=" + displayAsAttack + "]";
	}
}
