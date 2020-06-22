package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a Background json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Background {
	private boolean hasCustomBackground;
	private BackgroundDefinition definition;
	private CustomBackground customBackground;
	
	public Background() {
		
	}

	/**
	 * @return boolean the hasCustomBackground
	 */
	public boolean isHasCustomBackground() {
		return hasCustomBackground;
	}

	/**
	 * @param boolean the hasCustomBackground to set
	 */
	public void setHasCustomBackground(boolean hasCustomBackground) {
		this.hasCustomBackground = hasCustomBackground;
	}

	/**
	 * @return BackgroundDefinition the definition
	 */
	public BackgroundDefinition getDefinition() {
		return definition;
	}

	/**
	 * @param BackgroundDefinition the definition to set
	 */
	public void setDefinition(BackgroundDefinition definition) {
		this.definition = definition;
	}

	/**
	 * @return CustomBackground the customBackground
	 */
	public CustomBackground getCustomBackground() {
		return customBackground;
	}

	/**
	 * @param CustomBackground the customBackground to set
	 */
	public void setCustomBackground(CustomBackground customBackground) {
		this.customBackground = customBackground;
	}

	@Override
	public String toString() {
		return "Background [hasCustomBackground=" + hasCustomBackground + ", definition=" + definition
				+ ", customBackground=" + customBackground + "]";
	}
}
