package org.nima.pack.repository;

import org.nima.pack.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo  extends JpaRepository<Produit, Long> {

}
