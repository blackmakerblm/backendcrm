package org.nima.pack.model;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BONDENTREE {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private String code;
	@ManyToOne
	Utilisateur magasinier;
	@ManyToMany()
	List<Fournisseur> fournisseur;
	@OneToOne
	FactureFournisseur factureFournisseur;
	@OneToMany(mappedBy = "bondentree",fetch = FetchType.EAGER,orphanRemoval =true,cascade = CascadeType.PERSIST)
	List<LigneBonDentree> lignesbondentree;

	public double calculerPrixTotal() {
		// TODO - implement BONDENTREE.calculerPrixTotal
		throw new UnsupportedOperationException();
	}

}