package com.raphaelfeitosa.vendas.repositories;

import com.raphaelfeitosa.vendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
