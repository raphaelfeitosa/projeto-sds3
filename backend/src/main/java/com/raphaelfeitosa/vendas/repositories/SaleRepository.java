package com.raphaelfeitosa.vendas.repositories;

import com.raphaelfeitosa.vendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
