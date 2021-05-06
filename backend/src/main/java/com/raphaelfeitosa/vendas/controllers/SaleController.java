package com.raphaelfeitosa.vendas.controllers;

import com.raphaelfeitosa.vendas.dto.SaleDTO;
import com.raphaelfeitosa.vendas.dto.SaleSuccessDTO;
import com.raphaelfeitosa.vendas.dto.SaleSumDTO;
import com.raphaelfeitosa.vendas.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupBySeller() {
        List<SaleSumDTO> list = service.amountGroupBySeller();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> successGroupBySeller() {
        List<SaleSuccessDTO> list = service.successGroupBySeller();
        return ResponseEntity.ok(list);
    }

}
