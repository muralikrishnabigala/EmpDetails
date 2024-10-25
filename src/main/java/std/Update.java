package std;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/update")
public class Update extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	   	String id=req.getParameter("id");
	   	String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phn=req.getParameter("phn");
		String course=req.getParameter("course");
		String password=req.getParameter("password");
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&password=@Murali509");
			PreparedStatement ps=c.prepareStatement("update std set Sname=?, Semail=?, Sphn=?, Scourse=?, Spassword=? where Sid=?");
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setLong(3, Long.parseLong(phn));
			ps.setString(4, course);
			ps.setString(5, password);
			ps.setInt(6, Integer.parseInt(id));
			
			int row=ps.executeUpdate();
			System.out.println(row+":rows updated");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		PrintWriter pw=resp.getWriter();
		pw.write("<html><body><h1>Updated Successfully.......................</h1></body></html>");
	}

}

