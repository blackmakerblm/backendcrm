package org.nima.pack.model;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.checkerframework.checker.units.qual.s;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	@ManyToOne
	Client client;
	@OneToOne(cascade = CascadeType.MERGE)
	Commande commande;
	double montant;
	
	public void calculerMontantGlobal(List<Composant>listeComposants) {

		List<Double> lesPrix=listeComposants.stream().map(comp->comp.getPrix()).collect(Collectors.toList());
		Double sum = lesPrix.stream()
				  .reduce((double) 0,Double::sum);
		this.montant= sum;
	
		
	}

}