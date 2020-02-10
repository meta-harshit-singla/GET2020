package main;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ShowStudentDetails
 */
@WebServlet("/ShowStudentDetails")
public class ShowStudentDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        try 
        {    
            Connection con = DatabaseConnection.initializeDatabase();    
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from studentDetails");  
            out.println("<table border=1><tr><th>StudentId</th><th>First Name</th><th>Last Name</th><th>Father's Name</th><th>Email-id</th><th>Class</th><th>Age</th></tr>");  
            while (rs.next()) 
            {  
                int studentId = rs.getInt("sId");  
                String firstName = rs.getString("firstName");
                String secondName = rs.getString("secondName");
                String fatherName=rs.getString("fatherName");
                String emailId=rs.getString("emailId");
                int class1 = rs.getInt("class");
                int age=rs.getInt("age");
                out.println("<tr><td>" + studentId + "</td><td>" + firstName + "</td><td>" + secondName + "</td><td>" + fatherName + "</td><td>" + emailId + "</td><td>" + class1 + "</td><td>" + age + "</td>");   
                out.println("<td><a href="+"UpdateStudentDetail?id="+studentId+"><button>"+"Update"+"</button></a>"+"</td></tr>");
            }  
            out.println("</table>");   
            stmt.close();
            con.close();  
        }  
        catch (Exception e) 
        { 
            e.printStackTrace();  
        }  
    }
}