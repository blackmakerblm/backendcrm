package org.nima.pack.controller;

import java.util.List;
import java.util.Optional;

import org.nima.pack.model.Produit;
import org.nima.pack.repository.CategorieRepo;
import org.nima.pack.repository.MagasinRepo;
import org.nima.pack.repository.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@CrossOrigin(origins  = "http://localhost:5555",maxAge = 1800,allowCredentials = "true")

@RestController
@RequestMapping(path = "/produit")
public class ProduitController {
	
	@Autowired
	ProduitRepo pRepo;
	//Je dois utiliser un service normalement, à remplacer apres 
	@Autowired
	CategorieRepo cRepo;
	@Autowired
	MagasinRepo mrepo;
	
	@PostMapping(path = "/add")
	public Produit ajouterProduit(@RequestBody Produit p) {
		if(p.getMagasin()!=null) {
			if(mrepo.existsByNom(p.getMagasin().getNom())) {
				p.setMagasin(mrepo.findByNom(p.getMagasin().getNom()));
			}
		}
		return pRepo.save(p);
	}
	
	@GetMapping(path = "/liste")
	public List<Produit> getAllProduits(){
		return pRepo.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Produit> getProduitById(@PathVariable Long id){
		return pRepo.findById(id);
	}
	
	@PutMapping(path = "/{id}/categorie/{idCat}")
	public ResponseEntity<Produit> ajouterProduitACategorie(@PathVariable(name = "id") Long id,@PathVariable(name = "idCat") Long idcat){
		Optional<Produit> produit = pRepo.findById(id);
		if(!produit.isPresent()) 
			return ResponseEntity.notFound().build();
		else {
		produit.get().setCategorie(cRepo.findById(idcat).get());
		
		return ResponseEntity.accepted().body(pRepo.save(produit.get()));
		
		}
		
	}
	

}
