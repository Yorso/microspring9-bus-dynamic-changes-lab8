package com.jorge;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Try: 
 * 		http://localhost:8002/lucky-word  => You should see the lucky word message in your browser
 * 
 * Si tiene perfil activado (ejemplo: spring.profiles.active: northamerica) irá a su archivo yml correspondiente automáticamente (comosellame-northamerica.yml), si no irá al normal (comosellame.yml).
 * 
 */
/**
 * What happens if the Config Server is unavailable when the “lucky word” application starts? To mitigate this possibility, it is common to run multiple instances of the config server in different racks / zones behind a load balancer.
 * What happens if we change a property after client applications have started? The server picks up the changes immediately, but the client does not. Later we will see how Spring Cloud Bus and refresh scope can be used to dynamically propagate changes.
 *
 */
@SpringBootApplication
public class CloudClientApplication {

	public static void main(String[] args) {
		//System.setProperty("spring.cloud.bootstrap.enabled","false");
		SpringApplication.run(CloudClientApplication.class, args);
	}
}
