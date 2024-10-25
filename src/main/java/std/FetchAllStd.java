package std;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/allstd")
public class FetchAllStd extends HttpServlet
{
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&password=@Murali509");
    		Statement s=c.createStatement();
    		
    		ResultSet rs=s.executeQuery("select * from std");
    		
    		req.setAttribute("rs", rs);
        	RequestDispatcher rd = req.getRequestDispatcher("allstd.jsp");
        	rd.forward(req, resp);
        	
        	rs.close();
        	s.close();
        	c.close();
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}
