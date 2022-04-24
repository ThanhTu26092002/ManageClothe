package manegersellclothes.service;

import java.sql.SQLException;
import java.util.List;
import manegersellclothes.dao.ProductDao;
import manegersellclothes.entity.Product;

public class ProductService {

    private final ProductDao productDao;

    public ProductService() {
        productDao = new ProductDao();
    }

    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void deleteProduct(int id) throws SQLException {
        productDao.deleteProduct(id);
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }
     public Product getProductByID(int id){
        return productDao.getProductById(id);
    }
}
