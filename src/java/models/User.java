
package models;

import java.io.Serializable;
import services.RoleService;

public class User implements Serializable {
    private String email;
    private boolean active;
    private String first_name;
    private String last_name;
    private String password;
    private int role;
    private String role_name;
    
    
    public User() {
    }
    
    public User(String first_name, String last_name, String email, boolean active, int role, 
                String password) throws Exception {

        RoleService rs = new RoleService();
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.active = active;
        this.role = role;
        this.password = password;
        this.role_name = rs.getRole_Name(Integer.toString(role));
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }
}
