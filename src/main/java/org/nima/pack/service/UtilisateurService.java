package org.nima.pack.service;

import java.util.List;
import java.util.Optional;

import org.nima.pack.model.Utilisateur;
import org.nima.pack.repository.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
	@Autowired
	private UtilisateurRepo u_Repo;
	
	public Utilisateur inscrireUtilisateur (Utilisateur u) {
		return u_Repo.save(u);
	}
	
	public List<Utilisateur> getAllUtilisateur(){
		return u_Repo.findAll();
	}
	
	public Optional<Utilisateur> findByNom(String nom){
		return u_Repo.findByNom(nom);
	}
	
	public List<Utilisateur> findByRole(String role){
		return u_Repo.findByRole(role);
	}
	
	public boolean existsByNom(String nom) {
		return u_Repo.existsByNom(nom);
	}
	
}
