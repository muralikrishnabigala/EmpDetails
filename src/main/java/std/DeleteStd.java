package std;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/delete")
public class DeleteStd extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
	       try
	       {
	    	   Class.forName("com.mysql.cj.jdbc.Driver");
	    	   Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&password=@Murali509");
	    	   PreparedStatement ps=c.prepareStatement("delete from std where Sid=?");
	    	   
	    	   ps.setInt(1, id);
	    	   
	    	   int row=ps.executeUpdate();
	    	   System.out.println(row+":rows deleted");
	    	   
	    	   ps.close();
	    	   c.close();
	       }
	       catch(Exception e)
	       {
	    	   e.printStackTrace();
	       }
	}

}
