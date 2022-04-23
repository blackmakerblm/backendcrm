package org.nima.pack.controller;

import java.util.List;
import java.util.Optional;

import org.nima.pack.model.Composant;
import org.nima.pack.model.Facture;
import org.nima.pack.repository.CommandeRepo;
import org.nima.pack.repository.ComposantRepo;
import org.nima.pack.repository.FactureRepo;
import org.nima.pack.repository.PackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@CrossOrigin(origins  = "http://localhost:5555",maxAge = 1800,allowCredentials = "true")
@RestController
@RequestMapping(path = "/facture")
public class FactureController {
	@Autowired
	FactureRepo factureRepo;
	@Autowired
	CommandeRepo cmdRepo;

	@PostMapping(path = "/add")
	public Facture genererFacture(@RequestBody Facture facture) {
		if(cmdRepo.existsById(facture.getCommande().getId()))
		{
			List<Composant> listeComposants = cmdRepo.findById(facture.getCommande().getId()).get().getComposants();
			facture.calculerMontantGlobal(listeComposants);
	
		}
		return factureRepo.save(facture);
	}
	
	@GetMapping(path = "/liste")
	public List<Facture> getAllPack(){
		return factureRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Facture> getPackById(@PathVariable Long id){
		return factureRepo.findById(id);
	}
}
