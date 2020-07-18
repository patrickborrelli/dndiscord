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
	 * @return the entityRaceId
	 */
	public int getEntityRaceId() {
		return entityRaceId;
	}

	/**
	 * @param entityRaceId the entityRaceId to set
	 */
	public void setEntityRaceId(int entityRaceId) {
		this.entityRaceId = entityRaceId;
	}

	/**
	 * @return the entityRaceTypeId
	 */
	public long getEntityRaceTypeId() {
		return entityRaceTypeId;
	}

	/**
	 * @param entityRaceTypeId the entityRaceTypeId to set
	 */
	public void setEntityRaceTypeId(long entityRaceTypeId) {
		this.entityRaceTypeId = entityRaceTypeId;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the baseRaceId
	 */
	public int getBaseRaceId() {
		return baseRaceId;
	}

	/**
	 * @param baseRaceId the baseRaceId to set
	 */
	public void setBaseRaceId(int baseRaceId) {
		this.baseRaceId = baseRaceId;
	}

	/**
	 * @return the baseRaceTypeId
	 */
	public long getBaseRaceTypeId() {
		return baseRaceTypeId;
	}

	/**
	 * @param baseRaceTypeId the baseRaceTypeId to set
	 */
	public void setBaseRaceTypeId(long baseRaceTypeId) {
		this.baseRaceTypeId = baseRaceTypeId;
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
	 * @return the portraitAvatarUrl
	 */
	public String getPortraitAvatarUrl() {
		return portraitAvatarUrl;
	}

	/**
	 * @param portraitAvatarUrl the portraitAvatarUrl to set
	 */
	public void setPortraitAvatarUrl(String portraitAvatarUrl) {
		this.portraitAvatarUrl = portraitAvatarUrl;
	}

	/**
	 * @return the moreDetailsUrl
	 */
	public String getMoreDetailsUrl() {
		return moreDetailsUrl;
	}

	/**
	 * @param moreDetailsUrl the moreDetailsUrl to set
	 */
	public void setMoreDetailsUrl(String moreDetailsUrl) {
		this.moreDetailsUrl = moreDetailsUrl;
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
	 * @return the sourceIds
	 */
	public int[] getSourceIds() {
		return sourceIds;
	}

	/**
	 * @param sourceIds the sourceIds to set
	 */
	public void setSourceIds(int[] sourceIds) {
		this.sourceIds = sourceIds;
	}

	/**
	 * @return the groupIds
	 */
	public int[] getGroupIds() {
		return groupIds;
	}

	/**
	 * @param groupIds the groupIds to set
	 */
	public void setGroupIds(int[] groupIds) {
		this.groupIds = groupIds;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the subRaceShortName
	 */
	public String getSubRaceShortName() {
		return subRaceShortName;
	}

	/**
	 * @param subRaceShortName the subRaceShortName to set
	 */
	public void setSubRaceShortName(String subRaceShortName) {
		this.subRaceShortName = subRaceShortName;
	}

	/**
	 * @return the baseName
	 */
	public String getBaseName() {
		return baseName;
	}

	/**
	 * @param baseName the baseName to set
	 */
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	/**
	 * @return the racialTraits
	 */
	public RacialTrait[] getRacialTraits() {
		return racialTraits;
	}

	/**
	 * @param racialTraits the racialTraits to set
	 */
	public void setRacialTraits(RacialTrait[] racialTraits) {
		this.racialTraits = racialTraits;
	}

	/**
	 * @return the weightSpeeds
	 */
	public WeightSpeed getWeightSpeeds() {
		return weightSpeeds;
	}

	/**
	 * @param weightSpeeds the weightSpeeds to set
	 */
	public void setWeightSpeeds(WeightSpeed weightSpeeds) {
		this.weightSpeeds = weightSpeeds;
	}

	/**
	 * @return the featIds
	 */
	public long[] getFeatIds() {
		return featIds;
	}

	/**
	 * @param featIds the featIds to set
	 */
	public void setFeatIds(long[] featIds) {
		this.featIds = featIds;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the sizeId
	 */
	public int getSizeId() {
		return sizeId;
	}

	/**
	 * @param sizeId the sizeId to set
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
