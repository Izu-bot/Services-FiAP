package br.com.fiap.notificacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NotificacaoAosMoradoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificacaoAosMoradoresApplication.class, args);
	}

}
