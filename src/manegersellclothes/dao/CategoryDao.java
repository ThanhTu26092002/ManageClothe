package manegersellclothes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import manegersellclothes.connect.ConnectDB;
import manegersellclothes.entity.Category;
import manegersellclothes.entity.Product;

public class CategoryDao {

    public final Connection connection = ConnectDB.JDBC_CONECTION();

    public List<Category> getAllCategory() {
        List<Category> categorys = new ArrayList<Category>();
        String sql = "select * from Category";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setIdCategory(rs.getInt("idCategory"));
                category.setCategoryName(rs.getString("categoryName"));
                category.setNumber(rs.getInt("number"));

                categorys.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorys;
    }

    public void addCategory(Category category) {
        String sql = "insert into Category(categoryName,number) values(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setInt(2, category.getNumber());
            int rs = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateCategory(Category category) {
        String sql = "Update Category set categoryName = ? , number = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setInt(2, category.getNumber());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(int id_Category) throws SQLException {
        String sql = "delete from Category where idCategory = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_Category);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Category getCategoryById(int id) {
        String sql = "select * from Category where idCategory = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Category Category = new Category();
                
                Category.setIdCategory(rs.getInt("idCategory"));
                Category.setCategoryName(rs.getString("categoryName"));
                Category.setNumber(rs.getInt("number"));

                return Category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
