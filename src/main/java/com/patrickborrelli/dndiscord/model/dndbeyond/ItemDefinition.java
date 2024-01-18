package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Simple model for an item definition json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@Data
@NoArgsConstructor
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
	private String cost;
	private ItemDamage damage;
	private String damageType;
	private String description;
	private long entityTypeId;
	private String filterType;
	private int fixedDamage;
	private int gearTypeId;
	private Modifier[] grantedModifiers;
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
	private ItemDefinition[] weaponBehaviors;
	private String weight;
}
