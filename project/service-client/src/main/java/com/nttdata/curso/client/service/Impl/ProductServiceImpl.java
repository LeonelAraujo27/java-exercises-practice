package com.nttdata.curso.client.service.Impl;

import com.nttdata.curso.client.entity.ProductEntity;
import com.nttdata.curso.client.repository.ProductRepository;
import com.nttdata.curso.client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<ProductEntity> listProducts( ) {
        return repository.findAll();
    }

    @Override
    public ProductEntity getOne(Long id) {
        if(id==null){
            return null;
        }else{
            return repository.findById(id).get();
        }

    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return repository.save(productEntity);
    }

    @Override
    public ProductEntity update(Long id,ProductEntity productEntity) {
        ProductEntity product=getOne(id);
        if(product==null){
            return new ProductEntity();
        }else {
            product.setName(productEntity.getName());
            product.setSku(productEntity.getSku());
            product.setQuantity(productEntity.getQuantity());
            product.setPrice(productEntity.getPrice());

            return save(product);
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public List<ProductEntity> ListProductBySku(String sku) {
        return repository.findBySku(sku);
    }
}
