package dev.pedrolobo.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.pedrolobo.productservice.dto.ProductRequest;
import dev.pedrolobo.productservice.dto.ProductResponse;
import dev.pedrolobo.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/product-service")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createProduct(@RequestBody ProductRequest productRequest) {
    productService.createProduct(productRequest);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ProductResponse> getAllProducts() {
    return productService.getAllProducts();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void update(@RequestBody @Valid ProductRequest customerRequest, @PathVariable(value = "id") Long id) {
    if (!productService.existsById(id)) {
      throw new ProductNotFoundException(id);
    }
    productService.update(customerRequest, id);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ProductResponse get(@PathVariable(value = "id") Long id) {
    if (!productService.existsById(id)) {
      throw new ProductNotFoundException(id);
    }
    return productService.getById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable(value = "id") Long id) {
    if (!productService.existsById(id)) {
      throw new ProductNotFoundException(id);
    }
    productService.deleteById(id);
  }

}
