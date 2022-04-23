package org.nima.payload;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class InscriptionDataModel {

	@NotBlank
	@Size(min = 3,max = 20)
	private String  nom;
	@NotBlank
	@Size(min = 6,max = 20)
	private String mdp;
	@NotBlank
	private String role;
	
}
