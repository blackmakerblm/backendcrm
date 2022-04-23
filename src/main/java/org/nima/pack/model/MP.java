package org.nima.pack.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MP {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libellé;
	private double quantité_en_stock;
	@ManyToOne
	Magasin magasin;
	@OneToMany(mappedBy = "matieres_premieres",fetch = FetchType.LAZY,orphanRemoval =true,cascade = CascadeType.PERSIST)
	List<necessite> necessite;
	@OneToMany(mappedBy = "matiere_premiere",fetch = FetchType.LAZY,orphanRemoval =true,cascade = CascadeType.PERSIST)
	List<LigneBonDentree> lignebonsdentree;


	public void incrementer(double qte) {
     
	}


	public void decrementer(double qte) {
		
	}

}