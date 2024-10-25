package std;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login")
public class LoginStd extends HttpServlet
{
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    	 String email=req.getParameter("email");
    	 String password=req.getParameter("password");
    	 
    	 try
    	 {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
    		 Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&password=@Murali509");
    		 PreparedStatement ps=c.prepareStatement("select * from std where Semail=? and Spassword=?");
    		 ps.setString(1, email);
    		 ps.setString(2, password);
    		 
    		 ResultSet rs=ps.executeQuery();
    		 
    		 PrintWriter pw=resp.getWriter();
    		 
    		 if(rs.next())
    		 {
    			 try
    			 {
    				 Class.forName("com.mysql.cj.jdbc.Driver");
    				 Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&password=@Murali509");
    				 Statement s=c.createStatement();
    				 ResultSet rs1=s.executeQuery("select * from std");
    				 
    				 pw.write("<html><body><h1>Login Successfully..............</h1></body></html>");
    				 
    				req.setAttribute("rs", rs1);
     	        	RequestDispatcher rd = req.getRequestDispatcher("allstd.jsp");
     	        	rd.include(req, resp);
    			 }
    			 catch(Exception e)
    			 {
    				 e.printStackTrace();
    			 }
    			 
//    			 pw.write("<html><body><h1>Log In Successfully</h1></body></html>");
//        		 RequestDispatcher rd=req.getRequestDispatcher("loginstd.jsp");
//        		 rd.include(req, resp);
    			 
    		 }else {
        		 
        		 pw.write("<html><body><h1>INVALID CRENDENTIAL</h1></body></html>");
	//        		 RequestDispatcher rd=req.getRequestDispatcher("loginstd.jsp");
	//        		 rd.include(req, resp);
        	 }
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    }
}
