package org.nima.pack.model;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String prenom;
	private String adresse;
	private int telephone;
	private String email;
	private String nom;
	@JsonBackReference(value = "commande")
	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY,orphanRemoval =true,cascade = CascadeType.PERSIST)
	List<Commande> commandes;
	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY,orphanRemoval =true,cascade = CascadeType.PERSIST)
	List<Facture> factures;


}