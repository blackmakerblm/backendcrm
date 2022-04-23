package org.nima.pack.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commande {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private int paye;
	private Date datedeLivraison;
	@ManyToOne
	Utilisateur commercials;
	@OneToMany(fetch = FetchType.LAZY,orphanRemoval =true,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "commande_id")
	List<BonDeSortie> bondesorties;
	@OneToMany(fetch = FetchType.EAGER,orphanRemoval =true,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "commande_id")
	List<Composant> composants;
	@ManyToOne
	Client client;


	public double calculerPrixGlobal() {
	return 0 ;
	}

}