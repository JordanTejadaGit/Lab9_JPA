package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.UserService;
import services.RoleService;
import javax.servlet.http.HttpSession;
import models.User;
import models.Role;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService us = new UserService();
        RoleService rs = new RoleService();

        try {
            List<User> users = us.getAll();
            List<Role> roles = rs.getAll();
            request.setAttribute("users", users);
            request.setAttribute("roles", roles);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService us = new UserService();

        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("delete")) {
                try {
                    String emailDelete = request.getParameter("Selection");
                    us.delete(emailDelete);
                    request.setAttribute("action", action);
                    response.sendRedirect("user");
                } catch (Exception ex) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (action.equals("add")) {
                try {
                    String addEmail = request.getParameter("addEmail");
                    String addFirst = request.getParameter("addFirst");
                    String addLast = request.getParameter("addLast");
                    String addPassword = request.getParameter("addPassword");
                    int addRole = Integer.parseInt(request.getParameter("addRole"));
                    us.insert(addEmail, false, addFirst, addLast, addPassword, addRole);
                    request.setAttribute("action", action);
                    response.sendRedirect("user");
                }
                catch (Exception ex) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (action.equals("update")) {
                try {
                    String editEmail = request.getParameter("updateEmail");
                    String editFirst = request.getParameter("updateFirst");
                    String editLast = request.getParameter("upadteLast");
                    String editPassword = request.getParameter("upadtePassword");
                    int addRole = Integer.parseInt(request.getParameter("updateRole"));
                    us.update(editEmail, false, editFirst, editLast, editPassword, addRole);
                    request.setAttribute("action", action);
                    response.sendRedirect("user");
                }
                catch (Exception ex) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
