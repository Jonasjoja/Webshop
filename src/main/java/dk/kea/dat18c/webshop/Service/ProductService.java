package dk.kea.dat18c.webshop.Service;

import dk.kea.dat18c.webshop.Model.Product;
import dk.kea.dat18c.webshop.Repository.ProductRepository;
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
}
