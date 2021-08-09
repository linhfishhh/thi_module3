package Services;

import Daos.ProductDao;
import Models.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductService {
    public static ArrayList<Product> selectAllProduct() throws SQLException {
        return ProductDao.SelectFullProduct();
    }
    public static void updateProduct(String id,Product product) throws SQLException {
        ProductDao.EditProduct(id,product);
    }
    public static  void removeProduct(String id) throws SQLException {
        ProductDao.removeProduct(id);
    }
    public static void createProduct(Product product) throws SQLException {
        ProductDao.createProduct(product);
    }
    public static ArrayList<Product> FindProduct(String name) throws SQLException {
        return ProductDao.find(name);
    }
}
