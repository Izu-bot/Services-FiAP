package br.com.fiap.rastrearcaminhoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // Dizer que é um client do service discovery
public class RastrearCaminhoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RastrearCaminhoesApplication.class, args);
	}

}
