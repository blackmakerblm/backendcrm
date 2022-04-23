package org.nima.pack.repository;


import java.util.List;
import java.util.Optional;

import org.nima.pack.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
	
	Optional<Utilisateur> findByNom(String nom);

	Boolean existsByNom(String nom);
	List<Utilisateur> findByRole(String role);


	
}
