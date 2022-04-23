package org.nima.pack.repository;

import org.nima.pack.model.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagasinRepo  extends JpaRepository<Magasin, Long> {
boolean existsByNom(String nom);
Magasin findByNom(String nom);
}
