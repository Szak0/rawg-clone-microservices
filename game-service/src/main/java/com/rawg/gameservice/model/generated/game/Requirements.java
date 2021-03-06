package com.rawg.gameservice.model.generated.game;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Requirements{

	@JsonProperty("minimum")
	private String minimum;

	@JsonProperty("recommended")
	private String recommended;

	public void setMinimum(String minimum){
		this.minimum = minimum;
	}

	public String getMinimum(){
		return minimum;
	}

	public void setRecommended(String recommended){
		this.recommended = recommended;
	}

	public String getRecommended(){
		return recommended;
	}

	@Override
 	public String toString(){
		return 
			"Requirements{" + 
			"minimum = '" + minimum + '\'' + 
			",recommended = '" + recommended + '\'' + 
			"}";
		}
}