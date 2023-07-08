package staticApp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
@WebServlet("/emp")
public class EmpInfo extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("empId");
		int id1 = Integer.parseInt(id);
		String name=req.getParameter("empName");
		String sal=req.getParameter("empSal");
		double sal1 = Double.parseDouble(sal);
		String hra=req.getParameter("empHRA");
		double hra1 = Double.parseDouble(hra);
		String pf=req.getParameter("empPF");
		double pf1 = Double.parseDouble(pf);
		String des = req.getParameter("desig");
		
		PrintWriter pw = resp.getWriter();

//		pw.println("<h1 style='color:red'>"+"EMPLOYEE id : "+id1+"</h1><br></br>");
		pw.println("EMPLOYEE id : "+id1);
		pw.println("EMPLOYEE NAME : "+name);
		double annSal =(sal1*hra1*pf1)*12;
		pw.println("ANNUAL SALARY : "+annSal);
		
		if("Developer".equalsIgnoreCase(des)) {
			double inc = annSal+(0.30*annSal);
			pw.println("Increement Sal : "+inc);
			pw.println("EMPLOYEE DESIGNATION : "+des);
		}
		else if("Tester".equalsIgnoreCase(des)) {
			double inc = annSal+(0.20*annSal);
			pw.println("Increement Sal : "+inc);
			pw.println("EMPLOYEE DESIGNATION : "+des);
		}
		else if("HR".equalsIgnoreCase(des)) {
			double inc = annSal+(0.10*annSal);
			pw.println("Increement Sal : "+inc);
			pw.println("EMPLOYEE DESIGNATION : "+des);
		}
		else {
			pw.println("GO BACK CHOOSE DESIGNATION");
		}
	}
}
