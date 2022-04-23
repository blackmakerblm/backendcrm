package org.nima.pack.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class necessite {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double quantité;
	@ManyToOne
	Produit produits;
	@ManyToOne
	MP matieres_premieres;


}