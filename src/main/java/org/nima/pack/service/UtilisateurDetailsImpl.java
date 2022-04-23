package org.nima.pack.service;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

import org.nima.pack.model.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UtilisateurDetailsImpl  implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nom;
	private String mdp;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	public UtilisateurDetailsImpl(Long id, String nom, String mdp, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.nom = nom;
		this.mdp = mdp;
		this.authorities = authorities;
	}
	
	public static UtilisateurDetailsImpl build(Utilisateur u) {
		Set<? extends GrantedAuthority> authorities = u.getRole().getGrantedAuthorities();

		return new UtilisateurDetailsImpl(
				u.getId(), 
				u.getNom(), 
				u.getMdp(), 
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return mdp;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public String getMdp() {
		return mdp;
	}



	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UtilisateurDetailsImpl user = (UtilisateurDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

}
