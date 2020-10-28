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
	//private ItemDefinition definition;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (displayAsAttack ? 1231 : 1237);
		result = prime * result + (int) (entityTypeId ^ (entityTypeId >>> 32));
		result = prime * result + (equipped ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isAttuned ? 1231 : 1237);
		result = prime * result + ((limitedUse == null) ? 0 : limitedUse.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (displayAsAttack != other.displayAsAttack)
			return false;
		if (entityTypeId != other.entityTypeId)
			return false;
		if (equipped != other.equipped)
			return false;
		if (id != other.id)
			return false;
		if (isAttuned != other.isAttuned)
			return false;
		if (limitedUse == null) {
			if (other.limitedUse != null)
				return false;
		} else if (!limitedUse.equals(other.limitedUse))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", entityTypeId=" + entityTypeId + ", quantity=" + quantity + ", isAttuned="
				+ isAttuned + ", equipped=" + equipped + ", limitedUse=" + limitedUse + ", displayAsAttack="
				+ displayAsAttack + "]";
	}
}
