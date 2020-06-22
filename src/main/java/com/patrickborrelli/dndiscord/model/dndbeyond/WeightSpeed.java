package com.patrickborrelli.dndiscord.model.dndbeyond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple model for a weight speed json element, placeholder for minimal functionality until
 * dndungeon library is incorporated with dndiscord.
 * 
 * @author Patrick Borrelli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeightSpeed {
	private NormalWeightSpeed normal;
	private int encumbered;
	private int heavilyEncumbered;
	private int pushDragLift;
	private int override;
	
	public WeightSpeed() {
		
	}
	
	/**
	 * @return NormalWeightSpeed the normal
	 */
	public NormalWeightSpeed getNormal() {
		return normal;
	}

	/**
	 * @param NormalWeightSpeed the normal to set
	 */
	public void setNormal(NormalWeightSpeed normal) {
		this.normal = normal;
	}

	/**
	 * @return int the encumbered
	 */
	public int getEncumbered() {
		return encumbered;
	}

	/**
	 * @param int the encumbered to set
	 */
	public void setEncumbered(int encumbered) {
		this.encumbered = encumbered;
	}

	/**
	 * @return int the heavilyEncumbered
	 */
	public int getHeavilyEncumbered() {
		return heavilyEncumbered;
	}

	/**
	 * @param int the heavilyEncumbered to set
	 */
	public void setHeavilyEncumbered(int heavilyEncumbered) {
		this.heavilyEncumbered = heavilyEncumbered;
	}

	/**
	 * @return int the pushDragLift
	 */
	public int getPushDragLift() {
		return pushDragLift;
	}

	/**
	 * @param int the pushDragLift to set
	 */
	public void setPushDragLift(int pushDragLift) {
		this.pushDragLift = pushDragLift;
	}

	/**
	 * @return int the override
	 */
	public int getOverride() {
		return override;
	}

	/**
	 * @param int the override to set
	 */
	public void setOverride(int override) {
		this.override = override;
	}

	@Override
	public String toString() {
		return "WeightSpeed [normal=" + normal + ", encumbered=" + encumbered + ", heavilyEncumbered="
				+ heavilyEncumbered + ", pushDragLift=" + pushDragLift + ", override=" + override + "]";
	}

	class NormalWeightSpeed {
		private int walk;
		private int fly;
		private int burrow;
		private int swim;
		private int climb;
		
		public NormalWeightSpeed() {
			
		}

		/**
		 * @return int the walk
		 */
		public int getWalk() {
			return walk;
		}

		/**
		 * @param int the walk to set
		 */
		public void setWalk(int walk) {
			this.walk = walk;
		}

		/**
		 * @return int the fly
		 */
		public int getFly() {
			return fly;
		}

		/**
		 * @param int the fly to set
		 */
		public void setFly(int fly) {
			this.fly = fly;
		}

		/**
		 * @return int the burrow
		 */
		public int getBurrow() {
			return burrow;
		}

		/**
		 * @param int the burrow to set
		 */
		public void setBurrow(int burrow) {
			this.burrow = burrow;
		}

		/**
		 * @return int the swim
		 */
		public int getSwim() {
			return swim;
		}

		/**
		 * @param int the swim to set
		 */
		public void setSwim(int swim) {
			this.swim = swim;
		}

		/**
		 * @return int the climb
		 */
		public int getClimb() {
			return climb;
		}

		/**
		 * @param int the climb to set
		 */
		public void setClimb(int climb) {
			this.climb = climb;
		}

		@Override
		public String toString() {
			return "NormalWeightSpeed [walk=" + walk + ", fly=" + fly + ", burrow=" + burrow + ", swim=" + swim
					+ ", climb=" + climb + "]";
		}
		
	}
}
