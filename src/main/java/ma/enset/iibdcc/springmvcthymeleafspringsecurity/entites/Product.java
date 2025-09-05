package ma.enset.iibdcc.springmvcthymeleafspringsecurity.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty//destiné aux chaînes (String, Collection, Map, etc.).
    @Size(min = 2, max = 50)
    private String name;

    @Min(10)
    private int price;

    @Min(0)
    private double quantity;

    public Product(String name, int i,double quantity) {
        this.name = name;
        this.price = i;
        this.quantity = quantity;
    }
}
