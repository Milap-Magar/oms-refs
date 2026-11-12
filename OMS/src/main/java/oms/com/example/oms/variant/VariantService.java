package oms.com.example.oms.variant;

import oms.com.example.oms.common.exception.product.ProductNotFound;
import oms.com.example.oms.common.exception.variant.VariantNotFound;
import oms.com.example.oms.product.Product;
import oms.com.example.oms.product.ProductRepository;
import oms.com.example.oms.variant.dto.VariantRequestDto;
import oms.com.example.oms.variant.dto.VariantResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VariantService {

    private final VariantRepository variantRepository;
    private final ProductRepository productRepository;

    public VariantService(
            VariantRepository variantRepository,
            ProductRepository productRepository
            ) {
        this.variantRepository = variantRepository;
        this.productRepository = productRepository;
    }

    // get all variant
    public Page<VariantResponseDto> fetchVariant(Pageable pageable){
         Page<Variant> variants = variantRepository.findAll(pageable);
         // handling the return type
         return variants.map(v -> new VariantResponseDto(
                 v.getId(),
                 v.getProduct().getId(),
                 v.getSku(),
                 v.getSize(),
                 v.getColor(),
                 v.getPrice()
                 ));
    }

    // get variant by id
    public VariantResponseDto fetchVariantById(long id){

        Variant variant = variantRepository.findById(id)
                .orElseThrow(() -> new VariantNotFound("Variant Not found"));

        // appropriate return type
        return new VariantResponseDto(
                variant.getId(),
                variant.getProduct().getId(),
                variant.getSku(),
                variant.getSize(),
                variant.getColor(),
                variant.getPrice()
        );
    }

    // create variant
    public VariantResponseDto createVariant(VariantRequestDto request){

        // find the product_id
        Product product = productRepository.findById(request.product_id())
                .orElseThrow(() -> new ProductNotFound("Product not found"));

        // creating new instance for the variant
        Variant variant = new Variant();

        variant.setProduct(product);
        variant.setSku(request.sku());
        variant.setSize(request.size());
        variant.setColor(request.color());
        variant.setPrice(request.price());

        // save the datasets
        Variant saved = variantRepository.save(variant);

        // return response and modulate it
        return new VariantResponseDto(
                saved.getId(),
                saved.getProduct().getId(),
                saved.getSku(),
                saved.getSize(),
                saved.getColor(),
                saved.getPrice()
        );
    }

    // update variant
    // update via sku
    // update via color
    // update via product_id
    // update via price
}
