
package services;

import dataaccess.RoleDB;
import dataaccess.UserDB;
import java.util.List;
import models.User;
import models.Role;

public class UserService {
    
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public void insert(String email, boolean active, String firstName, String lastName, String password, int roleID) throws Exception{
        RoleDB roleDB = new RoleDB();
        Role role = roleDB.get(roleID);
        User user = new User(email, active, firstName, lastName, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String email, boolean active, String firstName, String lastName, String password, int roleID) throws Exception{
        RoleDB roleDB = new RoleDB();
        Role role = roleDB.get(roleID);
        User user = new User(email, active, firstName, lastName, password, role);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception {
        UserDB userDB = new UserDB();
        userDB.delete(email);
    }
}
