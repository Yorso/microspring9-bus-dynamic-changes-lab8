package com.jorge;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 
 * Pushing configuration changes from the Config server to client applications using @ConfigurationProperties:
 * 
 * 1. Open a browser to http://localhost:8002/lucky-word
 * 
 * 2. Make a change in microspring9-cloud-client-lab8.yml file, make local commit of this file and 
 * then make a POST request to http://localhost:8001/bus/refresh to reload changes.
 * 
 * 3. Refresh http://localhost:8002/lucky-word. Your changes should be visible.
 * 
 */


@RestController
@ConfigurationProperties(prefix="wordConfig") //Add a @ConfigurationProperties annotation using a prefix of “wordConfig”. 
                                              //Notice the properties / getters and setters.
public class LuckyWordConfigurationPropertiesController {
	 
	String luckyWord;
	String preamble;
	
	@RequestMapping("/lucky-word")
	public String showLuckyWord() {
		return preamble + ": " + luckyWord;
	}

	public String getLuckyWord() {
		return luckyWord;
	}

	public void setLuckyWord(String luckyWord) {
		this.luckyWord = luckyWord;
	}

	public String getPreamble() {
		return preamble;
	}

	public void setPreamble(String preamble) {
		this.preamble = preamble;
	}
	
}