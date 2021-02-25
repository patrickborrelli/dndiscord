package com.patrickborrelli.dndiscord.model.dndiscord;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.patrickborrelli.dndiscord.utilities.ArmorType;
import com.patrickborrelli.dndiscord.utilities.DamageType;
import com.patrickborrelli.dndiscord.utilities.FilterType;
import com.patrickborrelli.dndiscord.utilities.ResetType;
import com.patrickborrelli.dndiscord.utilities.WeaponPropertyType;

/**
 * Model of dDnDiscord Item.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	private String name;
	private String description;
	private String snippet;
	private int quantity;
	private String imageUrl;
	private String largeImageUrl;
	private float cost;
	private float weight;
	private String type;
	private String subType;
	private String[] tags;
	
	//qualifiers
	private boolean isConsumable;
	private boolean isMonkWeapon;
	private boolean requiresAttunement;
	private boolean attuned;
	private boolean equipped;
	private boolean attack;
	private boolean stealthDisadvantage;
	private boolean strengthRequirement;
	private boolean magic;
	
	private int armorClass;
	private ArmorType armorType;
	private int strengthRequired;	
	
	//damage parameters for damage inducing items:
	private DamageType damageType;
	private int dieCount;
	private int dieValue;
	private int dieMultiplier;
	private String diceString;
	private int fixedDamage;
	private int versatileDieCount;
	private int versatileDieValue;
	private int versatileDieMultiplier;
	private String versatileDiceString;
	private int versatileFixedDamage;

	private FilterType filterType;
	private List<Feature> grantedModifiers;
	private int range;
	private int longRange;
	private Set<WeaponPropertyType> properties;
	
	//limited use items:
	private int maxUses;
	private int numberUsed;
	private ResetType resetType;
	private String resetTypeDescription;	
	
	/**
	 * default constructor
	 */
	public Item() {
		
	}

	/**
	 * @return String the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name String the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return String the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description String the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return String the snippet
	 */
	public String getSnippet() {
		return snippet;
	}

	/**
	 * @param snippet String the snippet to set
	 */
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	/**
	 * @return int the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity int the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return String the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl String the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return String the largeImageUrl
	 */
	public String getLargeImageUrl() {
		return largeImageUrl;
	}

	/**
	 * @param largeImageUrl String the largeImageUrl to set
	 */
	public void setLargeImageUrl(String largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}

	/**
	 * @return float the cost
	 */
	public float getCost() {
		return cost;
	}

	/**
	 * @param cost float the cost to set
	 */
	public void setCost(float cost) {
		this.cost = cost;
	}

	/**
	 * @return float the weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * @param weight float the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * @return String the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type String the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return String the subType
	 */
	public String getSubType() {
		return subType;
	}

	/**
	 * @param subType String the subType to set
	 */
	public void setSubType(String subType) {
		this.subType = subType;
	}

	/**
	 * @return String[] the tags
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * @param tags String[] the tags to set
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}

	/**
	 * @return boolean the isConsumable
	 */
	public boolean isConsumable() {
		return isConsumable;
	}

	/**
	 * @param isConsumable boolean the isConsumable to set
	 */
	public void setConsumable(boolean isConsumable) {
		this.isConsumable = isConsumable;
	}

	/**
	 * @return boolean the isMonkWeapon
	 */
	public boolean isMonkWeapon() {
		return isMonkWeapon;
	}

	/**
	 * @param isMonkWeapon boolean the isMonkWeapon to set
	 */
	public void setMonkWeapon(boolean isMonkWeapon) {
		this.isMonkWeapon = isMonkWeapon;
	}

	/**
	 * @return boolean the requiresAttunement
	 */
	public boolean isRequiresAttunement() {
		return requiresAttunement;
	}

	/**
	 * @param requiresAttunement boolean the requiresAttunement to set
	 */
	public void setRequiresAttunement(boolean requiresAttunement) {
		this.requiresAttunement = requiresAttunement;
	}

	/**
	 * @return boolean the attuned
	 */
	public boolean isAttuned() {
		return attuned;
	}

	/**
	 * @param attuned boolean the attuned to set
	 */
	public void setAttuned(boolean attuned) {
		this.attuned = attuned;
	}

	/**
	 * @return boolean the equipped
	 */
	public boolean isEquipped() {
		return equipped;
	}

	/**
	 * @param equipped boolean the equipped to set
	 */
	public void setEquipped(boolean equipped) {
		this.equipped = equipped;
	}

	/**
	 * @return boolean the attack
	 */
	public boolean isAttack() {
		return attack;
	}

	/**
	 * @param attack boolean the attack to set
	 */
	public void setAttack(boolean attack) {
		this.attack = attack;
	}

	/**
	 * @return boolean the stealthDisadvantage
	 */
	public boolean isStealthDisadvantage() {
		return stealthDisadvantage;
	}

	/**
	 * @param stealthDisadvantage boolean the stealthDisadvantage to set
	 */
	public void setStealthDisadvantage(boolean stealthDisadvantage) {
		this.stealthDisadvantage = stealthDisadvantage;
	}

	/**
	 * @return boolean the strengthRequirement
	 */
	public boolean isStrengthRequirement() {
		return strengthRequirement;
	}

	/**
	 * @param strengthRequirement boolean the strengthRequirement to set
	 */
	public void setStrengthRequirement(boolean strengthRequirement) {
		this.strengthRequirement = strengthRequirement;
	}

	/**
	 * @return boolean the magic
	 */
	public boolean isMagic() {
		return magic;
	}

	/**
	 * @param magic boolean the magic to set
	 */
	public void setMagic(boolean magic) {
		this.magic = magic;
	}

	/**
	 * @return int the armorClass
	 */
	public int getArmorClass() {
		return armorClass;
	}

	/**
	 * @param armorClass int the armorClass to set
	 */
	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	/**
	 * @return ArmorType the armorType
	 */
	public ArmorType getArmorType() {
		return armorType;
	}

	/**
	 * @param armorType ArmorType the armorType to set
	 */
	public void setArmorType(ArmorType armorType) {
		this.armorType = armorType;
	}

	/**
	 * @return int the strengthRequired
	 */
	public int getStrengthRequired() {
		return strengthRequired;
	}

	/**
	 * @param strengthRequired int the strengthRequired to set
	 */
	public void setStrengthRequired(int strengthRequired) {
		this.strengthRequired = strengthRequired;
	}

	/**
	 * @return DamageType the damageType
	 */
	public DamageType getDamageType() {
		return damageType;
	}

	/**
	 * @param damageType DamageType the damageType to set
	 */
	public void setDamageType(DamageType damageType) {
		this.damageType = damageType;
	}

	/**
	 * @return int the dieCount
	 */
	public int getDieCount() {
		return dieCount;
	}

	/**
	 * @param dieCount int the dieCount to set
	 */
	public void setDieCount(int dieCount) {
		this.dieCount = dieCount;
	}

	/**
	 * @return int the dieValue
	 */
	public int getDieValue() {
		return dieValue;
	}

	/**
	 * @param dieValue int the dieValue to set
	 */
	public void setDieValue(int dieValue) {
		this.dieValue = dieValue;
	}

	/**
	 * @return int the dieMultiplier
	 */
	public int getDieMultiplier() {
		return dieMultiplier;
	}

	/**
	 * @param dieMultiplier int the dieMultiplier to set
	 */
	public void setDieMultiplier(int dieMultiplier) {
		this.dieMultiplier = dieMultiplier;
	}

	/**
	 * @return String the diceString
	 */
	public String getDiceString() {
		return diceString;
	}

	/**
	 * @param diceString String the diceString to set
	 */
	public void setDiceString(String diceString) {
		this.diceString = diceString;
	}

	/**
	 * @return int the fixedDamage
	 */
	public int getFixedDamage() {
		return fixedDamage;
	}

	/**
	 * @param fixedDamage int the fixedDamage to set
	 */
	public void setFixedDamage(int fixedDamage) {
		this.fixedDamage = fixedDamage;
	}

	/**
	 * @return int the versatileDieCount
	 */
	public int getVersatileDieCount() {
		return versatileDieCount;
	}

	/**
	 * @param versatileDieCount int the versatileDieCount to set
	 */
	public void setVersatileDieCount(int versatileDieCount) {
		this.versatileDieCount = versatileDieCount;
	}

	/**
	 * @return int the versatileDieValue
	 */
	public int getVersatileDieValue() {
		return versatileDieValue;
	}

	/**
	 * @param versatileDieValue int the versatileDieValue to set
	 */
	public void setVersatileDieValue(int versatileDieValue) {
		this.versatileDieValue = versatileDieValue;
	}

	/**
	 * @return int the versatileDieMultiplier
	 */
	public int getVersatileDieMultiplier() {
		return versatileDieMultiplier;
	}

	/**
	 * @param versatileDieMultiplier int the versatileDieMultiplier to set
	 */
	public void setVersatileDieMultiplier(int versatileDieMultiplier) {
		this.versatileDieMultiplier = versatileDieMultiplier;
	}

	/**
	 * @return String the versatileDiceString
	 */
	public String getVersatileDiceString() {
		return versatileDiceString;
	}

	/**
	 * @param versatileDiceString String the versatileDiceString to set
	 */
	public void setVersatileDiceString(String versatileDiceString) {
		this.versatileDiceString = versatileDiceString;
		//parse format xdy:
		String[] parsed = versatileDiceString.split("d");
		this.versatileDieCount = Integer.valueOf(parsed[0]);
		this.versatileDieValue = Integer.valueOf(parsed[1]);		
	}

	/**
	 * @return int the versatileFixedDamage
	 */
	public int getVersatileFixedDamage() {
		return versatileFixedDamage;
	}

	/**
	 * @param versatileFixedDamage int the versatileFixedDamage to set
	 */
	public void setVersatileFixedDamage(int versatileFixedDamage) {
		this.versatileFixedDamage = versatileFixedDamage;
	}

	/**
	 * @return FilterType the filterType
	 */
	public FilterType getFilterType() {
		return filterType;
	}

	/**
	 * @param filterType FilterType the filterType to set
	 */
	public void setFilterType(FilterType filterType) {
		this.filterType = filterType;
	}

	/**
	 * @return List<Feature> the grantedModifiers
	 */
	public List<Feature> getGrantedModifiers() {
		return grantedModifiers;
	}

	/**
	 * @param grantedModifiers List<Feature> the grantedModifiers to set
	 */
	public void setGrantedModifiers(List<Feature> grantedModifiers) {
		this.grantedModifiers = grantedModifiers;
	}

	/**
	 * @return int the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * @param range int the range to set
	 */
	public void setRange(int range) {
		this.range = range;
	}

	/**
	 * @return int the longRange
	 */
	public int getLongRange() {
		return longRange;
	}

	/**
	 * @param longRange int the longRange to set
	 */
	public void setLongRange(int longRange) {
		this.longRange = longRange;
	}

	/**
	 * @return Set<WeaponPropertyType> the properties
	 */
	public Set<WeaponPropertyType> getProperties() {
		return properties;
	}

	/**
	 * @param properties Set<WeaponPropertyType> the properties to set
	 */
	public void setProperties(Set<WeaponPropertyType> properties) {
		this.properties = properties;
	}

	/**
	 * @return int the maxUses
	 */
	public int getMaxUses() {
		return maxUses;
	}

	/**
	 * @param maxUses int the maxUses to set
	 */
	public void setMaxUses(int maxUses) {
		this.maxUses = maxUses;
	}

	/**
	 * @return int the numberUsed
	 */
	public int getNumberUsed() {
		return numberUsed;
	}

	/**
	 * @param numberUsed int the numberUsed to set
	 */
	public void setNumberUsed(int numberUsed) {
		this.numberUsed = numberUsed;
	}

	/**
	 * @return ResetType the resetType
	 */
	public ResetType getResetType() {
		return resetType;
	}

	/**
	 * @param resetType ResetType the resetType to set
	 */
	public void setResetType(ResetType resetType) {
		this.resetType = resetType;
	}

	/**
	 * @return String the resetTypeDescription
	 */
	public String getResetTypeDescription() {
		return resetTypeDescription;
	}

	/**
	 * @param resetTypeDescription String the resetTypeDescription to set
	 */
	public void setResetTypeDescription(String resetTypeDescription) {
		this.resetTypeDescription = resetTypeDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + armorClass;
		result = prime * result + ((armorType == null) ? 0 : armorType.hashCode());
		result = prime * result + (attack ? 1231 : 1237);
		result = prime * result + (attuned ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(cost);
		result = prime * result + ((damageType == null) ? 0 : damageType.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((diceString == null) ? 0 : diceString.hashCode());
		result = prime * result + dieCount;
		result = prime * result + dieMultiplier;
		result = prime * result + dieValue;
		result = prime * result + (equipped ? 1231 : 1237);
		result = prime * result + ((filterType == null) ? 0 : filterType.hashCode());
		result = prime * result + fixedDamage;
		result = prime * result + ((grantedModifiers == null) ? 0 : grantedModifiers.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + (isConsumable ? 1231 : 1237);
		result = prime * result + (isMonkWeapon ? 1231 : 1237);
		result = prime * result + ((largeImageUrl == null) ? 0 : largeImageUrl.hashCode());
		result = prime * result + longRange;
		result = prime * result + (magic ? 1231 : 1237);
		result = prime * result + maxUses;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberUsed;
		result = prime * result + ((properties == null) ? 0 : properties.hashCode());
		result = prime * result + quantity;
		result = prime * result + range;
		result = prime * result + (requiresAttunement ? 1231 : 1237);
		result = prime * result + ((resetType == null) ? 0 : resetType.hashCode());
		result = prime * result + ((resetTypeDescription == null) ? 0 : resetTypeDescription.hashCode());
		result = prime * result + ((snippet == null) ? 0 : snippet.hashCode());
		result = prime * result + (stealthDisadvantage ? 1231 : 1237);
		result = prime * result + strengthRequired;
		result = prime * result + (strengthRequirement ? 1231 : 1237);
		result = prime * result + ((subType == null) ? 0 : subType.hashCode());
		result = prime * result + Arrays.hashCode(tags);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((versatileDiceString == null) ? 0 : versatileDiceString.hashCode());
		result = prime * result + versatileDieCount;
		result = prime * result + versatileDieMultiplier;
		result = prime * result + versatileDieValue;
		result = prime * result + versatileFixedDamage;
		result = prime * result + Float.floatToIntBits(weight);
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
		if (armorClass != other.armorClass)
			return false;
		if (armorType != other.armorType)
			return false;
		if (attack != other.attack)
			return false;
		if (attuned != other.attuned)
			return false;
		if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
			return false;
		if (damageType != other.damageType)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (diceString == null) {
			if (other.diceString != null)
				return false;
		} else if (!diceString.equals(other.diceString))
			return false;
		if (dieCount != other.dieCount)
			return false;
		if (dieMultiplier != other.dieMultiplier)
			return false;
		if (dieValue != other.dieValue)
			return false;
		if (equipped != other.equipped)
			return false;
		if (filterType != other.filterType)
			return false;
		if (fixedDamage != other.fixedDamage)
			return false;
		if (grantedModifiers == null) {
			if (other.grantedModifiers != null)
				return false;
		} else if (!grantedModifiers.equals(other.grantedModifiers))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (isConsumable != other.isConsumable)
			return false;
		if (isMonkWeapon != other.isMonkWeapon)
			return false;
		if (largeImageUrl == null) {
			if (other.largeImageUrl != null)
				return false;
		} else if (!largeImageUrl.equals(other.largeImageUrl))
			return false;
		if (longRange != other.longRange)
			return false;
		if (magic != other.magic)
			return false;
		if (maxUses != other.maxUses)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberUsed != other.numberUsed)
			return false;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		if (quantity != other.quantity)
			return false;
		if (range != other.range)
			return false;
		if (requiresAttunement != other.requiresAttunement)
			return false;
		if (resetType != other.resetType)
			return false;
		if (resetTypeDescription == null) {
			if (other.resetTypeDescription != null)
				return false;
		} else if (!resetTypeDescription.equals(other.resetTypeDescription))
			return false;
		if (snippet == null) {
			if (other.snippet != null)
				return false;
		} else if (!snippet.equals(other.snippet))
			return false;
		if (stealthDisadvantage != other.stealthDisadvantage)
			return false;
		if (strengthRequired != other.strengthRequired)
			return false;
		if (strengthRequirement != other.strengthRequirement)
			return false;
		if (subType == null) {
			if (other.subType != null)
				return false;
		} else if (!subType.equals(other.subType))
			return false;
		if (!Arrays.equals(tags, other.tags))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (versatileDiceString == null) {
			if (other.versatileDiceString != null)
				return false;
		} else if (!versatileDiceString.equals(other.versatileDiceString))
			return false;
		if (versatileDieCount != other.versatileDieCount)
			return false;
		if (versatileDieMultiplier != other.versatileDieMultiplier)
			return false;
		if (versatileDieValue != other.versatileDieValue)
			return false;
		if (versatileFixedDamage != other.versatileFixedDamage)
			return false;
		if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", description=" + description + ", snippet=" + snippet + ", quantity=" + quantity
				+ ", imageUrl=" + imageUrl + ", largeImageUrl=" + largeImageUrl + ", cost=" + cost + ", weight="
				+ weight + ", type=" + type + ", subType=" + subType + ", tags=" + Arrays.toString(tags)
				+ ", isConsumable=" + isConsumable + ", isMonkWeapon=" + isMonkWeapon + ", requiresAttunement="
				+ requiresAttunement + ", attuned=" + attuned + ", equipped=" + equipped + ", attack=" + attack
				+ ", stealthDisadvantage=" + stealthDisadvantage + ", strengthRequirement=" + strengthRequirement
				+ ", magic=" + magic + ", armorClass=" + armorClass + ", armorType=" + armorType + ", strengthRequired="
				+ strengthRequired + ", damageType=" + damageType + ", dieCount=" + dieCount + ", dieValue=" + dieValue
				+ ", dieMultiplier=" + dieMultiplier + ", diceString=" + diceString + ", fixedDamage=" + fixedDamage
				+ ", versatileDieCount=" + versatileDieCount + ", versatileDieValue=" + versatileDieValue
				+ ", versatileDieMultiplier=" + versatileDieMultiplier + ", versatileDiceString=" + versatileDiceString
				+ ", versatileFixedDamage=" + versatileFixedDamage + ", filterType=" + filterType
				+ ", grantedModifiers=" + grantedModifiers + ", range=" + range + ", longRange=" + longRange
				+ ", properties=" + properties + ", maxUses=" + maxUses + ", numberUsed=" + numberUsed + ", resetType="
				+ resetType + ", resetTypeDescription=" + resetTypeDescription + "]";
	}
}
