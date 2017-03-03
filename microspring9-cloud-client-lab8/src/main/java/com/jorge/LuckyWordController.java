package com.jorge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Try: 
 * 		http://localhost:8002/lucky-word  => You should see the lucky word message in your browser
 * 
 * Si tiene perfil activado (ejemplo: spring.profiles.active: northamerica) irá a su archivo yml correspondiente automáticamente (comosellame-northamerica.yml), si no irá al normal (comosellame.yml).
 * 
 */

@RestController
@ConfigurationProperties(prefix="wordConfig") //Add a @ConfigurationProperties annotation using a prefix of “wordConfig”. 
                                              //Notice the properties / getters and setters.
public class LuckyWordController {
	 
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