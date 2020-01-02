package com.elviredev.catalogueservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "P1", types = Produit.class)
public interface ProduitProjection {
    // méthode pour retourner uniquement le prix
    public double getPrice();
    public String getDesignation();
}
