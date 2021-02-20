package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for an item definition json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDefinition {
	private int armorClass;
	private int armorTypeId;
	private int attackType;
	private String attunementDescription;
	private String avatarUrl;
	private String baseArmorName;
	private int baseItemId;
	private long baseTypeId;
	private int bundleSize;
	private boolean canAttune;
	private boolean canBeAddedToInventory;
	private boolean canEquip;
	private boolean categoryId;
	private float cost;
	private ItemDamage damage;
	private String damageType;
	private String description;
	private long entityTypeId;
	private String filterType;
	private int fixedDamage;
	private int gearTypeId;
	private Object[] grantedModifiers;
	private int groupedId;
	private int id;
	private boolean isConsumable;
	private boolean isHomebrew;
	private boolean isMonkWeapon;
	private boolean isPack;
	private String largeAvatarUrl;
	private int levelInfusionGranted;
	private int longRange;
	private boolean magic;
	private int maxUses;
	private String name;
	private int numberUsed;
	private ItemProperty[] properties;
	private int range;
	private String rarity;
	private String resetType;
	private String resetTypeDescription;
	private String snippet;
	private int sourceId;
	private int sourcePageNumber;
	private boolean stackable;
	private int stealthCheck;
	private int strengthRequirement;
	private String subType;
	private String[] tags;
	private String type;
	private int version;
	private String[] weaponBehaviors;
	private float weight;

	public ItemDefinition() {
		
	}

	/**
	 * @return the armorClass
	 */
	public int getArmorClass() {
		return armorClass;
	}

	/**
	 * @param armorClass the armorClass to set
	 */
	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	/**
	 * @return the armorTypeId
	 */
	public int getArmorTypeId() {
		return armorTypeId;
	}

	/**
	 * @param armorTypeId the armorTypeId to set
	 */
	public void setArmorTypeId(int armorTypeId) {
		this.armorTypeId = armorTypeId;
	}

	/**
	 * @return the attackType
	 */
	public int getAttackType() {
		return attackType;
	}

	/**
	 * @param attackType the attackType to set
	 */
	public void setAttackType(int attackType) {
		this.attackType = attackType;
	}

	/**
	 * @return the attunementDescription
	 */
	public String getAttunementDescription() {
		return attunementDescription;
	}

	/**
	 * @param attunementDescription the attunementDescription to set
	 */
	public void setAttunementDescription(String attunementDescription) {
		this.attunementDescription = attunementDescription;
	}

	/**
	 * @return the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * @param avatarUrl the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * @return the baseArmorName
	 */
	public String getBaseArmorName() {
		return baseArmorName;
	}

	/**
	 * @param baseArmorName the baseArmorName to set
	 */
	public void setBaseArmorName(String baseArmorName) {
		this.baseArmorName = baseArmorName;
	}

	/**
	 * @return the baseItemId
	 */
	public int getBaseItemId() {
		return baseItemId;
	}

	/**
	 * @param baseItemId the baseItemId to set
	 */
	public void setBaseItemId(int baseItemId) {
		this.baseItemId = baseItemId;
	}

	/**
	 * @return the baseTypeId
	 */
	public long getBaseTypeId() {
		return baseTypeId;
	}

	/**
	 * @param baseTypeId the baseTypeId to set
	 */
	public void setBaseTypeId(long baseTypeId) {
		this.baseTypeId = baseTypeId;
	}

	/**
	 * @return the bundleSize
	 */
	public int getBundleSize() {
		return bundleSize;
	}

	/**
	 * @param bundleSize the bundleSize to set
	 */
	public void setBundleSize(int bundleSize) {
		this.bundleSize = bundleSize;
	}

	/**
	 * @return the canAttune
	 */
	public boolean isCanAttune() {
		return canAttune;
	}

	/**
	 * @param canAttune the canAttune to set
	 */
	public void setCanAttune(boolean canAttune) {
		this.canAttune = canAttune;
	}

	/**
	 * @return the canBeAddedToInventory
	 */
	public boolean isCanBeAddedToInventory() {
		return canBeAddedToInventory;
	}

	/**
	 * @param canBeAddedToInventory the canBeAddedToInventory to set
	 */
	public void setCanBeAddedToInventory(boolean canBeAddedToInventory) {
		this.canBeAddedToInventory = canBeAddedToInventory;
	}

	/**
	 * @return the canEquip
	 */
	public boolean isCanEquip() {
		return canEquip;
	}

	/**
	 * @param canEquip the canEquip to set
	 */
	public void setCanEquip(boolean canEquip) {
		this.canEquip = canEquip;
	}

	/**
	 * @return the categoryId
	 */
	public boolean isCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(boolean categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the cost
	 */
	public float getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(float cost) {
		this.cost = cost;
	}

	/**
	 * @return the damage
	 */
	public ItemDamage getDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(ItemDamage damage) {
		this.damage = damage;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the filterType
	 */
	public String getFilterType() {
		return filterType;
	}

	/**
	 * @param filterType the filterType to set
	 */
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	/**
	 * @return the fixedDamage
	 */
	public int getFixedDamage() {
		return fixedDamage;
	}

	/**
	 * @param fixedDamage the fixedDamage to set
	 */
	public void setFixedDamage(int fixedDamage) {
		this.fixedDamage = fixedDamage;
	}

	/**
	 * @return the gearTypeId
	 */
	public int getGearTypeId() {
		return gearTypeId;
	}

	/**
	 * @param gearTypeId the gearTypeId to set
	 */
	public void setGearTypeId(int gearTypeId) {
		this.gearTypeId = gearTypeId;
	}

	/**
	 * @return the grantedModifiers
	 */
	public Object[] getGrantedModifiers() {
		return grantedModifiers;
	}

	/**
	 * @param grantedModifiers the grantedModifiers to set
	 */
	public void setGrantedModifiers(Object[] grantedModifiers) {
		this.grantedModifiers = grantedModifiers;
	}

	/**
	 * @return the groupedId
	 */
	public int getGroupedId() {
		return groupedId;
	}

	/**
	 * @param groupedId the groupedId to set
	 */
	public void setGroupedId(int groupedId) {
		this.groupedId = groupedId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the isConsumable
	 */
	public boolean isConsumable() {
		return isConsumable;
	}

	/**
	 * @param isConsumable the isConsumable to set
	 */
	public void setConsumable(boolean isConsumable) {
		this.isConsumable = isConsumable;
	}

	/**
	 * @return the isHomebrew
	 */
	public boolean isHomebrew() {
		return isHomebrew;
	}

	/**
	 * @param isHomebrew the isHomebrew to set
	 */
	public void setHomebrew(boolean isHomebrew) {
		this.isHomebrew = isHomebrew;
	}

	/**
	 * @return the isMonkWeapon
	 */
	public boolean isMonkWeapon() {
		return isMonkWeapon;
	}

	/**
	 * @param isMonkWeapon the isMonkWeapon to set
	 */
	public void setMonkWeapon(boolean isMonkWeapon) {
		this.isMonkWeapon = isMonkWeapon;
	}

	/**
	 * @return the isPack
	 */
	public boolean isPack() {
		return isPack;
	}

	/**
	 * @param isPack the isPack to set
	 */
	public void setPack(boolean isPack) {
		this.isPack = isPack;
	}

	/**
	 * @return the largeAvatarUrl
	 */
	public String getLargeAvatarUrl() {
		return largeAvatarUrl;
	}

	/**
	 * @param largeAvatarUrl the largeAvatarUrl to set
	 */
	public void setLargeAvatarUrl(String largeAvatarUrl) {
		this.largeAvatarUrl = largeAvatarUrl;
	}

	/**
	 * @return the levelInfusionGranted
	 */
	public int getLevelInfusionGranted() {
		return levelInfusionGranted;
	}

	/**
	 * @param levelInfusionGranted the levelInfusionGranted to set
	 */
	public void setLevelInfusionGranted(int levelInfusionGranted) {
		this.levelInfusionGranted = levelInfusionGranted;
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
	 * @return the maxUses
	 */
	public int getMaxUses() {
		return maxUses;
	}

	/**
	 * @param maxUses the maxUses to set
	 */
	public void setMaxUses(int maxUses) {
		this.maxUses = maxUses;
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
	 * @return the numberUsed
	 */
	public int getNumberUsed() {
		return numberUsed;
	}

	/**
	 * @param numberUsed the numberUsed to set
	 */
	public void setNumberUsed(int numberUsed) {
		this.numberUsed = numberUsed;
	}

	/**
	 * @return the properties
	 */
	public ItemProperty[] getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(ItemProperty[] properties) {
		this.properties = properties;
	}

	/**
	 * @return the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(int range) {
		this.range = range;
	}

	/**
	 * @return the rarity
	 */
	public String getRarity() {
		return rarity;
	}

	/**
	 * @param rarity the rarity to set
	 */
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	/**
	 * @return the resetType
	 */
	public String getResetType() {
		return resetType;
	}

	/**
	 * @param resetType the resetType to set
	 */
	public void setResetType(String resetType) {
		this.resetType = resetType;
	}

	/**
	 * @return the resetTypeDescription
	 */
	public String getResetTypeDescription() {
		return resetTypeDescription;
	}

	/**
	 * @param resetTypeDescription the resetTypeDescription to set
	 */
	public void setResetTypeDescription(String resetTypeDescription) {
		this.resetTypeDescription = resetTypeDescription;
	}

	/**
	 * @return the snippet
	 */
	public String getSnippet() {
		return snippet;
	}

	/**
	 * @param snippet the snippet to set
	 */
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	/**
	 * @return the sourceId
	 */
	public int getSourceId() {
		return sourceId;
	}

	/**
	 * @param sourceId the sourceId to set
	 */
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @return the sourcePageNumber
	 */
	public int getSourcePageNumber() {
		return sourcePageNumber;
	}

	/**
	 * @param sourcePageNumber the sourcePageNumber to set
	 */
	public void setSourcePageNumber(int sourcePageNumber) {
		this.sourcePageNumber = sourcePageNumber;
	}

	/**
	 * @return the stackable
	 */
	public boolean isStackable() {
		return stackable;
	}

	/**
	 * @param stackable the stackable to set
	 */
	public void setStackable(boolean stackable) {
		this.stackable = stackable;
	}

	/**
	 * @return the stealthCheck
	 */
	public int getStealthCheck() {
		return stealthCheck;
	}

	/**
	 * @param stealthCheck the stealthCheck to set
	 */
	public void setStealthCheck(int stealthCheck) {
		this.stealthCheck = stealthCheck;
	}

	/**
	 * @return the strengthRequirement
	 */
	public int getStrengthRequirement() {
		return strengthRequirement;
	}

	/**
	 * @param strengthRequirement the strengthRequirement to set
	 */
	public void setStrengthRequirement(int strengthRequirement) {
		this.strengthRequirement = strengthRequirement;
	}

	/**
	 * @return the subType
	 */
	public String getSubType() {
		return subType;
	}

	/**
	 * @param subType the subType to set
	 */
	public void setSubType(String subType) {
		this.subType = subType;
	}

	/**
	 * @return the tags
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the weaponBehaviors
	 */
	public String[] getWeaponBehaviors() {
		return weaponBehaviors;
	}

	/**
	 * @param weaponBehaviors the weaponBehaviors to set
	 */
	public void setWeaponBehaviors(String[] weaponBehaviors) {
		this.weaponBehaviors = weaponBehaviors;
	}

	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "ItemDefinition [armorClass=" + armorClass + ", armorTypeId=" + armorTypeId + ", attackType="
				+ attackType + ", attunementDescription=" + attunementDescription + ", avatarUrl=" + avatarUrl
				+ ", baseArmorName=" + baseArmorName + ", baseItemId=" + baseItemId + ", baseTypeId=" + baseTypeId
				+ ", bundleSize=" + bundleSize + ", canAttune=" + canAttune + ", canBeAddedToInventory="
				+ canBeAddedToInventory + ", canEquip=" + canEquip + ", categoryId=" + categoryId + ", cost=" + cost
				+ ", damage=" + damage + ", damageType=" + damageType + ", description=" + description
				+ ", entityTypeId=" + entityTypeId + ", filterType=" + filterType + ", fixedDamage=" + fixedDamage
				+ ", gearTypeId=" + gearTypeId + ", grantedModifiers=" + Arrays.toString(grantedModifiers)
				+ ", groupedId=" + groupedId + ", id=" + id + ", isConsumable=" + isConsumable + ", isHomebrew="
				+ isHomebrew + ", isMonkWeapon=" + isMonkWeapon + ", isPack=" + isPack + ", largeAvatarUrl="
				+ largeAvatarUrl + ", levelInfusionGranted=" + levelInfusionGranted + ", longRange=" + longRange
				+ ", magic=" + magic + ", maxUses=" + maxUses + ", name=" + name + ", numberUsed=" + numberUsed
				+ ", properties=" + Arrays.toString(properties) + ", range=" + range + ", rarity=" + rarity
				+ ", resetType=" + resetType + ", resetTypeDescription=" + resetTypeDescription + ", snippet=" + snippet
				+ ", sourceId=" + sourceId + ", sourcePageNumber=" + sourcePageNumber + ", stackable=" + stackable
				+ ", stealthCheck=" + stealthCheck + ", strengthRequirement=" + strengthRequirement + ", subType="
				+ subType + ", tags=" + Arrays.toString(tags) + ", type=" + type + ", version=" + version
				+ ", weaponBehaviors=" + Arrays.toString(weaponBehaviors) + ", weight=" + weight + "]";
	}
}
