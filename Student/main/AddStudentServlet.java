package main;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.DatabaseConnection;
/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public AddStudentServlet() 
    {
        super();
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try { 
            // Initialize the database 
            Connection con= DatabaseConnection.initializeDatabase(); 
            // Create a SQL query to insert data into demo table 
            // demo table consists of two columns, so two '?' is used 
            PreparedStatement st = con 
                    .prepareStatement("insert into studentDetails values(sId,?,?,?,?,?,?)");
            st.setString(1,request.getParameter("firstName"));
            st.setString(2,request.getParameter("secondName"));
            st.setString(3,request.getParameter("fatherName"));
            st.setString(4,request.getParameter("emailId"));
            st.setInt(5,Integer.parseInt(request.getParameter("class")));
            st.setInt(6,Integer.parseInt(request.getParameter("age")));
            // Execute the insert command using executeUpdate() 
            // to make changes in database 
            st.executeUpdate();            
            // Close all the connections 
            st.close(); 
            con.close();
            response.sendRedirect("index.html");
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
}