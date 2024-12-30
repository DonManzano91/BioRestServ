package com.manzano.biorestserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO: 1. Ajusta logica para usar concepts de bioinfo en lugar de lo actual de "WxGenBeg"
//TODO: Se resolvieron los errores de bean calling, arregla lo de arriba por que el interpreter no puede hacer cosas
// el boot

@SpringBootApplication(scanBasePackages = "com.manzano.BioRestServ")
public class BioRestServApplication {

	public static void main(String[] args) {
		SpringApplication.run(BioRestServApplication.class, args);
	}

}
