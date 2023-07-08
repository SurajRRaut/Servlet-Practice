package staticApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/secondLink")
public class SecondApp extends GenericServlet {
//virtual keyword >> @Override
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String name1=req.getParameter("firstNo");
		String name2=req.getParameter("secondNo");
		double no1 = Double.parseDouble(name1);
		double no2 = Double.parseDouble(name2);
		PrintWriter pw = resp.getWriter();
		pw.print("<h1>ANSWER IS : "+(no1+no2)+"</h1>");
	}
}
