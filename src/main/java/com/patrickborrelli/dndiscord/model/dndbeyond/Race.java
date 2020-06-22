package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a Race json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Race {

	private int entityRaceId;
	private long entityRaceTypeId;
	private String fullName;
	private int baseRaceId;
	private long baseRaceTypeId;
	private String description;
	private String avatarUrl;
	private String largeAvatarUrl;
	private String portraitAvatarUrl;
	private String moreDetailsUrl;
	private boolean isHomebrew;
	private int[] sourceIds;
	private int[] groupIds;
	private int type;
	private String subRaceShortName;
	private String baseName;
	private RacialTrait[] racialTraits;
	private WeightSpeed weightSpeeds;
	private long[] featIds;
	private String size;
	private int sizeId;	
	
	public Race() {
		
	}

	/**
	 * @return int the entityRaceId
	 */
	public int getEntityRaceId() {
		return entityRaceId;
	}

	/**
	 * @param int the entityRaceId to set
	 */
	public void setEntityRaceId(int entityRaceId) {
		this.entityRaceId = entityRaceId;
	}

	/**
	 * @return long the entityRaceTypeId
	 */
	public long getEntityRaceTypeId() {
		return entityRaceTypeId;
	}

	/**
	 * @param long the entityRaceTypeId to set
	 */
	public void setEntityRaceTypeId(long entityRaceTypeId) {
		this.entityRaceTypeId = entityRaceTypeId;
	}

	/**
	 * @return String the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param String the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return int the baseRaceId
	 */
	public int getBaseRaceId() {
		return baseRaceId;
	}

	/**
	 * @param int the baseRaceId to set
	 */
	public void setBaseRaceId(int baseRaceId) {
		this.baseRaceId = baseRaceId;
	}

	/**
	 * @return long the baseRaceTypeId
	 */
	public long getBaseRaceTypeId() {
		return baseRaceTypeId;
	}

	/**
	 * @param long the baseRaceTypeId to set
	 */
	public void setBaseRaceTypeId(long baseRaceTypeId) {
		this.baseRaceTypeId = baseRaceTypeId;
	}

	/**
	 * @return String the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param String the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return String the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}

	/**
	 * @param String the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	/**
	 * @return String the largeAvatarUrl
	 */
	public String getLargeAvatarUrl() {
		return largeAvatarUrl;
	}

	/**
	 * @param String the largeAvatarUrl to set
	 */
	public void setLargeAvatarUrl(String largeAvatarUrl) {
		this.largeAvatarUrl = largeAvatarUrl;
	}

	/**
	 * @return String the portraitAvatarUrl
	 */
	public String getPortraitAvatarUrl() {
		return portraitAvatarUrl;
	}

	/**
	 * @param String the portraitAvatarUrl to set
	 */
	public void setPortraitAvatarUrl(String portraitAvatarUrl) {
		this.portraitAvatarUrl = portraitAvatarUrl;
	}

	/**
	 * @return String the moreDetailsUrl
	 */
	public String getMoreDetailsUrl() {
		return moreDetailsUrl;
	}

	/**
	 * @param String the moreDetailsUrl to set
	 */
	public void setMoreDetailsUrl(String moreDetailsUrl) {
		this.moreDetailsUrl = moreDetailsUrl;
	}

	/**
	 * @return boolean the isHomebrew
	 */
	public boolean isHomebrew() {
		return isHomebrew;
	}

	/**
	 * @param boolean the isHomebrew to set
	 */
	public void setHomebrew(boolean isHomebrew) {
		this.isHomebrew = isHomebrew;
	}

	/**
	 * @return int[] the sourceIds
	 */
	public int[] getSourceIds() {
		return sourceIds;
	}

	/**
	 * @param int[] the sourceIds to set
	 */
	public void setSourceIds(int[] sourceIds) {
		this.sourceIds = sourceIds;
	}

	/**
	 * @return int[] the groupIds
	 */
	public int[] getGroupIds() {
		return groupIds;
	}

	/**
	 * @param int[] the groupIds to set
	 */
	public void setGroupIds(int[] groupIds) {
		this.groupIds = groupIds;
	}

	/**
	 * @return int the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param int the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return String the subRaceShortName
	 */
	public String getSubRaceShortName() {
		return subRaceShortName;
	}

	/**
	 * @param String the subRaceShortName to set
	 */
	public void setSubRaceShortName(String subRaceShortName) {
		this.subRaceShortName = subRaceShortName;
	}

	/**
	 * @return String the baseName
	 */
	public String getBaseName() {
		return baseName;
	}

	/**
	 * @param String the baseName to set
	 */
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	/**
	 * @return RacialTrait[] the racialTraits
	 */
	public RacialTrait[] getRacialTraits() {
		return racialTraits;
	}

	/**
	 * @param RacialTrait[] the racialTraits to set
	 */
	public void setRacialTraits(RacialTrait[] racialTraits) {
		this.racialTraits = racialTraits;
	}

	/**
	 * @return WeightSpeed the weightSpeeds
	 */
	public WeightSpeed getWeightSpeeds() {
		return weightSpeeds;
	}

	/**
	 * @param WeightSpeed the weightSpeeds to set
	 */
	public void setWeightSpeeds(WeightSpeed weightSpeeds) {
		this.weightSpeeds = weightSpeeds;
	}

	/**
	 * @return long[] the featIds
	 */
	public long[] getFeatIds() {
		return featIds;
	}

	/**
	 * @param long[] the featIds to set
	 */
	public void setFeatIds(long[] featIds) {
		this.featIds = featIds;
	}

	/**
	 * @return String the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param String the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return int the sizeId
	 */
	public int getSizeId() {
		return sizeId;
	}

	/**
	 * @param int the sizeId to set
	 */
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	@Override
	public String toString() {
		return "Race [entityRaceId=" + entityRaceId + ", entityRaceTypeId=" + entityRaceTypeId + ", fullName="
				+ fullName + ", baseRaceId=" + baseRaceId + ", baseRaceTypeId=" + baseRaceTypeId + ", description="
				+ description + ", avatarUrl=" + avatarUrl + ", largeAvatarUrl=" + largeAvatarUrl
				+ ", portraitAvatarUrl=" + portraitAvatarUrl + ", moreDetailsUrl=" + moreDetailsUrl + ", isHomebrew="
				+ isHomebrew + ", sourceIds=" + Arrays.toString(sourceIds) + ", groupIds=" + Arrays.toString(groupIds)
				+ ", type=" + type + ", subRaceShortName=" + subRaceShortName + ", baseName=" + baseName
				+ ", racialTraits=" + Arrays.toString(racialTraits) + ", weightSpeeds=" + weightSpeeds + ", featIds="
				+ Arrays.toString(featIds) + ", size=" + size + ", sizeId=" + sizeId + "]";
	}
	
}
