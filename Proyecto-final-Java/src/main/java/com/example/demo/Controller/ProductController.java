package com.example.demo.Controller;


import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Get all products", description = "Get all products", tags = { "Product" })
    @GetMapping("/all")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Products not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> products = productService.getProduct();
        return ResponseEntity.ok(products);
    }


    @Operation(summary = "Get a product by id", description = "Get a product by id", tags = { "Product" })
    @GetMapping(value = "/product/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws  Exception{
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Save a product", description = "Save a product", tags = { "Product" })
    @PostMapping("/product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Product not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Product> postProduct(@RequestBody Product product){
        productService.createdProduct(product);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) throws Exception{
        productService.deleteById(id);
    }

}
