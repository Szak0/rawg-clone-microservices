package com.rawg.gameservice.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rawg.gameservice.model.generated.Clips;

public class Clip{

	@JsonProperty("preview")
	private String preview;

	@JsonProperty("clips")
	private Clips clips;

	@JsonProperty("video")
	private String video;

	@JsonProperty("clip")
	private String clip;

	public void setPreview(String preview){
		this.preview = preview;
	}

	public String getPreview(){
		return preview;
	}

	public void setClips(Clips clips){
		this.clips = clips;
	}

	public Clips getClips(){
		return clips;
	}

	public void setVideo(String video){
		this.video = video;
	}

	public String getVideo(){
		return video;
	}

	public void setClip(String clip){
		this.clip = clip;
	}

	public String getClip(){
		return clip;
	}

	@Override
 	public String toString(){
		return 
			"Clip{" + 
			"preview = '" + preview + '\'' + 
			",clips = '" + clips + '\'' + 
			",video = '" + video + '\'' + 
			",clip = '" + clip + '\'' + 
			"}";
		}
}