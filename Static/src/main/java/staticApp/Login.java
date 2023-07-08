package staticApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/log")
public class Login extends HttpServlet {
	private final String email1 ="surajrr2472000@gmail.com";
	private final long cno1 = 8208627035l;
	private final String pass1 = "Suraj@12345";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		String userId = req.getParameter("userId");
		String pass = req.getParameter("pass");
		
		if(email1.equals(userId)) {
			if((userId.equals(email1) && pass1.equals(pass))){
				pw.println("CONTACT NO : "+ cno1);
				pw.println("EMAIL ID : "+ email1);
				pw.println("PASSWARD : "+ pass1);
			}
			else {
				pw.println("OPPS...!!\nINCORRECT PASSWARD OR USERNAME 🫤🫤");
			}
		}	
		else{	
			if(userId.contains("8208627035")) {
				long userId2=Long.parseLong(userId);
				if((userId2==cno1) && pass1.equals(pass)){
					pw.println("CONTACT NO : "+ cno1);
					pw.println("EMAIL ID : "+ email1);
					pw.println("PASSWARD : "+ pass1);
				}
				else {
					pw.println("OPPS...!!\nINCORRECT PASSWARD OR USERNAME 🫤🫤");
				}
			}else {
				pw.println("OPPS...!!\nINCORRECT PASSWARD OR USERNAME 🫤🫤");
			}
		}
	}
}
