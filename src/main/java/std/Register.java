package std;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/register")
public class Register extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phn=req.getParameter("phn");
		String course=req.getParameter("course");
		String password=req.getParameter("password");
		
//		System.out.println(id);
//		System.out.println(name);
//		System.out.println(email);
//		System.out.println(phn);
//		System.out.println(course);
//		System.out.println(password);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&password=@Murali509");
			PreparedStatement ps=c.prepareStatement("insert into std values(?,?,?,?,?,?)");
			
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setLong(4, Long.parseLong(phn));
			ps.setString(5, course);
			ps.setString(6, password);
			
			int row=ps.executeUpdate();
			System.out.println(row+":rows inserted");
			
			ps.close();
			c.close();
			
			PrintWriter pw=resp.getWriter();
			pw.write("<html><body><h1>Registration Successfully..............</h1></body></html>");
			
			RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			rd.include(req, resp);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  
	}

}
