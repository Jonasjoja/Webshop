package WebshopCRUD.Repository;

import WebshopCRUD.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate template;


    public List<Product> getAllProducts(){

        String sql = "SELECT * FROM products";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.query(sql, rowMapper);

    }

    //Method to create a product, autowired JdbcTemplate above
    public void addProduct(Product product)
    {
        //SQL statement
        String sql = "INSERT INTO products (name ,price,description) VALUES (?,?,?)";
        //Execute
        template.update(sql, product.getName(),product.getPrice(),product.getDescription());
    }
    public void deleteProduct(int id)
    {
        String sql = "DELETE FROM products WHERE id=?";
        template.update(sql,id);
    }
    public void updateProduct(Product product)
    {
        String sql = "UPDATE products SET name=?, price=?, description=? WHERE id=?";
        template.update(sql,product.getName(),product.getPrice(),product.getDescription(),product.getId());
    }
    public Product findProductById(int id)
    {
        String sql ="SELECT * FROM products WHERE id=?";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.queryForObject(sql,rowMapper,id);
    }


}
