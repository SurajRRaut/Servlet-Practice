package demoApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/firstlink")
public class FirstClass extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		PrintWriter pw = resp.getWriter();
		pw.print("<h1>WELCOME "+username+"</h1>");
		RequestDispatcher rd = req.getRequestDispatcher("secondlink");
		//rd.forward(req, resp);
		rd.include(req, resp);
		pw.print("<h1>WELCOME THANK YOU FOR VISITING </h1>");
	}

}
