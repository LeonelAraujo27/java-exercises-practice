package com.nttdata.curso.client.controller;

import com.nttdata.curso.client.entity.ProductEntity;
import com.nttdata.curso.client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/list")
    public ResponseEntity<List<ProductEntity>> getListProducts(){
        List<ProductEntity> listProducts=service.listProducts();

        if(listProducts.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(listProducts);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<ProductEntity> saveProduct(@RequestBody ProductEntity productEntity){
        try {
            ProductEntity product=service.save(productEntity);
            if (product.getId()==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new ProductEntity());
            }else{
                return ResponseEntity.ok(product);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProductEntity());

        }
    }

    @GetMapping("/get/{id}")
    public  ResponseEntity<ProductEntity> getProduct(@PathVariable Long id){
        ProductEntity productEntity=service.getOne(id);

        if(productEntity.getId()==null){
            return  ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(productEntity);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id,@RequestBody ProductEntity productEntity){
        ProductEntity product=service.update(id,productEntity);
        if(product.getId()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ProductEntity());
        }else{
            return ResponseEntity.ok(product);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductEntity> deleteProduct(@PathVariable Long id){
        ProductEntity product=service.getOne(id);
        boolean isRemove=service.delete(id);
        if(!isRemove){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return ResponseEntity.ok(product);
        }
    }
}
