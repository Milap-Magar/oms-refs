package oms.com.example.oms.variant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import oms.com.example.oms.product.Product;

import java.math.BigDecimal;

@Setter @Getter
@Entity
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    @Column(name = "sku", nullable = false, unique = true)
    private String sku;

    @Column(name="size")
    private String size;

    @Column(name="color")
    private String color;

    @Column(name="price", nullable = false)
    private BigDecimal price;
}