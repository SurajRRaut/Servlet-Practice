package staticApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/firstLink")

public class FirstApplication extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("username");
		PrintWriter pw = resp.getWriter();
		pw.print("WELCOME "+name);
		
	}

}
