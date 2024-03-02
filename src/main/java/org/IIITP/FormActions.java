package org.IIITP;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.IIITP.Users.User;

import jakarta.servlet.annotation.WebServlet;

import org.IIITP.DBOperations.Operations;
import org.IIITP.connect.DBConnection;

@WebServlet("/Form")
public class FormActions extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String form = request.getParameter("formType");
        switch(form) {
            case "Add":{
                User newUser = new User(Integer.parseInt(request.getParameter("id")),request.getParameter("Username"),request.getParameter("email"));
                Operations.addUser(newUser);
                request.getRequestDispatcher("listusers.jsp").forward(request, response);
                break;
            }
            case "Update":{
                User currUser = new User(Integer.parseInt(request.getParameter("Id")),request.getParameter("Username"),request.getParameter("email"));
                Operations.UpdateUser(currUser);
                request.getRequestDispatcher("listusers.jsp").forward(request, response);
                break;
            }
            case "login":{
                User currUser = new User(request.getParameter("username"),request.getParameter("email"));
                int UserId = Operations.getUserId(currUser);
                request.setAttribute("UserId", UserId);
                request.getRequestDispatcher("getUserId.jsp").forward(request, response);
                break;
            }
            case "DeleteUsers":{
                User currUser = new User(Integer.parseInt(request.getParameter("Id")),request.getParameter("Username"),request.getParameter("email"));
                Operations.deleteUser(currUser);
                request.getRequestDispatcher("listusers.jsp").forward(request,response);
                break;
            }
            default:{
                request.getRequestDispatcher("error.jsp").forward(request, response);
                break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String form = request.getParameter("formType");
        switch(form) {
            case "DeleteUsers":{
                User currUser = new User(Integer.parseInt(request.getParameter("Id")),request.getParameter("Username"),request.getParameter("email"));
                Operations.deleteUser(currUser);
                request.getRequestDispatcher("listusers.jsp").forward(request,response);
                break;
            }
            default:{
                request.getRequestDispatcher("error.jsp").forward(request, response);
                break;
            }
        }
    }
}
