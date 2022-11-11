package in.upcode.eshop.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    private int id;
    private String name;
    private int quantity;
}
