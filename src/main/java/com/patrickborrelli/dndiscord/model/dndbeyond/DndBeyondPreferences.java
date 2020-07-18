package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for dndbeyond preferences json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DndBeyondPreferences {
	private boolean useHomebrewContent;
	private int progressionType;
	private int encumbranceType;
	private boolean ignoreCoinWeight;
	private int hitPointType;
	private boolean showUnarmedStrike;
	private boolean showCompanions;
	private boolean showWildShape;
	private int primarySense;
	private int primaryMovement;
	private int privacyType;
	private int sharingType;
	private int abilityScoreDisplayType;
	private boolean enforceFeatRules;
	private boolean enforceMulticlassRules;
	
	public DndBeyondPreferences() {
		
	}

	/**
	 * @return the useHomebrewContent
	 */
	public boolean isUseHomebrewContent() {
		return useHomebrewContent;
	}

	/**
	 * @param useHomebrewContent the useHomebrewContent to set
	 */
	public void setUseHomebrewContent(boolean useHomebrewContent) {
		this.useHomebrewContent = useHomebrewContent;
	}

	/**
	 * @return the progressionType
	 */
	public int getProgressionType() {
		return progressionType;
	}

	/**
	 * @param progressionType the progressionType to set
	 */
	public void setProgressionType(int progressionType) {
		this.progressionType = progressionType;
	}

	/**
	 * @return the encumbranceType
	 */
	public int getEncumbranceType() {
		return encumbranceType;
	}

	/**
	 * @param encumbranceType the encumbranceType to set
	 */
	public void setEncumbranceType(int encumbranceType) {
		this.encumbranceType = encumbranceType;
	}

	/**
	 * @return the ignoreCoinWeight
	 */
	public boolean isIgnoreCoinWeight() {
		return ignoreCoinWeight;
	}

	/**
	 * @param ignoreCoinWeight the ignoreCoinWeight to set
	 */
	public void setIgnoreCoinWeight(boolean ignoreCoinWeight) {
		this.ignoreCoinWeight = ignoreCoinWeight;
	}

	/**
	 * @return the hitPointType
	 */
	public int getHitPointType() {
		return hitPointType;
	}

	/**
	 * @param hitPointType the hitPointType to set
	 */
	public void setHitPointType(int hitPointType) {
		this.hitPointType = hitPointType;
	}

	/**
	 * @return the showUnarmedStrike
	 */
	public boolean isShowUnarmedStrike() {
		return showUnarmedStrike;
	}

	/**
	 * @param showUnarmedStrike the showUnarmedStrike to set
	 */
	public void setShowUnarmedStrike(boolean showUnarmedStrike) {
		this.showUnarmedStrike = showUnarmedStrike;
	}

	/**
	 * @return the showCompanions
	 */
	public boolean isShowCompanions() {
		return showCompanions;
	}

	/**
	 * @param showCompanions the showCompanions to set
	 */
	public void setShowCompanions(boolean showCompanions) {
		this.showCompanions = showCompanions;
	}

	/**
	 * @return the showWildShape
	 */
	public boolean isShowWildShape() {
		return showWildShape;
	}

	/**
	 * @param showWildShape the showWildShape to set
	 */
	public void setShowWildShape(boolean showWildShape) {
		this.showWildShape = showWildShape;
	}

	/**
	 * @return the primarySense
	 */
	public int getPrimarySense() {
		return primarySense;
	}

	/**
	 * @param primarySense the primarySense to set
	 */
	public void setPrimarySense(int primarySense) {
		this.primarySense = primarySense;
	}

	/**
	 * @return the primaryMovement
	 */
	public int getPrimaryMovement() {
		return primaryMovement;
	}

	/**
	 * @param primaryMovement the primaryMovement to set
	 */
	public void setPrimaryMovement(int primaryMovement) {
		this.primaryMovement = primaryMovement;
	}

	/**
	 * @return the privacyType
	 */
	public int getPrivacyType() {
		return privacyType;
	}

	/**
	 * @param privacyType the privacyType to set
	 */
	public void setPrivacyType(int privacyType) {
		this.privacyType = privacyType;
	}

	/**
	 * @return the sharingType
	 */
	public int getSharingType() {
		return sharingType;
	}

	/**
	 * @param sharingType the sharingType to set
	 */
	public void setSharingType(int sharingType) {
		this.sharingType = sharingType;
	}

	/**
	 * @return the abilityScoreDisplayType
	 */
	public int getAbilityScoreDisplayType() {
		return abilityScoreDisplayType;
	}

	/**
	 * @param abilityScoreDisplayType the abilityScoreDisplayType to set
	 */
	public void setAbilityScoreDisplayType(int abilityScoreDisplayType) {
		this.abilityScoreDisplayType = abilityScoreDisplayType;
	}

	/**
	 * @return the enforceFeatRules
	 */
	public boolean isEnforceFeatRules() {
		return enforceFeatRules;
	}

	/**
	 * @param enforceFeatRules the enforceFeatRules to set
	 */
	public void setEnforceFeatRules(boolean enforceFeatRules) {
		this.enforceFeatRules = enforceFeatRules;
	}

	/**
	 * @return the enforceMulticlassRules
	 */
	public boolean isEnforceMulticlassRules() {
		return enforceMulticlassRules;
	}

	/**
	 * @param enforceMulticlassRules the enforceMulticlassRules to set
	 */
	public void setEnforceMulticlassRules(boolean enforceMulticlassRules) {
		this.enforceMulticlassRules = enforceMulticlassRules;
	}

	@Override
	public String toString() {
		return "DndBeyondPreferences [useHomebrewContent=" + useHomebrewContent + ", progressionType=" + progressionType
				+ ", encumbranceType=" + encumbranceType + ", ignoreCoinWeight=" + ignoreCoinWeight + ", hitPointType="
				+ hitPointType + ", showUnarmedStrike=" + showUnarmedStrike + ", showCompanions=" + showCompanions
				+ ", showWildShape=" + showWildShape + ", primarySense=" + primarySense + ", primaryMovement="
				+ primaryMovement + ", privacyType=" + privacyType + ", sharingType=" + sharingType
				+ ", abilityScoreDisplayType=" + abilityScoreDisplayType + ", enforceFeatRules=" + enforceFeatRules
				+ ", enforceMulticlassRules=" + enforceMulticlassRules + "]";
	}
	
	
}