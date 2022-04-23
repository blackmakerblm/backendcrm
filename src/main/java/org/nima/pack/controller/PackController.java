package org.nima.pack.controller;
import java.util.List;
import java.util.Optional;
import org.nima.pack.model.Pack;
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
@RequestMapping(path = "/pack")
public class PackController {
	@Autowired
	PackRepo packRepo;
	
	
	@PostMapping(path = "/add")
	public Pack ajouterPack(@RequestBody Pack p) {
		return packRepo.save(p);
	}
	
	@GetMapping(path = "/liste")
	public List<Pack> getAllPack(){
		return packRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Pack> getPackById(@PathVariable Long id){
		return packRepo.findById(id);
	}
}
