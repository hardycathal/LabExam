package ie.atu.labexam;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> myList = new ArrayList<>();

    public List<Product> addProduct(Product product){
        myList.add(product);
        return myList;
    }

    public List<Product> getProducts(int productCode){
        return myList;
    }
}
