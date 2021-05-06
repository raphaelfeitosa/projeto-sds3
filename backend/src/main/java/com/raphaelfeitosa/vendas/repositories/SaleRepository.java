package com.raphaelfeitosa.vendas.repositories;

import com.raphaelfeitosa.vendas.dto.SaleSuccessDTO;
import com.raphaelfeitosa.vendas.dto.SaleSumDTO;
import com.raphaelfeitosa.vendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.raphaelfeitosa.vendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))" +
            " FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.raphaelfeitosa.vendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))" +
            " FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupedBySeller();
}

