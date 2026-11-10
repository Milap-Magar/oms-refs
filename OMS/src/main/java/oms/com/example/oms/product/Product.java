package oms.com.example.oms.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import oms.com.example.oms.variant.Variant;
import oms.com.example.oms.category.Category;

import java.util.List;

@Setter @Getter
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description", columnDefinition ="TEXT", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", nullable = false)
    private Category Category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Variant> variants;
}
