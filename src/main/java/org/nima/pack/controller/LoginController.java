package org.nima.pack.controller;
import java.util.Set;
import javax.validation.Valid;
import org.nima.pack.model.Utilisateur;
import org.nima.pack.security.UserRole;
import org.nima.pack.service.UtilisateurDetailsImpl;
import org.nima.pack.service.UtilisateurService;
import org.nima.payload.ConnectionDataModel;
import org.nima.payload.InscriptionDataModel;
import org.nima.payload.MessageReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins  = "http://localhost:38927",maxAge = 1800,allowCredentials = "true")
@RestController
@RequestMapping(path = "/auth")
public class LoginController {

	@Autowired
	AuthenticationManager authenticationmanager;
	
	@Autowired
	UtilisateurService utilisateurservice;
	
	@Autowired
	PasswordEncoder passwordencoder;
	
	@PostMapping(path = "/connection")
	public Authentication connection(@Valid @RequestBody ConnectionDataModel requete) {
		
	   UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =new UsernamePasswordAuthenticationToken(requete.getNom(),requete.getMdp());
	   Authentication authentication = authenticationmanager.authenticate(usernamePasswordAuthenticationToken);
	   SecurityContextHolder.getContext().setAuthentication(authentication);
	  
	  // SecurityContext context = SecurityContextHolder.getContext();
	   UtilisateurDetailsImpl utilisateurDetails = (UtilisateurDetailsImpl)authentication.getPrincipal();
	   Set<SimpleGrantedAuthority> role = (Set<SimpleGrantedAuthority>) utilisateurDetails.getAuthorities();
	  if(authentication.isAuthenticated()) {
		  System.out.print("CONNECTÉ");
	  }
	  else {
		System.out.print("non connecté");
	}
	   return authentication;
	   
				
	    
	}
	@PostMapping(path = "/inscription")
	public ResponseEntity<?> inscription(@Valid @RequestBody InscriptionDataModel requete) {
	
		if(utilisateurservice.existsByNom(requete.getNom())) {
			return ResponseEntity.badRequest().body(new MessageReponse("Erreur: Cet utilisateur existe deja"));
			
		}
		Utilisateur utilisateur = new Utilisateur(requete.getNom(),passwordencoder.encode(requete.getMdp()));
		String role = requete.getRole();
		
		switch(role) {
		case "Commercial":
				utilisateur.setRole(UserRole.Commercial);
				
				break;
		case "Magasinier":
				utilisateur.setRole(UserRole.Magasinier);
				break;
		case "Admin":
				utilisateur.setRole(UserRole.Admin);
				break;
		default:
			return  ResponseEntity.badRequest().body(new MessageReponse("Erreur: Le role que vous avez defini n'existe pas"));
			
		}
		
		utilisateurservice.inscrireUtilisateur(utilisateur);
		return ResponseEntity.ok(new MessageReponse("Utilisateur inscrit avec succès"));
		
		
	}
	
}
