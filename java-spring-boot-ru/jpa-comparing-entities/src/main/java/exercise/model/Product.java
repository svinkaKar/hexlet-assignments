package exercise.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@AllArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(of = {"title", "price"})
public class Product {

    private Long id;
    private String title;
    private Integer price;
}
// END
