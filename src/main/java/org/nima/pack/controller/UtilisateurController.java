package org.nima.pack.controller;

import java.util.List;

import org.nima.pack.model.Utilisateur;
import org.nima.pack.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@CrossOrigin(origins  = "http://localhost:5555",maxAge = 1800,allowCredentials = "true")
@RestController
@RequestMapping(path = "/utilisateurs")
public class UtilisateurController {

	
		@Autowired
		private UtilisateurService u_Service;
		
		@GetMapping()
		public List<Utilisateur> getAllUtilisateurs() {
			return u_Service.getAllUtilisateur();
		}
		
		@PostMapping()
		public Utilisateur addUtilisateur(@RequestBody Utilisateur u) {
		
			return u_Service.inscrireUtilisateur(u);
		}
}
