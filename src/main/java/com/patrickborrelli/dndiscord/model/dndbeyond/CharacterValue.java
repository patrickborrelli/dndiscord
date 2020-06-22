package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a character value json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterValue {
	private int typeId;
	private String value;
	private String notes;
	private long valueId;
	private long valueTypeId;
	private long contextId;
	private long contextTypeId;
	
	public CharacterValue() {
		
	}

	/**
	 * @return int the typeId
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * @param int the typeId to set
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return String the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param String the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return String the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param String the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return long the valueId
	 */
	public long getValueId() {
		return valueId;
	}

	/**
	 * @param long the valueId to set
	 */
	public void setValueId(long valueId) {
		this.valueId = valueId;
	}

	/**
	 * @return long the valueTypeId
	 */
	public long getValueTypeId() {
		return valueTypeId;
	}

	/**
	 * @param long the valueTypeId to set
	 */
	public void setValueTypeId(long valueTypeId) {
		this.valueTypeId = valueTypeId;
	}

	/**
	 * @return long the contextId
	 */
	public long getContextId() {
		return contextId;
	}

	/**
	 * @param long the contextId to set
	 */
	public void setContextId(long contextId) {
		this.contextId = contextId;
	}

	/**
	 * @return long the contextTypeId
	 */
	public long getContextTypeId() {
		return contextTypeId;
	}

	/**
	 * @param long the contextTypeId to set
	 */
	public void setContextTypeId(long contextTypeId) {
		this.contextTypeId = contextTypeId;
	}

	@Override
	public String toString() {
		return "CharacterValue [typeId=" + typeId + ", value=" + value + ", notes=" + notes + ", valueId=" + valueId
				+ ", valueTypeId=" + valueTypeId + ", contextId=" + contextId + ", contextTypeId=" + contextTypeId
				+ "]";
	}
	
}
