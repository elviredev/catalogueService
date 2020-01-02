package com.elviredev.catalogueservice;

import com.elviredev.catalogueservice.dao.ProduitRepository;
import com.elviredev.catalogueservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatalogueServiceApplication implements CommandLineRunner {
	@Autowired // injection dépendance interface DAO
	private ProduitRepository produitRepository;
	@Autowired // config Spring Data Rest
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(CatalogueServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// méthode pour afficher les ID
		restConfiguration.exposeIdsFor(Produit.class);
		// insérer data dans BDD
		produitRepository.save(new Produit(null, "Ordinateur HP 11SQ", 850, 3));
		produitRepository.save(new Produit(null, "Imprimante", 280, 4));
		produitRepository.save(new Produit(null, "Smartphone Google Pixel3", 600, 5));

		produitRepository.findAll().forEach(p -> {
			System.out.println(p.toString());
		});


	}
}
