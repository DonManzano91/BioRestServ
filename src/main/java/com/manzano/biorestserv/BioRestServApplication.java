package com.manzano.biorestserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO Modifica FrequentWordsService y utility para que sean mas elegantes/usen streams
//TODO Crea el objeto base para mapear el json que usara FrequentWords
//TODO Modifica/crea controller para que FrequenWords.CountPatterns tome sus argumentos de un json, testGens

@SpringBootApplication(scanBasePackages = "com.manzano.BioRestServ")
public class BioRestServApplication {

	public static void main(String[] args) {
		SpringApplication.run(BioRestServApplication.class, args);
	}

}
