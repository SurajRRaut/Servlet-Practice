package demoApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/log")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		String username = req.getParameter("username");
		String pass = req.getParameter("pass");
		
			if((username.equals("admin") && pass.equals("sql@123"))){
				pw.println("<h1> WELCOME "+username+"</h1>");
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				pw.println("<h1>INVALID USERNAME OR PASSWARD</h1>");
				rd.include(req, resp);
			}	
	}
}
