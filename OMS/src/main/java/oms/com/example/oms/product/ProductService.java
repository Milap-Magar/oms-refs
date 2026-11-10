package oms.com.example.oms.product;

import jakarta.transaction.Transactional;
import oms.com.example.oms.category.dto.CategoryResponseDto;
import oms.com.example.oms.common.exception.product.ProductIdNotFound;
import oms.com.example.oms.common.exception.product.ProductNotFound;
import oms.com.example.oms.product.dto.ProductRequestDto;
import oms.com.example.oms.product.dto.ProductResponseDto;
import oms.com.example.oms.product.dto.ProductUpdateRequestDto;
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

    // fetch by id
    public ProductResponseDto getProductById(long id){
        if(!productRepository.existsById(id)){
            throw new ProductIdNotFound("Product not found");
        }

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("Product not found" + id));
        // success case
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                new CategoryResponseDto(
                        product.getCategory().getId(),
                        product.getCategory().getName(),
                        product.getCategory().getDescription()
                ),
                product.getVariants().stream()
                        .map(v -> new VariantResponseDto(
                                v.getId(),
                                v.getSku(),
                                v.getColor(),
                                v.getSize(),
                                v.getPrice()
                        ))
                        .toList()
                );
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

    // update price only for now
    // basically transactional is used for finding one variant in the list instead:
    @Transactional
    public ProductResponseDto updateProduct(
            long productId,
            long variantId,
            ProductUpdateRequestDto request
    ){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFound("Product not found" + productId));

        // fetch variants
        Variant variant = product.getVariants().stream()
                .filter(v -> v.getId() == variantId)
                .findFirst()
                .orElseThrow(() -> new ProductNotFound("Variant not found" + variantId));
        variant.setPrice(request.price());
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                new CategoryResponseDto(
                       product.getCategory().getId(),
                       product.getCategory().getName(),
                       product.getCategory().getDescription()
                ),
                product.getVariants().stream()
                        .map(v -> new VariantResponseDto(
                                v.getId(),
                                v.getSku(),
                                v.getSize(),
                                v.getColor(),
                                v.getPrice()
                        ))
                        .toList()
        );
    }
}
