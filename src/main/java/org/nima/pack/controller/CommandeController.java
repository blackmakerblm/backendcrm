package org.nima.pack.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.nima.pack.model.BonDeSortie;
import org.nima.pack.model.Commande;
import org.nima.pack.model.Composant;
import org.nima.pack.model.Utilisateur;
import org.nima.pack.repository.CommandeRepo;
import org.nima.pack.repository.MagasinRepo;
import org.nima.pack.repository.PackRepo;
import org.nima.pack.repository.ProduitRepo;
import org.nima.pack.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@CrossOrigin(origins  = "http://localhost:5555",maxAge = 1800,allowCredentials = "true")
@RestController
@RequestMapping(path = "/commande")
public class CommandeController {
	@Autowired
	CommandeRepo cmdRepo;
	@Autowired
	UtilisateurService uService;
	@Autowired
	PackRepo pRepo;
	@Autowired
	ProduitRepo prodRepo;
	@Autowired
	MagasinRepo magRepo;

	@PostMapping(path = "/add")
	public Commande ajouterPack(@RequestBody Commande cmd) {
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		Utilisateur commerical =  uService.findByNom(SecurityContextHolder.getContext().getAuthentication().getName()).get();
		cmd.setCommercials(commerical);
		List<Composant> composants;
		if(cmd.getComposants()!=null)
		{
			composants = cmd.getComposants();
			cmd.setComposants(composants);
		}
		List<Long> listePack = cmd.getComposants().stream().map(comp->comp.getPack().getId()).distinct().collect(Collectors.toList());
		List<Long> listeProduit = listePack.stream().map(comp->pRepo.findById(comp).get().getProduit().getId()).distinct().collect(Collectors.toList());
		List<Long> listeMagasin = listeProduit.stream().map(comp->prodRepo.findById(comp).get().getMagasin().getId()).distinct().collect(Collectors.toList());
		List<BonDeSortie> listeBonDeSorties=new ArrayList<>();
		for(Long c:listeMagasin) {
			Date date = new Date();
			int signe =0;
			String codeString ="00x";
			BonDeSortie bonDeSortie = new  BonDeSortie();
			bonDeSortie.setDate(date);
			bonDeSortie.setCode(codeString);
			bonDeSortie.setSigned(signe);
			bonDeSortie.setMagasinier(magRepo.findById(c).get().getMagasinier());
			listeBonDeSorties.add(bonDeSortie);
		}
		cmd.setBondesorties(listeBonDeSorties);
		return cmdRepo.save(cmd);
	}
	
	@GetMapping(path = "/liste")
	public List<Commande> getAllPack(){
		return cmdRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Commande> getPackById(@PathVariable(name = "id") Long id){
		return cmdRepo.findById(id);
	}
}
