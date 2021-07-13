package com.mercadolibre.projetointegrador.repository;

import com.mercadolibre.projetointegrador.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    Buyer findByName(String name);

    Optional<Buyer> findBuyerByName(String name);
}
