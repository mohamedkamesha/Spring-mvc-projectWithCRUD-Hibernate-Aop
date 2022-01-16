package testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		 String dbName="web_customer_tracker";
        String sqlUrl="jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false",
        		user="springstudent",
        		pass="springstudent";
		
	 
		        try {
		        	
		        	PrintWriter out = response.getWriter();
		        	
		        	out.println("connection to jdbc "+ sqlUrl);
		        	
		           
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection connection= DriverManager.getConnection(sqlUrl,user,pass);
		            out.println("connection success");
		            
		            connection.close();
		        }
		        catch (Exception ex) {

		            ex.printStackTrace();
		        }
		
		
		
	}

}
