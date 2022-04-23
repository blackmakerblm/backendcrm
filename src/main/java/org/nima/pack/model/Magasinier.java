package org.nima.pack.model;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Magasinier extends Utilisateur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "magasinier",fetch = FetchType.LAZY,orphanRemoval =true,cascade = CascadeType.PERSIST)
	List<BonDeSortie> bondesorties;
	@OneToMany(mappedBy = "magasinier",fetch = FetchType.LAZY,orphanRemoval =true,cascade = CascadeType.PERSIST)
	List<BONDENTREE> bondentrees;

	/*
	public int augmenterMP_En_Stock(MP mp, double qte) {
		// TODO - implement Magasinier.augmenterMP_En_Stock
		throw new UnsupportedOperationException();
	}

	public int reduireMP_En_Stock(MP mp, double qte) {
		// TODO - implement Magasinier.reduireMP_En_Stock
		throw new UnsupportedOperationException();
	}


	public MP searchMPByLibelle(String libelle) {
		// TODO - implement Magasinier.searchMPByLibelle
		throw new UnsupportedOperationException();
	}

	public Fournisseur addFournisseur(String nom, String adr, String numTel) {
		// TODO - implement Magasinier.addFournisseur
		throw new UnsupportedOperationException();
	}

	public int editFournisseur(Fournisseur f) {
		// TODO - implement Magasinier.editFournisseur
		throw new UnsupportedOperationException();
	}

	
	public int removeFournisseur(Fournisseur f) {
		// TODO - implement Magasinier.removeFournisseur
		throw new UnsupportedOperationException();
	}

	public Fournisseur searchFournisseur() {
		// TODO - implement Magasinier.searchFournisseur
		throw new UnsupportedOperationException();
	}

	
	public BonDeSortie addBonDeSortie(Date date, boolean signe, String code) {
		// TODO - implement Magasinier.addBonDeSortie
		throw new UnsupportedOperationException();
	}

	public List<BonDeSortie> lireDemandeDeBonDeSortie() {
		// TODO - implement Magasinier.lireDemandeDeBonDeSortie
		throw new UnsupportedOperationException();
	}

	
	public void imprimerBonDeSortie(BonDeSortie b) {
		// TODO - implement Magasinier.imprimerBonDeSortie
		throw new UnsupportedOperationException();
	}


	public BONDENTREE addBonEntree(Date date, String code) {
		// TODO - implement Magasinier.addBonEntree
		throw new UnsupportedOperationException();
	}

	
	public int EditBonEntree(BONDENTREE b) {
		// TODO - implement Magasinier.EditBonEntree
		throw new UnsupportedOperationException();
	}

	public BONDENTREE searchBonEntree() {
		// TODO - implement Magasinier.searchBonEntree
		throw new UnsupportedOperationException();
	}*/

}