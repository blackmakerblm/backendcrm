package org.nima.pack.repository;

import org.nima.pack.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepo  extends JpaRepository<Facture, Long> {

}
