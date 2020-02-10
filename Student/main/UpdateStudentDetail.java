package main;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class UpdateStudentDetail
 */
@WebServlet("/UpdateStudentDetail")
public class UpdateStudentDetail extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentDetail() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter(); 
        try {
            int studentId=Integer.parseInt(request.getParameter("id"));
            Connection con= DatabaseConnection.initializeDatabase(); 
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from studentDetails WHERE sId="+studentId);
            rs.next();
            String firstName = rs.getString("firstName");    
            String secondName = rs.getString("secondName");
            String fatherName=rs.getString("fatherName");
            String emailId=rs.getString("emailId");
            int age=rs.getInt("age");
            out.println("<html><body><form action='UpdateStudentDetail' method='post' a href="+"UpdateStudentDetail?id="+studentId+">"+"<input type="+"hidden"+" name=\"studentId\" value="+studentId+" readonly>"+"<label> <fieldset><legend>First Name</legend>"
                    + "<input type="+"text"+" name=\"firstName\" value="+firstName+" required></fieldset></label>"+"<label> <fieldset><legend>Last Name</legend>"
                    + "<input type="+"text"+" name=\"secondName\" value="+secondName+" required></fieldset></label>"
                    +"<label> <fieldset><legend>Father's Name</legend>"
                    + "<input type="+"text"+" name=\"fatherName\" value="+fatherName+" required></fieldset></label>"
                    +"<label> <fieldset><legend>Email-id</legend>"
                    + "<input type="+"text"+" name=\"emailId\" value="+emailId+" required></fieldset></label>"
                    +"<label> <fieldset><legend>Class</legend>"
                    + "<select id="+"class"+" name="+"class"+">"+
                    "<option value="+"1"+" selected="+"true" +">1</option>"+
                    "<option value="+"2"+">2</option>"+
                    "<option value="+"3"+">3</option>"+
                    "<option value="+"4"+">4</option>"+
                    "<option value="+"5"+">5</option>"+
                    "<option value="+"6"+">6</option>"+
                    "<option value="+"7"+">7</option>"+
                    "<option value="+"8"+">8</option>"+
                    "<option value="+"9"+">9</option>"+
                    "<option value="+"10"+">10</option>"+
                    "<option value="+"11"+">11</option>"+
                    "<option value="+"12"+">12</option>"+
                    "</select></label></fieldset><br />"
                    +"<label><fieldset><legend>Age</legend>"
                    + "<input type="+"text"+" name=\"age\" value="+age+" required></fieldset></label>"+
                    "<input type=\"submit\" value=\"Submit\"></form></body></html>");
            stmt.close();
            con.close();
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
        // Initialize the database 
        try
        {
            Connection con= DatabaseConnection.initializeDatabase();
            int studentId=Integer.parseInt(request.getParameter("studentId"));
            System.out.println(request.getParameter("studentId"));
            // Create a SQL query to insert data into demo table 
            // demo table consists of two columns, so two '?' is used 
            PreparedStatement st = con 
                    .prepareStatement("UPDATE studentDetails SET firstName=?,secondName=?,fatherName=?,emailId=?,class=?,age=? WHERE sId="+studentId);
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
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }   
}