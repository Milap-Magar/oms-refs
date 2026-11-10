package oms.com.example.oms.product;

import oms.com.example.oms.category.dto.CategoryResponseDto;
import oms.com.example.oms.common.exception.product.ProductNameAlreadyExists;
import oms.com.example.oms.product.dto.ProductRequestDto;
import oms.com.example.oms.product.dto.ProductResponseDto;
import oms.com.example.oms.variant.Variant;
import oms.com.example.oms.variant.dto.VariantResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    // fetch all products
    public Page<ProductResponseDto> getProducts(Pageable pageable){
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(p -> new ProductResponseDto(
                p.getId(),
                p.getName(),
                p.getDescription(),
                // handling category response
                new CategoryResponseDto(
                        p.getCategory().getId(),
                        p.getCategory().getName(),
                        p.getCategory().getDescription()
                ),
                // handling variant response
                p.getVariants().stream()
                        .map(v -> new VariantResponseDto(
                                v.getId(),
                                v.getSku(),
                                v.getSize(),
                                v.getColor(),
                                v.getPrice()
                        ))
                        .toList()
        ));
    }

    // create product services
    public void createProduct(ProductRequestDto request){
        // object references
        Product product = new Product();

        // set new datasets and create each instance
        product.setName(request.name());
        product.setDescription(request.description());
        product.setCategory(request.category());
        product.setVariants(product.getVariants());

        productRepository.save(product);
    }
}
