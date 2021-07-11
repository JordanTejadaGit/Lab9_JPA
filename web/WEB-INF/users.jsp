<%-- 
    Document   : users.jsp
    Created on : Jun 25, 2021, 11:29:59 PM
    Author     : 694952
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User </title>
    </head>
    <body>
        <h1>User Page</h1>
        <form action="user" method="post">
            <table>
                <tr>
                    <td>
                        First Name   
                    </td>
                    <td>
                        Last Name   
                    </td>
                    <td>
                        Email   
                    </td>
                    <td>
                        Role
                    </td>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>
                            <input type="hidden" name="first_name" value="${user.first_name}">
                            ${user.first_name}
                        </td>
                        <td>
                            <input type="hidden" name="last_name" value="${user.last_name}">
                            ${user.last_name}

                        </td>
                        <td>
                            <input type="hidden" name="email" value="${user.email}">
                            ${user.email}
                        </td>
                        <td>
                            ${user.role_name}
                        </td>
                        <td>
                            <input type ="radio" name="Selection" value="${user.email}">
                        </td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td>
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                        </td>
                    </tr>
            </table>
        </form>
        <h2>Add User</h2>
        <form action="user" method="post">
            <table>
                <tr>
                    <td>
                        Email: 
                    </td>
                    <td>
                        <input type="text" name="addEmail">
                    </td>
                </tr>
                <tr>
                    <td>
                        First Name: 
                    </td>
                    <td>
                        <input type="text" name="addFirst">
                    </td>
                </tr>
                <tr>
                    <td>
                        Last Name: 
                    </td>
                    <td>
                        <input type="text" name="addLast">
                    </td>
                </tr>
                <tr>
                    <td>
                        Password: 
                    </td>
                    <td>
                        <input type="password" name="addPassword">
                    </td>
                </tr>
                <tr>
                    <td>
                        Role:
                    </td>
                    <td>
                        <select name="addRole">
                            <c:forEach items="${roles}" var="roles">
                                <option value="${roles.getRole_id()}">${roles.getRole_name()}</option>
                            </c:forEach>
                        </select>
                </tr>
            </table>
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        <h2>Edit User</h2>
        <form action="user" method="post">
            <table>
            <tr>
                    <td>
                        Email: 
                    </td>
                    <td>
                        <input type="text" name="updateEmail" >
                    </td>
                </tr>
                <tr>
                    <td>
                        First Name: 
                    </td>
                    <td>
                        <input type="text" name="updateFirst">
                    </td>
                </tr>
                <tr>
                    <td>
                        Last Name: 
                    </td>
                    <td>
                        <input type="text" name="upadteLast">
                    </td>
                </tr>
                <tr>
                    <td>
                        Password: 
                    </td>
                    <td>
                        <input type="text" name="upadtePassword">
                    </td>
                </tr>
                <tr>
                    <td>
                        Role:
                    </td>
                    <td>
                        <select name="updateRole">
                            <c:forEach items="${roles}" var="roles">
                                <option value="${roles.getRole_id()}">${roles.getRole_name()}</option>
                            </c:forEach>
                        </select>
                </tr>
            </table>
            <input type="submit" value="Update">
            <input type="hidden" name="action" value="update">
        </form>

    </body>
</html>
