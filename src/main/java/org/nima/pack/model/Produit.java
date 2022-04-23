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
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	@JsonBackReference(value = "magasin")
	@ManyToOne(cascade = CascadeType.PERSIST)
	Magasin magasin;
	@JsonBackReference(value = "categorie")
	@ManyToOne
	Categorie categorie;
	@OneToMany(mappedBy = "produits",fetch = FetchType.EAGER,orphanRemoval =true,cascade = CascadeType.ALL)
	List<necessite> necessite;


}