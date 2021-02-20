package com.patrickborrelli.dndiscord.model.dndbeyond;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple model for an options collection json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Options {

	private Option[] race;
	@JsonProperty("class")
	private Option[] classOptions;
	private Option[] feat;
	
	public Options() {
		
	}

	/**
	 * @return Option[] the race
	 */
	public Option[] getRace() {
		return race;
	}

	/**
	 * @param race Option[] the race to set
	 */
	public void setRace(Option[] race) {
		this.race = race;
	}

	/**
	 * @return Option[] the classOptions
	 */
	public Option[] getClassOptions() {
		return classOptions;
	}

	/**
	 * @param classOptions Option[] the classOptions to set
	 */
	public void setClassOptions(Option[] classOptions) {
		this.classOptions = classOptions;
	}

	/**
	 * @return Option[] the feat
	 */
	public Option[] getFeat() {
		return feat;
	}

	/**
	 * @param feat Option[] the feat to set
	 */
	public void setFeat(Option[] feat) {
		this.feat = feat;
	}

	@Override
	public String toString() {
		return "Options [race=" + Arrays.toString(race) + ", classOptions=" + Arrays.toString(classOptions) + ", feat="
				+ Arrays.toString(feat) + "]";
	}
}
