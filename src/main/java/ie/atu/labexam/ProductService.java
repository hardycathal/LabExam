package ie.atu.labexam;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

    public List<Product> updateProduct(Product product, int productCode){
        for (Product p : myList){
            if(p.getProductCode() == productCode){
                p.setProductName(product.getProductName());
                p.setPrice(product.getPrice());
                p.setCategory(product.getCategory());
                p.setQuantityInStock(product.getQuantityInStock());
                return myList;
            }
        }throw new NoSuchElementException("Product with product code: " + productCode + " not found.");
    }

    public List<Product> deleteProduct(int productCode){
        for (Product p : myList){
            if(p.getProductCode() == productCode){
                myList.remove(p);
                return myList;
            }
        }throw new NoSuchElementException("Product with product code: " + productCode + " not found.");
    }
}
