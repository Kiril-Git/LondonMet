package com.cs5003.bookstore_test.servlets;
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;

import com.cs5003.bookstore_test.constants.IOnlineBookStoreConstants;
import com.cs5003.bookstore_test.sql.IBookConstants;
import jakarta.servlet.http.HttpServlet;


public class ViewBookServlet extends HttpServlet{
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from " + IBookConstants.TABLE_BOOK);
			ResultSet rs = ps.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("ViewBooks.html");
			rd.include(req, res);
			pw.println("<div class=\"tab\">Books Available In Our Store</div>");
			pw.println("<div class=\"tab\">\r\n" + 
					"		<table>\r\n" + 
					"			<tr>\r\n" + 
					"				\r\n" + 
					"				<th>Book Code</th>\r\n" + 
					"				<th>Book Name</th>\r\n" + 
					"				<th>Book Author</th>\r\n" + 
					"				<th>Book Price</th>\r\n" + 
					"				<th>Quantity</th><br/>\r\n" + 
					"			</tr>");
			while(rs.next())
			{
				String bCode = rs.getString(1);
				String bName = rs.getString(2);
				String bAuthor = rs.getString(3);
				int bPrice = rs.getInt(4);
				int bQty = rs.getInt(5);
				pw.println("<tr><td>"+bCode+"</td>");
				pw.println("<td>"+bName+"</td>");
				pw.println("<td>"+bAuthor+"</td>");
				pw.println("<td>"+bPrice+"</td>");
				pw.println("<td>"+bQty+"</td></tr>");
			}
			pw.println("</table>\r\n" + 
					"	</div>");
			//pw.println("<div class=\"tab\"><a href=\"AddBook.html\">Add More Books</a></div>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
