package com.H2PizzaProject.PizzaShop.services;

import com.H2PizzaProject.PizzaShop.model.Product;
import com.H2PizzaProject.PizzaShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct(){
        return (List<Product>) productRepository.findAll();
    }
    public Product getProductByid(int id){
        return productRepository.findById(id).orElse(null);

    }

}
