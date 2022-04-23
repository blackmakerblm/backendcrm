/*package org.nima.pack.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commercial extends Utilisateur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "commercial",fetch = FetchType.EAGER,orphanRemoval =true,cascade = CascadeType.PERSIST)
	List<Commande> commandes;

	

	public Facture genererFacture() {
		// TODO - implement Commercial.genererFacture
		throw new UnsupportedOperationException();
	}

	
	public Facture chercherFacture(String code) {
		// TODO - implement Commercial.chercherFacture
		throw new UnsupportedOperationException();
	}

	
	public void imprimerFacture(Facture facture) {
		// TODO - implement Commercial.imprimerFacture
		throw new UnsupportedOperationException();
	}

	
	public Client ajouterClient(String nom, String adresse, String prenom, String tel, String email) {
		// TODO - implement Commercial.ajouterClient
		throw new UnsupportedOperationException();
	}

	public Client chercherClient() {
		// TODO - implement Commercial.chercherClient
		throw new UnsupportedOperationException();
	}

	public Client[] voirListeClients() {
		// TODO - implement Commercial.voirListeClients
		throw new UnsupportedOperationException();
	}

	
	public void modifierClient(Client c) {
		// TODO - implement Commercial.modifierClient
		throw new UnsupportedOperationException();
	}

	
	public Commande ajouterCommande(Date date, boolean payé, Date dateLivraison) {
		// TODO - implement Commercial.ajouterCommande
		throw new UnsupportedOperationException();
	}

	public Commande voirListeCommande() {
		// TODO - implement Commercial.voirListeCommande
		throw new UnsupportedOperationException();
	}

	public void consulterStocksProduits() {
		// TODO - implement Commercial.consulterStocksProduits
		throw new UnsupportedOperationException();
	}

	
	public double consulterStockDunProduit(String libelle) {
		// TODO - implement Commercial.consulterStockDunProduit
		throw new UnsupportedOperationException();
	}

	
	public void envoyerDemandeBonDeSortie(Commande c) {
		// TODO - implement Commercial.envoyerDemandeBonDeSortie
		throw new UnsupportedOperationException();
	}

}*/