package com.nttdata.curso.client.repository;

import com.nttdata.curso.client.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    //where sku="sku"

    public List<ProductEntity> findBySku(String sku);
}
