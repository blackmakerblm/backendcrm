package org.nima.pack.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.nima.pack.security.UserRole;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String mdp;
	private UserRole role;
	@JsonIgnore
	@OneToMany(mappedBy = "commercials",fetch = FetchType.LAZY,orphanRemoval =true,cascade = CascadeType.PERSIST)
	List<Commande> commandes;
	@OneToMany(fetch = FetchType.LAZY,orphanRemoval =true,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "magasinier_id")
	@JsonBackReference
	List<BonDeSortie> bondesorties;
	@OneToMany(mappedBy = "magasinier",fetch = FetchType.LAZY,orphanRemoval =true,cascade = CascadeType.PERSIST)
	List<BONDENTREE> bondentrees;
	public Utilisateur(String nom, String mdp) {
		super();
		this.nom = nom;
		this.mdp = mdp;
	}
	
}
