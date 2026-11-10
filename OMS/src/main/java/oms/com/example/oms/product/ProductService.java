package oms.com.example.oms.product;

import oms.com.example.oms.common.exception.product.ProductNameAlreadyExists;
import oms.com.example.oms.product.dto.ProductRequestDto;
import oms.com.example.oms.product.dto.ProductResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    // fetch all products

    // create product services
    public ProductResponseDto createProduct(ProductRequestDto request){
        // object references
        Product product = new Product();

        // set new datasets and create each instance
        product.setName(request.name());
        product.setDescription(request.description());
        product.setCategory(request.category());
        product.setVariants(product.getVariants());

        Product saved = productRepository.save(product);
        return new ProductResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getDescription()
        );
    }
}
