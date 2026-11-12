package oms.com.example.oms.variant;

import jakarta.validation.constraints.NotNull;
import oms.com.example.oms.variant.dto.VariantRequestDto;
import oms.com.example.oms.variant.dto.VariantResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/variant")
public class VariantController {

   // fetch services and use them
    private final VariantService variantService;

    public VariantController(VariantService variantService){
        this.variantService = variantService;
    }

    // get all variant
    @GetMapping
    public ResponseEntity<List<VariantResponseDto>> fetchVariant(
           @RequestParam(defaultValue = "0") int start,
           @RequestParam(defaultValue = "20") int size
    ){
        Pageable page = PageRequest.of(start, size);
        Page<VariantResponseDto> variants = variantService.fetchVariant(page);
        List<VariantResponseDto> response = variants.stream()
                .map(v -> new VariantResponseDto(
                        v.id(),
                        v.product_id(),
                        v.sku(),
                        v.size(),
                        v.color(),
                        v.price()
                ))
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // create variant
    @PostMapping
    public ResponseEntity<VariantResponseDto> addVariant(
            @RequestBody @NotNull VariantRequestDto request
            )
    {
            VariantResponseDto response = variantService.createVariant(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
