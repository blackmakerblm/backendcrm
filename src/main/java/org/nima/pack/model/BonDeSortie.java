package org.nima.pack.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BonDeSortie {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private int signed;
	private String code;																																																																										
	@ManyToOne																																	
	Utilisateur magasinier;
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	Commande commande;

}