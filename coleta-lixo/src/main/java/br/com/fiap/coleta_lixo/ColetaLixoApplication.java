package br.com.fiap.coleta_lixo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ColetaLixoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColetaLixoApplication.class, args);
	}

}
