package org.nima.pack.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureFournisseur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	@OneToOne
	BONDENTREE bondentree;


	public double calculerMontantGlobal() {
		return 0;
	}

}