package Daos;

import Models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
    static Connection connection=ConnectMysql.getConnection();
    public static ArrayList<Product> SelectFullProduct() throws SQLException {
        ArrayList<Product> ListProduct=new ArrayList<>();

        String query="SELECT * FROM thimodule3.product;";
        PreparedStatement ps=connection.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            Product Product=new Product();
            Product.setId(rs.getInt("idproduct"));
            Product.setName(rs.getString("name"));
            Product.setPrice(rs.getInt("price"));
            Product.setQuantity(rs.getInt("soluong"));
            Product.setColor(rs.getString("color"));
            Product.setAbout(rs.getString("about"));
            Product.setCategory(rs.getString("Danhmuc"));
            ListProduct.add(Product);
        }
        return ListProduct;
    }
    public static void EditProduct(String id,Product product) throws SQLException {
        String query="UPDATE `thimodule3`.`product` SET `name` =?, `price` =?, `soluong` =?, `color` =?, `about` =?, `Danhmuc` =? WHERE (`idProduct` = ?);";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setString(1,product.getName());
        ps.setInt(2,product.getPrice());
        ps.setInt(3,product.getQuantity());
        ps.setString(4,product.getColor());
        ps.setString(5,product.getAbout());
        ps.setString(6,product.getCategory());
        ps.setInt(7, Integer.parseInt(id));
        ps.executeUpdate();
    }
    public static void removeProduct(String id) throws SQLException {
        String query="DELETE FROM `thimodule3`.`product` WHERE (`idProduct` = ?);";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setInt(1, Integer.parseInt(id));
        ps.executeUpdate();
    }
    public static void createProduct(Product product) throws SQLException {
        String query="INSERT INTO `thimodule3`.`product` (`name`, `price`, `soluong`, `color`, `about`, `Danhmuc`) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setString(1,product.getName());
        ps.setInt(2,product.getPrice());
        ps.setInt(3,product.getQuantity());
        ps.setString(4,product.getColor());
        ps.setString(5,product.getAbout());
        ps.setString(6,product.getCategory());
        ps.executeUpdate();
    }
    public static ArrayList<Product> find(String name) throws SQLException {
        String query="SELECT * FROM thimodule3.product where `name` like '%"+name+"%';";
        ArrayList<Product> List=new ArrayList<>();
        PreparedStatement ps=connection.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            Product Product=new Product();
            Product.setId(rs.getInt("idProduct"));
            Product.setName(rs.getString("name"));
            Product.setPrice(rs.getInt("price"));
            Product.setQuantity(rs.getInt("soluong"));
            Product.setColor(rs.getString("color"));
            Product.setAbout(rs.getString("about"));
            Product.setCategory(rs.getString("Danhmuc"));
            List.add(Product);
        }
        return List;
    }
}
