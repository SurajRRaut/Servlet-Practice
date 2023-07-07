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
@WebServlet("/upd")

public class UpdateProd extends HttpServlet {
	Connection con;
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
		String pname ="";
		String pcategory = "";
		String pprice = "";
		String pqtyy = "";
		
		pname =req.getParameter("pname");
		pcategory = req.getParameter("pcategory");
		pprice = req.getParameter("pprice");
		pqtyy = req.getParameter("pqty");
		
		int pid = Integer.parseInt(req.getParameter("pid"));
		
		PrintWriter pw = resp.getWriter();
		PreparedStatement pstmt;
		if(!pname.isEmpty()) {
			String query1 ="update product set product_name = ? where product_id = ?";
			try {
				pstmt=con.prepareStatement(query1);
				pstmt.setString(1, pname);
				pstmt.setInt(2,pid);
				int count1  = pstmt.executeUpdate();
				if(count1>0) {
					pw.println("<h1>"+count1+" DATA UPDATED <h1>");
				}
				else {
					pw.println("<h1> DATA NOT UPDATED <h1>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(!pcategory.isEmpty()) {
			String query1 ="update product set product_cat = ? where product_id = ?";
			try {
				pstmt=con.prepareStatement(query1);
				pstmt.setString(1, pcategory);
				pstmt.setInt(2,pid);
				int count1  = pstmt.executeUpdate();
				if(count1>0) {
					pw.println("<h1>"+count1+" DATA UPDATED <h1>");
				}
				else {
					pw.println("<h1> DATA NOT UPDATED <h1>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(!pprice.isEmpty()) {
			double price = Double.parseDouble(pprice);
			String query1 ="update product set product_price = ? where product_id = ?";
			try {
				pstmt=con.prepareStatement(query1);
				pstmt.setDouble(1, price);
				pstmt.setInt(2,pid);
				int count1  = pstmt.executeUpdate();
				if(count1>0) {
					pw.println("<h1>"+count1+" DATA UPDATED <h1>");
				}
				else {
					pw.println("<h1> DATA NOT UPDATED <h1>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			int pqty = Integer.parseInt(pqtyy);
			String query1 ="update product set product_qty = ? where product_id = ?";
			try {
				pstmt=con.prepareStatement(query1);
				pstmt.setInt(1, pqty);
				pstmt.setInt(2,pid);
				int count1  = pstmt.executeUpdate();
				if(count1>0) {
					pw.println("<h1>"+count1+" DATA UPDATED <h1>");
				}
				else {
					pw.println("<h1> DATA NOT UPDATED <h1>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
