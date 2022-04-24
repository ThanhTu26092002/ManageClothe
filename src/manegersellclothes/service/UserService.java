
package manegersellclothes.service;

import java.sql.SQLException;
import manegersellclothes.dao.UserDao;
import manegersellclothes.entity.User;


public class UserService {
    private UserDao userDao;
    
    public UserService(){
        userDao = new UserDao();
    }
    public void addUser(User user){
         userDao.addUser(user);
    }
    public User getUser(String userName, String password) throws SQLException{
        return userDao.getUser(userName, password);
    }
}
