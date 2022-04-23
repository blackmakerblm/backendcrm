package org.nima.pack.controller;

import java.util.List;
import java.util.Optional;

import org.nima.pack.model.Magasin;
import org.nima.pack.model.Magasinier;
import org.nima.pack.model.Produit;
import org.nima.pack.repository.MaganisierRepo;
import org.nima.pack.repository.MagasinRepo;
import org.nima.pack.repository.UtilisateurRepo;
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
@RequestMapping(path = "/magasin")
public class MagasinController {
	@Autowired
	MagasinRepo mRepo;
	@Autowired
	UtilisateurRepo uRepo;
	
	@PostMapping(path = "/add")
	public Magasin creerNouveauMagasin(@RequestBody Magasin p) {
		if(!mRepo.existsByNom(p.getNom()))
		return mRepo.save(p);
		return p;
	}
	
	@GetMapping(path = "/liste")
	public List<Magasin> getAllProduits(){
		return mRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Magasin> getProduitById(@PathVariable Long id){
		return mRepo.findById(id);
	}
	@PutMapping(path = "/{id}/magasinier/{idmag}")
	public ResponseEntity<Magasin> ajouterProduitACategorie(@PathVariable(name = "id") Long id,@PathVariable(name = "idmag") Long idmag){
		Optional<Magasin> magasin = mRepo.findById(id);
		if(!magasin.isPresent()) 
			return ResponseEntity.notFound().build();
		else {
			magasin.get().
			setMagasinier(uRepo.findById(idmag).get());
		
		return ResponseEntity.accepted().body(mRepo.save(magasin.get()));
		
		}
		
	}
}
