package org.nima.pack.repository;

import org.nima.pack.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepo  extends JpaRepository<Commande, Long> {

}
