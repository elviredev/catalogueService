package com.elviredev.catalogueservice;

import com.elviredev.catalogueservice.dao.ProduitRepository;
import com.elviredev.catalogueservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProduitRestService {
    @Autowired
    private ProduitRepository produitRepository;

    // lister produits
    @GetMapping(value="/listProduits")
    public List<Produit> listProduits(){
        return produitRepository.findAll();
    }

    // afficher un seul produit
    @GetMapping(value="/listProduits/{id}")
    public Produit produitById(@PathVariable(name = "id") Long id){
        return produitRepository.findById(id).get();
    }

    // mettre à jour un produit
    @PutMapping(value="/listProduits/{id}")
    public Produit updateProduit(@PathVariable(name = "id") Long id, @RequestBody Produit p){
        p.setId(id); // on connaît l'ID
        return produitRepository.save(p);
    }

    // enregistrer un produit
    @PostMapping(value="/listProduits")
    public Produit saveProduit(@RequestBody Produit p){
        return produitRepository.save(p);
    }

    // supprimer un produit
    @DeleteMapping(value="/listProduits/{id}")
    public void deleteProduit(@PathVariable(name = "id") Long id){
        produitRepository.deleteById(id);
    }
}
