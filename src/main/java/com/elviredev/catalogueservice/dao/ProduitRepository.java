package com.elviredev.catalogueservice.dao;


import com.elviredev.catalogueservice.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource // API REST
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    // méthode pour rechercher produit par mot-clé
    @RestResource(path = "/byDesignation")
    List<Produit> findByDesignationContains(@Param("mc") String des);

    // méthode pour rechercher page de produits
    @RestResource(path = "/byDesignationPage")
    Page<Produit> findByDesignationContains(@Param("mc") String des, Pageable pageable);
}
