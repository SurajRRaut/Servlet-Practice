package productOperation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;
@WebServlet("/add")
public class AddProduct extends HttpServlet {
	Connection con;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1datab","root","Suraj12345");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pname =req.getParameter("pname");
		String pcategory =req.getParameter("pcategory");
		double price = Double.parseDouble(req.getParameter("pprice"));
		int pqty = Integer.parseInt(req.getParameter("pqty"));
		PreparedStatement pstmt;
		String query ="insert into product values(?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2,pname);
			pstmt.setString(3,pcategory);
			pstmt.setDouble(4,price);
			pstmt.setInt(5,pqty);
			int count  = pstmt.executeUpdate();
			PrintWriter pw = resp.getWriter();
			if(count>0) {
				pw.println("<h1>"+count+" DATA ADDED <h1>");
			}else {
				pw.println("<h1>DATA NOT ADDED <h1>");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
