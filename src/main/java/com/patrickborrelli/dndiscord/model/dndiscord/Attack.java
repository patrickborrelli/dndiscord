/**
 * 
 */
package com.patrickborrelli.dndiscord.model.dndiscord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Model of dDnDiscord Attack.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attack {
	private String name;
	private int damageDiceMultiplier;
	private int damageDiceType;
	private int damageDiceAdditive;
	private String damageType;
	private int longRange;
	private boolean magic;
	private boolean silvered;
	private boolean ranged;
	private boolean requiresAmmunition;
	private boolean finesse;
	private boolean heavy;
	private boolean light;
	private boolean loading;
	private boolean reach;
	private boolean thrown;
	private boolean twoHanded;
	private boolean versatile;	

	public Attack() {
		
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the damageDiceMultiplier
	 */
	public int getDamageDiceMultiplier() {
		return damageDiceMultiplier;
	}

	/**
	 * @param damageDiceMultiplier the damageDiceMultiplier to set
	 */
	public void setDamageDiceMultiplier(int damageDiceMultiplier) {
		this.damageDiceMultiplier = damageDiceMultiplier;
	}

	/**
	 * @return the damageDiceType
	 */
	public int getDamageDiceType() {
		return damageDiceType;
	}

	/**
	 * @param damageDiceType the damageDiceType to set
	 */
	public void setDamageDiceType(int damageDiceType) {
		this.damageDiceType = damageDiceType;
	}

	/**
	 * @return the damageDiceAdditive
	 */
	public int getDamageDiceAdditive() {
		return damageDiceAdditive;
	}

	/**
	 * @param damageDiceAdditive the damageDiceAdditive to set
	 */
	public void setDamageDiceAdditive(int damageDiceAdditive) {
		this.damageDiceAdditive = damageDiceAdditive;
	}

	/**
	 * @return the damageType
	 */
	public String getDamageType() {
		return damageType;
	}

	/**
	 * @param damageType the damageType to set
	 */
	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}

	/**
	 * @return the longRange
	 */
	public int getLongRange() {
		return longRange;
	}

	/**
	 * @param longRange the longRange to set
	 */
	public void setLongRange(int longRange) {
		this.longRange = longRange;
	}

	/**
	 * @return the magic
	 */
	public boolean isMagic() {
		return magic;
	}

	/**
	 * @param magic the magic to set
	 */
	public void setMagic(boolean magic) {
		this.magic = magic;
	}

	/**
	 * @return the silvered
	 */
	public boolean isSilvered() {
		return silvered;
	}

	/**
	 * @param silvered the silvered to set
	 */
	public void setSilvered(boolean silvered) {
		this.silvered = silvered;
	}

	/**
	 * @return the ranged
	 */
	public boolean isRanged() {
		return ranged;
	}

	/**
	 * @param ranged the ranged to set
	 */
	public void setRanged(boolean ranged) {
		this.ranged = ranged;
	}

	/**
	 * @return the requiresAmmunition
	 */
	public boolean isRequiresAmmunition() {
		return requiresAmmunition;
	}

	/**
	 * @param requiresAmmunition the requiresAmmunition to set
	 */
	public void setRequiresAmmunition(boolean requiresAmmunition) {
		this.requiresAmmunition = requiresAmmunition;
	}

	/**
	 * @return the finesse
	 */
	public boolean isFinesse() {
		return finesse;
	}

	/**
	 * @param finesse the finesse to set
	 */
	public void setFinesse(boolean finesse) {
		this.finesse = finesse;
	}

	/**
	 * @return the heavy
	 */
	public boolean isHeavy() {
		return heavy;
	}

	/**
	 * @param heavy the heavy to set
	 */
	public void setHeavy(boolean heavy) {
		this.heavy = heavy;
	}

	/**
	 * @return the light
	 */
	public boolean isLight() {
		return light;
	}

	/**
	 * @param light the light to set
	 */
	public void setLight(boolean light) {
		this.light = light;
	}

	/**
	 * @return the loading
	 */
	public boolean isLoading() {
		return loading;
	}

	/**
	 * @param loading the loading to set
	 */
	public void setLoading(boolean loading) {
		this.loading = loading;
	}

	/**
	 * @return the reach
	 */
	public boolean isReach() {
		return reach;
	}

	/**
	 * @param reach the reach to set
	 */
	public void setReach(boolean reach) {
		this.reach = reach;
	}

	/**
	 * @return the thrown
	 */
	public boolean isThrown() {
		return thrown;
	}

	/**
	 * @param thrown the thrown to set
	 */
	public void setThrown(boolean thrown) {
		this.thrown = thrown;
	}

	/**
	 * @return the twoHanded
	 */
	public boolean isTwoHanded() {
		return twoHanded;
	}

	/**
	 * @param twoHanded the twoHanded to set
	 */
	public void setTwoHanded(boolean twoHanded) {
		this.twoHanded = twoHanded;
	}

	/**
	 * @return the versatile
	 */
	public boolean isVersatile() {
		return versatile;
	}

	/**
	 * @param versatile the versatile to set
	 */
	public void setVersatile(boolean versatile) {
		this.versatile = versatile;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + damageDiceAdditive;
		result = prime * result + damageDiceMultiplier;
		result = prime * result + damageDiceType;
		result = prime * result + ((damageType == null) ? 0 : damageType.hashCode());
		result = prime * result + (finesse ? 1231 : 1237);
		result = prime * result + (heavy ? 1231 : 1237);
		result = prime * result + (light ? 1231 : 1237);
		result = prime * result + (loading ? 1231 : 1237);
		result = prime * result + longRange;
		result = prime * result + (magic ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (ranged ? 1231 : 1237);
		result = prime * result + (reach ? 1231 : 1237);
		result = prime * result + (requiresAmmunition ? 1231 : 1237);
		result = prime * result + (silvered ? 1231 : 1237);
		result = prime * result + (thrown ? 1231 : 1237);
		result = prime * result + (twoHanded ? 1231 : 1237);
		result = prime * result + (versatile ? 1231 : 1237);
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
		Attack other = (Attack) obj;
		if (damageDiceAdditive != other.damageDiceAdditive)
			return false;
		if (damageDiceMultiplier != other.damageDiceMultiplier)
			return false;
		if (damageDiceType != other.damageDiceType)
			return false;
		if (damageType == null) {
			if (other.damageType != null)
				return false;
		} else if (!damageType.equals(other.damageType))
			return false;
		if (finesse != other.finesse)
			return false;
		if (heavy != other.heavy)
			return false;
		if (light != other.light)
			return false;
		if (loading != other.loading)
			return false;
		if (longRange != other.longRange)
			return false;
		if (magic != other.magic)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ranged != other.ranged)
			return false;
		if (reach != other.reach)
			return false;
		if (requiresAmmunition != other.requiresAmmunition)
			return false;
		if (silvered != other.silvered)
			return false;
		if (thrown != other.thrown)
			return false;
		if (twoHanded != other.twoHanded)
			return false;
		if (versatile != other.versatile)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Attack [name=" + name + ", damageDiceMultiplier=" + damageDiceMultiplier + ", damageDiceType="
				+ damageDiceType + ", damageDiceAdditive=" + damageDiceAdditive + ", damageType=" + damageType
				+ ", longRange=" + longRange + ", magic=" + magic + ", silvered=" + silvered + ", ranged=" + ranged
				+ ", requiresAmmunition=" + requiresAmmunition + ", finesse=" + finesse + ", heavy=" + heavy
				+ ", light=" + light + ", loading=" + loading + ", reach=" + reach + ", thrown=" + thrown
				+ ", twoHanded=" + twoHanded + ", versatile=" + versatile + "]";
	}

}
