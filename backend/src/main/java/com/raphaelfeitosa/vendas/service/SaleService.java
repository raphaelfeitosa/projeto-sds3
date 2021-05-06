package com.raphaelfeitosa.vendas.service;

import com.raphaelfeitosa.vendas.dto.SaleDTO;
import com.raphaelfeitosa.vendas.dto.SaleSuccessDTO;
import com.raphaelfeitosa.vendas.dto.SaleSumDTO;
import com.raphaelfeitosa.vendas.entities.Sale;
import com.raphaelfeitosa.vendas.repositories.SaleRepository;
import com.raphaelfeitosa.vendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> result = repository.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupBySeller() {
        return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupBySeller() {
        return repository.successGroupedBySeller();
    }
}
