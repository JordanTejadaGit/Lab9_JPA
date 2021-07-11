/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Role;

public class RoleService {
    
    public List<Role> getAll() throws Exception {
       RoleDB roleDB = new RoleDB();
       List<Role> roles = roleDB.getAll();
       return roles;
    }
    
    public String getRole_Name(String role_id) throws Exception {
        RoleDB roleDB = new RoleDB();
        String role_name = roleDB.getRole_Name(role_id);
        return role_name;
    }
    
}
