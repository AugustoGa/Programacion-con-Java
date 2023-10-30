package com.example.demo.Service;


import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void createdProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> getProduct(){
        return productRepository.findAll();
    }


    public Product getProductById (Long id) throws Exception{
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            return product.get();
        }else {
            throw new Exception("Product not Exist");
        }
    }

    public void deleteById (Long id) throws Exception{
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    public double getProductPrice(Long productId) {
        var product = productRepository.findById(productId);

        if (product.isEmpty())
            throw new RuntimeException();

        return product.get().getTotal();
    }
    public Double updateStockWithSell(Long productId, Long stock) {
        var product = productRepository.findById(productId);
        if (product.isEmpty())
            throw new RuntimeException();

        product.get().setStock((int) (product.get().getStock() - stock));
        productRepository.save(product.get());

        return product.get().getTotal(); //

    }

}
