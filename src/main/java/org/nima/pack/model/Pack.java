package org.nima.pack.model;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pack {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	private int contenu;
	private long quantité_en_stock;
	@JsonIgnore
	@OneToMany()
	@JoinColumn(name = "pack_id")
	List<Composant> composant;
	@OneToOne()
	Produit produit;

	public void incrementer(long qte) {

	}

	
	public void decrementer(long qte) {

	}

}