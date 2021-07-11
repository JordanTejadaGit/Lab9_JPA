
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Role;

public class RoleDB {
    
    public List<Role> getAll() throws Exception {
        List<Role> roles = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM role";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                 int role_id = rs.getInt(1);
                 String role_name = rs.getString(2);
                 Role role = new Role(role_name, role_id);
                 roles.add(role);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return roles;
    }
    
    public String getRole_Name(String role_id) throws Exception {
        String role_name = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT role_name from role WHERE role_id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, role_id);
            rs = ps.executeQuery();
            if (rs.next()) {
               role_name = rs.getString(1); 
            }
        }
     finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
    }
    return role_name;
    }
}
