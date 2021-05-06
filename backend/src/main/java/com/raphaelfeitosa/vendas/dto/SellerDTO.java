package com.raphaelfeitosa.vendas.dto;

import com.raphaelfeitosa.vendas.entities.Seller;

import java.io.Serializable;

public class SellerDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;

    public SellerDTO(){
    }

    public SellerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SellerDTO(Seller entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
