package org.nima.pack.controller;

import java.util.List;
import java.util.Optional;

import org.nima.pack.model.BonDeSortie;
import org.nima.pack.model.Magasin;
import org.nima.pack.model.Utilisateur;
import org.nima.pack.repository.BonDeSortieRepo;
import org.nima.pack.repository.CommandeRepo;
import org.nima.pack.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins  = "http://localhost:5555",maxAge = 1800,allowCredentials = "true")
@RestController
@RequestMapping(path = "/bondesortie")
public class BDSController {
	@Autowired 
	BonDeSortieRepo bdsRepo;
	
	@Autowired
	UtilisateurService uService;
	@Autowired
	CommandeRepo cmdRepo;
	
	@GetMapping(path = "/liste")
	public List<BonDeSortie> getAllBDS(){

		return bdsRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Optional<BonDeSortie> getProduitById(@PathVariable Long id){
		return bdsRepo.findById(id);
	}
	@PutMapping(path = "/signer/{id}")
	public ResponseEntity signerBonDeSortie(@PathVariable(name = "id") Long id){
		Utilisateur commerical =  uService.findByNom(SecurityContextHolder.getContext().getAuthentication().getName()).get();
		Optional<BonDeSortie> bondesortie = bdsRepo.findById(id);
		
		if(!bondesortie.isPresent()) 
			return ResponseEntity.notFound().build();
		else {
			Utilisateur createurCommande = cmdRepo.getById(bondesortie.get().getCommande().getId()).getCommercials();
			if(commerical.getId()==createurCommande.getId()) {
				bondesortie.get().setSigned(1);
				
				return ResponseEntity.accepted().body(bdsRepo.save(bondesortie.get()));
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Vous n'avez pas créé la commande donc vous ne pouvez pas signer les bons");
			
		
		}
		
	}
}
