package org.nima.pack.model;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Magasin {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToOne
	Utilisateur magasinier;
	@OneToMany(mappedBy = "magasin",fetch = FetchType.LAZY,orphanRemoval =true,cascade = CascadeType.ALL)
	List<MP> matieres_premieres;
	@JsonManagedReference(value = "magasin")
	@OneToMany(mappedBy = "magasin",fetch = FetchType.EAGER,orphanRemoval =true,cascade = CascadeType.ALL)
	List<Produit> produits;

}