package org.nima.pack.controller;
import java.util.List;
import java.util.Optional;
import org.nima.pack.model.Categorie;
import org.nima.pack.repository.CategorieRepo;
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
@RequestMapping(path = "/categorie")
public class CategorieController {
	@Autowired
	CategorieRepo catRepo;
	
	
	@PostMapping(path = "/add")
	public Categorie ajouterPack(@RequestBody Categorie p) {
		return catRepo.save(p);
	}
	
	@GetMapping(path = "/liste")
	public List<Categorie> getAllPack(){
		return catRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Categorie> getPackById(@PathVariable Long id){
		return catRepo.findById(id);
	}

}
