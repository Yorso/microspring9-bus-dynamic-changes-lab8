package com.jorge;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* 
 * 
 * Pushing configuration changes from the Config server to client applications using @RefreshScope:
 * 
 * 1. Open a browser to http://localhost:8002/lucky-word-scope
 * 
 * 2. Make a change in microspring9-cloud-client-lab8.yml file, make local commit of this file and 
 * then make a POST request to http://localhost:8001/bus/refresh to reload changes.
 * 
 * 3. Refresh http://localhost:8002/lucky-word-scope. Your changes should be visible.
 * 
 */

@RestController
@RefreshScope
public class LuckyWordRefreshScopeController {
	 
	@Value("${wordConfig.luckyWord}") String luckyWord;
	@Value("${wordConfig.preamble}") String preamble;
	
	String fullStatement;
	
	@PostConstruct 
	public void init(){
		fullStatement = preamble + ": " + luckyWord;;
	}
	
	@RequestMapping("/lucky-word-scope")
	public String showLuckyWord() {
		//return preamble + ": " + luckyWord;
		return fullStatement;
	}

	//We don't need setters and getters using @RefreshScope
	
}