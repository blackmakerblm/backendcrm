package org.nima.pack.security;

public enum UserPermission {

	UTILISATEUR_CREATE("utilisateur:create"),
	UTILISATEUR_READ("utilisateur:read"),
	UTILISATEUR_DISABLE("utilisateur:disable"),
	UTILISATEUR_DELETE("utilisateur:delete"),
	UTILISATEUR_ADD_ROLE("utilisateur:role"),
	UTILISATEUR_ADD_AUTHORITY("utilisateur:autority"),
	PRODUIT_CREATE("produit:create"),
	PRODUIT_READ("produit:read"),
	PRODUIT_DELETE("produit:delete"),
	PRODUIT_UPDATE("produit:update"),
	MP_CREATE("mp:create"),
	MP_READ("mp:read"),
	MP_DELETE("mp:delete"),
	MP_UPDATE("mp:update"),
	CLIENT_CREATE("client:create"),
	CLIENT_READ("client:read"),
	CLIENT_UPDATE("client:update"),
	CLIENT_DELETE("client:delete"),
	COMMANDE_CREATE("commande:create"),
	COMMANDE_READ("commande:read"),
	COMMANDE_UPDATE("commande:update"),
	COMMANDE_DELETE("commande:delete"),
	BONDESORTIE_CREATE("bondesortie:create"),
	BONDESORTIE_READ("bondesortie:read"),
	BONDESORTIE_UPDATE("bondesortie:update"),
	BONDESORTIE_DELETE("bondesortie:delete"),
	CATEGORIE_CREATE("categorie:create"),
	CATEGORIE_READ("categorie:read"),
	CATEGORIE_UPDATE("categorie:update"),
	CATEGORIE_DELETE("categorie:delete"),
	MAGASIN_CREATE("magasin:create"),
	MAGASIN_READ("magasin:read"),
	MAGASIN_UPDATE("magasin:update"),
	MAGASIN_DELETE("magasin:delete"),
	COMPOSANT_CREATE("composant:create"),
	COMPOSANT_READ("composant:read"),
	COMPOSANT_UPDATE("composant:update"),
	COMPOSANT_DELETE("composant:delete");

	 
	private final String permission;
	private UserPermission(String permission) {
		this.permission=permission;
		
	}
	public String getPermission() {
		return permission;
	}
	
	
}
