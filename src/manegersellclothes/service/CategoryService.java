
package manegersellclothes.service;

import java.sql.SQLException;
import java.util.List;
import manegersellclothes.dao.CategoryDao;
import manegersellclothes.entity.Category;



public class CategoryService {
    private final CategoryDao categoryDao;

    public CategoryService() {
        categoryDao = new CategoryDao();
    }

    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    public void addCategory(Category category) {
        categoryDao.addCategory(category);
    }

    public void deleteCategory(int id) throws SQLException {
       categoryDao.deleteCategory(id);
    }

    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }
    public Category getCategoryByID(int id){
        return categoryDao.getCategoryById(id);
    }
}
