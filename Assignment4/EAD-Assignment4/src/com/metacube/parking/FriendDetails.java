package com.metacube.parking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/friendDetails")
public class FriendDetails extends HttpServlet {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try{
            Connection con = javaConnection.initializeDatabase();
            String sql = "select * from userdetail where id='"+id+"'";
            Statement stmt=con.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            HttpSession session = request.getSession();
            session.setAttribute("idFriend", id);
            session.setAttribute("nameFriend", rs.getString("fullName"));
            session.setAttribute("genderFriend", rs.getString("gender"));
            session.setAttribute("emailFriend", rs.getString("email"));
            session.setAttribute("contactNoFriend", rs.getString("contactNo"));	 
            response.sendRedirect("friends.jsp");
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}