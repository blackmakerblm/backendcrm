package org.nima.pack.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class Composant {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private long quantite;
	private double prix;
	@OneToOne()
	Pack pack;
	@JsonIgnore
	@ManyToOne()
	Commande commande;
	
}