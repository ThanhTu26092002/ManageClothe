
package manegersellclothes.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manegersellclothes.connect.ConnectDB;
import manegersellclothes.entity.Product;


public class ProductDao {
    public final Connection connection = ConnectDB.JDBC_CONECTION();
    public List<Product> getAllProduct(){
        List<Product> products = new ArrayList<Product>();
            String sql = "select * from productclothes";
            try{
                 PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet rs = preparedStatement.executeQuery();
                 while(rs.next()){
                   Product product = new Product();
                       product.setIdProduct(rs.getInt("idProduct"));
                       product.setProductName(rs.getString("productName"));
                       product.setCategory_id(rs.getInt("category_id"));
                       product.setColor(rs.getString("color"));
                       product.setSize(rs.getString("size"));
                       product.setAddress(rs.getString("address"));
                       product.setPrice(rs.getString("price"));
                 products.add(product);
                 }
            }
            catch(SQLException e){
                e.printStackTrace();
        }
            return products;
    }
    
    public void addProduct(Product product){
        String sql = "insert into productclothes(productName,category_id,color,size,address,price)"
                + "values(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setInt(2,product.getCategory_id());
            preparedStatement.setString(3,product.getColor());
            preparedStatement.setString(4,product.getSize());
            preparedStatement.setString(5,product.getAddress());
            preparedStatement.setString(6,product.getPrice());
            int rs = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateProduct(Product product){
        String sql = "Update productclothes set productName = ? , category_id = ? , color = ? , size = ? , "
                + " address = ? , price = ?  ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setInt(2,product.getCategory_id());
            preparedStatement.setString(3,product.getColor());
            preparedStatement.setString(4,product.getSize());
            preparedStatement.setString(5,product.getAddress());
            preparedStatement.setString(6,product.getPrice());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteProduct(int ID_PRODUCT) throws SQLException{
        String sql = "delete from productclothes where idProduct = ?";
        try{
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, ID_PRODUCT);
        int rs = preparedStatement.executeUpdate();
        System.out.println(rs);
        }
        catch(Exception e){
            e.printStackTrace();
        }           
    }
    
    public Product getProductById(int id) {
        String sql = "select * from productclothes where idProduct = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                

                product.setProductName(rs.getString("productName"));
                product.setCategory_id(rs.getInt("category_id"));
                product.setColor(rs.getString("color"));
                product.setSize(rs.getString("size"));
                product.setAddress(rs.getString("address"));
                product.setPrice(rs.getString("price"));
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
