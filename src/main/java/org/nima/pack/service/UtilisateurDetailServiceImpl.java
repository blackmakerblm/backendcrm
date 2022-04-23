package org.nima.pack.service;

import org.nima.pack.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UtilisateurDetailServiceImpl implements UserDetailsService {
	@Autowired
	UtilisateurService UtilisateurService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur = UtilisateurService.findByNom(username)
				.orElseThrow(() -> new UsernameNotFoundException("L'utilisateur: " + username+"  n'existe pas"));

		return UtilisateurDetailsImpl.build(utilisateur);
	}

}
