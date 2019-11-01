package WebshopCRUD.Service;

import WebshopCRUD.Model.Product;
import WebshopCRUD.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void addProduct(Product product)
    {
        //Call method from repo
        productRepository.addProduct(product);
    }
    public void deleteProduct(int id)
    {
        productRepository.deleteProduct(id);
    }
    public void updateProduct(Product product)
    {
        productRepository.updateProduct(product);
    }
    public Product findProductById(int id)
    {
        return productRepository.findProductById(id);
    }

}
