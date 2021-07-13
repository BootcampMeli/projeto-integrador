package com.mercadolibre.projetointegrador.repository;

import com.mercadolibre.projetointegrador.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    Seller findSellerByName(String name);

    Optional<Seller> findByName(String name);
}
