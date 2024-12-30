package com.manzano.biorestserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO: Crea el objeto que sera la base de lo que
//TODO: Modifica/crea controller para que FrequenWords.CountPatterns tome sus argumentos de un json, testGens

@SpringBootApplication(scanBasePackages = "com.manzano.BioRestServ")
public class BioRestServApplication {

	public static void main(String[] args) {
		SpringApplication.run(BioRestServApplication.class, args);
	}

}
