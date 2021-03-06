package com.mercadolibre.projetointegrador.repository;

import com.mercadolibre.projetointegrador.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {

    Optional<Supervisor> findSupervisorByUsername(String username);

}
