package org.nima.payload;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ConnectionDataModel {

	@NotBlank
	private String nom;
	@NotBlank
	private String mdp;
	
}
