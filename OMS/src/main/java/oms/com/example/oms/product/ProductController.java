package oms.com.example.oms.product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import oms.com.example.oms.product.dto.ProductRequestDto;
import oms.com.example.oms.product.dto.ProductResponseDto;
import oms.com.example.oms.product.dto.ProductUpdateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // Get product by id
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> productById(
            @PathVariable long id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
                productService.getProductById(id)
        );
    }
    // Get all products
    @GetMapping
    public ResponseEntity<Page<ProductResponseDto>> products(
            @RequestParam(defaultValue = "0") int start,
            @RequestParam(defaultValue = "20") int size
    ){
        Pageable pageable = PageRequest.of(start, size);
        return ResponseEntity.ok(productService.getProducts(pageable));
    }
    // Create products
    @PostMapping
    public ResponseEntity<String> addProduct(
            @Valid @RequestBody ProductRequestDto productRequestDto
    ){
        productService.createProduct(productRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product Created!");
    }

    // update products just pricing for now
    @PutMapping("/{productId}/variants/{variantId}/price")
    public ResponseEntity<ProductResponseDto> updatePrice(
            @PathVariable long productId,
            @PathVariable long variantId,
            @Valid @RequestBody ProductUpdateRequestDto request
            ){
        return ResponseEntity.ok(productService.updateProduct(productId, variantId, request));
    }

    // delete product using id
    @DeleteMapping("/{id}")
    public String deleteProduct(
            @PathVariable long id
    ){
        productService.deleteProduct(id);
        return "Product Deleted Successfully";
    }
}
