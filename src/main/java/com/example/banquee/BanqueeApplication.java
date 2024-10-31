package com.example.banquee;

import com.example.banquee.entity.Compte;
import com.example.banquee.entity.TypeCompte;
import com.example.banquee.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BanqueeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueeApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository) {
		return args -> {
			// Génération d'un numéro de compte fictif
			String numeroCompte1 = "FR76" + Math.round(Math.random() * 9000000000L + 1000000000L);
			String numeroCompte2 = "FR76" + Math.round(Math.random() * 9000000000L + 1000000000L);
			String numeroCompte3 = "FR76" + Math.round(Math.random() * 9000000000L + 1000000000L);

			compteRepository.save(new Compte(null, numeroCompte1, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null, numeroCompte2, Math.random() * 9000, new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null, numeroCompte3, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));

			compteRepository.findAll().forEach(c -> {
				System.out.println(c.toString());
			});
		};
	}
}
