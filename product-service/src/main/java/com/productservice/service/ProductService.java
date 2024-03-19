package com.productservice.service;

import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductResponse;
import com.productservice.model.Product;
import com.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is created.", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        log.info("Product List successfully fetched");
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    public ProductResponse findProductByName(String name) {
        Optional<Product> product = productRepository.findByName(name);
        if (product.isEmpty()) {
            throw new RuntimeException("Product with name " + name + " not found");
        }
        return mapToProductResponse(product.get());
    }

    public void updateProduct(String name, ProductRequest productRequest) {
        Optional<Product> product = productRepository.findByName(name);
        if (product.isEmpty()) {
            throw new RuntimeException("Product with name " + name + " not found");
        }

        Product existingProduct = product.get();
        existingProduct.setName(productRequest.getName());
        existingProduct.setPrice(productRequest.getPrice());
        existingProduct.setQuantity(productRequest.getQuantity());
        existingProduct.setImageUrl(productRequest.getImageUrl());

        productRepository.save(existingProduct);
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .quantity(product.getQuantity())
                .ratings(product.getRatings())
                .build();
    }
}
