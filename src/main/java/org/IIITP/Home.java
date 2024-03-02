package org.IIITP;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.IIITP.Users.User;

import jakarta.servlet.annotation.WebServlet;

import org.IIITP.DBOperations.Operations;
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _page = request.getParameter("page");
		switch(_page) {
			case "HomePage":
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			case "ListUsers":
				request.getRequestDispatcher("listusers.jsp").forward(request, response);
				break;
			case "AddUsers":
				request.getRequestDispatcher("addusers.jsp").forward(request, response);
				break;
			case "UpdatePage":
				request.getRequestDispatcher("updateusers.jsp").forward(request,response);
				break;
			case "Login":
				request.getRequestDispatcher("login.jsp").forward(request,response);
				break;
			default:
				System.out.println(_page);
				request.getRequestDispatcher("error.jsp").forward(request, response);
				break;
		}
	}

}
