package SegEntrega.SegundaEntrega.Controller;



import SegEntrega.SegundaEntrega.Entity.Product;
import SegEntrega.SegundaEntrega.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductService productService;

    public ResponseEntity<List<Product>> getProduct(){
        List<Product> products = productService.getProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product>getProductById(@PathVariable Integer id) throws Exception{
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/product")
    public ResponseEntity<Product>postProduct(@RequestBody Product product){
        productService.createdProduct(product);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id) throws Exception{
        productService.deleteProductById(id);
    }

}
