package org.nima.pack.security;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.google.common.collect.Sets;





public enum UserRole {

 Commercial(
		 Sets.newHashSet(
		 UserPermission.CLIENT_CREATE,
		 UserPermission.CLIENT_READ,
		 UserPermission.PRODUIT_READ,
		 UserPermission.COMMANDE_CREATE,
		 UserPermission.COMMANDE_READ,
		 UserPermission.COMPOSANT_CREATE,
		 UserPermission.COMPOSANT_READ,
		 UserPermission.CATEGORIE_READ,
		 UserPermission.BONDESORTIE_UPDATE
				 )
		 ),
 
 Magasinier(
		 Sets.newHashSet(
				 UserPermission.PRODUIT_READ,
				 UserPermission.PRODUIT_UPDATE,
				 UserPermission.BONDESORTIE_CREATE,
				 UserPermission.MP_UPDATE,
				 UserPermission.CATEGORIE_READ,
				 UserPermission.COMMANDE_READ,
				 UserPermission.COMPOSANT_READ

				 )
		 ),
 
 Admin(
		 Sets.newHashSet(
				 UserPermission.UTILISATEUR_CREATE,
				 UserPermission.UTILISATEUR_READ,
				 UserPermission.UTILISATEUR_DISABLE,
				 UserPermission.UTILISATEUR_ADD_ROLE,
				 UserPermission.UTILISATEUR_ADD_AUTHORITY,
				 UserPermission.UTILISATEUR_DELETE,
				 UserPermission.PRODUIT_CREATE,
				 UserPermission.PRODUIT_DELETE,
				 UserPermission.MAGASIN_CREATE,
				 UserPermission.MAGASIN_DELETE,
				 UserPermission.MP_CREATE,
				 UserPermission.MP_DELETE,
				 UserPermission.CATEGORIE_CREATE,
				 UserPermission.CATEGORIE_DELETE
				 
				 )
		 );
	
	
	private final Set<UserPermission> permissions;

	private UserRole(Set<UserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<UserPermission> getPermissions() {
		return permissions;
	}
	
	public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
		Set<SimpleGrantedAuthority> authorities= getPermissions().stream()
				.map(permission-> new SimpleGrantedAuthority(permission.name()))
				.collect(Collectors.toSet());
		authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
		return authorities;
	}
	
}
