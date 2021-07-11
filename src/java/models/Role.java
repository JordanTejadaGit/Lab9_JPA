
package models;

import java.io.Serializable;

public class Role implements Serializable{
    
    private String role_name;
    private int role_id;
           
    public Role() {
    }
    
    public Role(String role_name, int role_id) {
        this.role_name = role_name;
        this.role_id = role_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRoleid(int role_id) {
        this.role_id = role_id;
    }
    
    
    public String getRole_name() {
        return role_name;
    }

    public void setRole_id(String role_name) {
        this.role_name = role_name;
    }
    
    
}
