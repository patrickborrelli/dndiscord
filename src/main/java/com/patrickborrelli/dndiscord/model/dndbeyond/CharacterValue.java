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
	 * @return the typeId
	 */
	public int getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the valueId
	 */
	public long getValueId() {
		return valueId;
	}

	/**
	 * @param valueId the valueId to set
	 */
	public void setValueId(long valueId) {
		this.valueId = valueId;
	}

	/**
	 * @return the valueTypeId
	 */
	public long getValueTypeId() {
		return valueTypeId;
	}

	/**
	 * @param valueTypeId the valueTypeId to set
	 */
	public void setValueTypeId(long valueTypeId) {
		this.valueTypeId = valueTypeId;
	}

	/**
	 * @return the contextId
	 */
	public long getContextId() {
		return contextId;
	}

	/**
	 * @param contextId the contextId to set
	 */
	public void setContextId(long contextId) {
		this.contextId = contextId;
	}

	/**
	 * @return the contextTypeId
	 */
	public long getContextTypeId() {
		return contextTypeId;
	}

	/**
	 * @param contextTypeId the contextTypeId to set
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