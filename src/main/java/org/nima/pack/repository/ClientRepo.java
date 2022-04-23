package org.nima.pack.repository;

import org.nima.pack.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo  extends JpaRepository<Client, Long> {

}
