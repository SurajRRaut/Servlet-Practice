package staticApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/stu")
public class StudentPortal extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sName=req.getParameter("sName");
		String cno =req.getParameter("cno");
		int cno1 = Integer.parseInt(cno);
		String[] course =req.getParameterValues("Course");
		PrintWriter pw = resp.getWriter();
		pw.println("STUDENT NAME : "+sName);
		pw.println("CONTACT NUMBER : "+cno1);
		pw.println("SELECTED COURSES ARE : ");
		for(String a : course) {
			pw.println(" "+a);
		}
	}
}
