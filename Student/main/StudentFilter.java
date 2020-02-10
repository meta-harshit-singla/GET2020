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
 * Servlet implementation class StudentFilter
 */
@WebServlet("/StudentFilter")
public class StudentFilter extends HttpServlet {
    private static final long serialVersionUID = 1L;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentFilter() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.print("<html><body><table border=1>");
        try {
            Connection conn = DatabaseConnection.initializeDatabase();
            String sql = "SELECT * FROM studentDetails" + " ORDER BY class ASC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            out.print("<tr><td>Student id</td><td>First Name</td><td>Last name</td><td>Father's name</td><td>Email-id</td><td>Class</td><td>Age</td>");
            while (rs.next()) {
                out.print("<tr><td>" + rs.getInt("sId") + "</td>" + "<td>"
                        + rs.getString("firstName") + "</td>" + "<td>"
                        + rs.getString("secondName") + "</td>" + "<td>"
                        + rs.getString("fatherName") + "</td>" + "<td>"
                        + rs.getString("emailId") + "</td>" + "<td>"
                        + rs.getInt("class") + "</td>" + "<td>"
                        + rs.getInt("age") + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body></html>");
            conn.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}