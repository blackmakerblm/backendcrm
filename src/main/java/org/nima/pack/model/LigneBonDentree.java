package org.nima.pack.model;
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
public class LigneBonDentree {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double quantite;
	private double prix;
	@ManyToOne
	MP matiere_premiere;
	@ManyToOne
	BONDENTREE bondentree;



}