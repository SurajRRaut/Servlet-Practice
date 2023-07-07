package productOperation;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del")
public class DeleteProduct extends HttpServlet {
	Connection con;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String i =req.getParameter("pid");
		int id = Integer.parseInt(i);
		PrintWriter pw = resp.getWriter();
		String query ="delete from product where product_id=?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			int count =pstmt.executeUpdate();
			if(count>0) {
				pw.print("<h1>"+count+" : PRODUCT DELETED SUCCESSFULLY <h1>");
			}
			else {
				pw.print("<h1> PRODUCT NOT DELETED OR PRODUCT NOT EXIST !<h1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
