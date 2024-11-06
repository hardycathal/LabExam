package ie.atu.labexam;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService myProduct;

    public ProductController(ProductService myProduct){
        this.myProduct = myProduct;
    }

    @PostMapping ("/products")
    public List<Product> addProducts(@Valid @RequestBody Product product){
        return myProduct.addProduct(product);
    }

    @GetMapping("/products/{productCode}")
    public List<Product> getProducts(@PathVariable int productCode){
        return myProduct.getProducts(productCode);
    }
}
