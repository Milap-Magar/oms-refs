package oms.com.example.oms.product;

import oms.com.example.oms.common.exception.product.ProductNameAlreadyExists;
import oms.com.example.oms.product.dto.ProductRequestDto;
import oms.com.example.oms.product.dto.ProductResponseDto;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    // create product services
//    public ProductResponseDto createProduct(ProductRequestDto request){
//        if(!productRepository.existProductName(request.name())){
//            throw new ProductNameAlreadyExists("Product name already exists");
//        }
//
//
////        return new ProductResponseDto();
//    }
}
