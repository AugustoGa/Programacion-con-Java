package SegEntrega.SegundaEntrega.Service;

import SegEntrega.SegundaEntrega.Entity.Product;
import SegEntrega.SegundaEntrega.Repository.ProductRepository;
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

    public List<Product>getProduct(){
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) throws Exception{
        Optional<Product> product = productRepository.findById(id);
            if (product.isPresent()){
                return product.get();
            }else {
                throw new Exception("Product not exist");
            }
    }

    public void deleteProductById(Integer id) throws Exception{
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
