package net.java.backend.beauty_domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "routine_products")
public class RoutineProduct {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "routine_id", nullable = false, 
    foreignKey = @ForeignKey(name = "fk_routineproduct_routine", foreignKeyDefinition = "FOREIGN KEY (routine_id) REFERENCES routines(id) ON DELETE CASCADE"))
    private Routine routine;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false, 
    foreignKey = @ForeignKey(name = "fk_routineproduct_product", foreignKeyDefinition = "FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE"))
    private Product product;

    private Integer stepOrder; // Step 1, Step 2, etc.


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoutineProduct that = (RoutineProduct) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, routine, product, stepOrder);
    }
}
