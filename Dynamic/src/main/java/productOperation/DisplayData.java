package productOperation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/disp")
public class DisplayData extends HttpServlet {
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResultSet rs;
		PreparedStatement pstmt;
		String query ="select * from product";
		try {
			pstmt=con.prepareStatement(query);
			rs  = pstmt.executeQuery();
			PrintWriter pw = resp.getWriter();
			
			pw.print("<table bgcolor =yellow border=1 rules =all cellspacing=20px cellpadding=20>"
					+ "            	   <tr>"
					+ "                    <th>Product_ID</th>"
					+ "                    <th>Product_Name</th>"
					+ "                    <th>Product_Category</th>"
					+ "                    <th>Product_Price</th>"
					+ "                    <th>Product_Qty</th>"
					+ "            	   </tr>");
					while(rs.next()) {
						pw.print("<tr>");
						pw.print("<td>"+rs.getInt(1)+"</td>");
						pw.print("<td>"+rs.getString(2)+"</td>");
						pw.print("<td>"+rs.getString(3)+"</td>");
						pw.print("<td>"+rs.getDouble(4)+"</td>");
						pw.print("<td>"+rs.getInt(5)+"</td>");
						pw.print("</tr>");
					}
					pw.print("</table>");
					
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
