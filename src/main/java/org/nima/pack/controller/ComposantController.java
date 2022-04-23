package org.nima.pack.controller;
import java.util.List;
import java.util.Optional;
import org.nima.pack.model.Composant;
import org.nima.pack.repository.ComposantRepo;
import org.nima.pack.repository.PackRepo;
import org.nima.pack.service.UtilisateurService;
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
@RequestMapping(path = "/composant")
public class ComposantController {
	@Autowired
	ComposantRepo cmpRepo;
	@Autowired
	PackRepo pRepo;

	@PostMapping(path = "/add")
	public Composant ajouterPack(@RequestBody Composant cmp) {
		
		return cmpRepo.save(cmp);
	}
	
	@GetMapping(path = "/liste")
	public List<Composant> getAllPack(){
		return cmpRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Composant> getPackById(@PathVariable Long id){
		return cmpRepo.findById(id);
	}
}
