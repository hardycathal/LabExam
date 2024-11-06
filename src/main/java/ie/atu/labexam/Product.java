package ie.atu.labexam;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Positive(message = "Must be positive")
    private int productCode;
    @NotBlank(message="Must enter product name")
    private String productName;
    @NotBlank(message="Must enter a category")
    private String category;
    @PositiveOrZero(message = "Cannot be negative")
    private int quantityInStock;
    @Positive(message = "Must be positive")
    private double price;
}
