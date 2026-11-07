package oms.com.example.oms.category;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="category")
public class Category {

    @Id
    @Setter @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Setter @Getter
    @Column(name="name", nullable = false)
    private String name;

    @Setter @Getter
    @Column(name="description", nullable = false)
    private String description;

}
