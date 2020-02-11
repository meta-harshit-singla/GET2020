package com.metacube.parking;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/registration")
public class Registration extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        
        String fullName = req.getParameter("fullname");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String contactNo = req.getParameter("contactno");
        String organisation = req.getParameter("organisation");
        boolean flag = true;
        Connection con;
        try {
            con = (Connection) javaConnection.initializeDatabase();
            PreparedStatement st = con
                    .prepareStatement("insert into userdetail values(id,?,?,?,?,?,?)");
            PrintWriter out = res.getWriter();
            
            // check Email that it is already exists or not
            String sql = "select * from userdetail";
            Statement stmt = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("email").equalsIgnoreCase(email)) {
                    flag = false;
                    res.sendRedirect("alreadyExists.html");
                    break;
                }
            }
            if (flag) {
                st.setString(1, fullName);
                st.setString(2, gender);
                st.setString(3, email);
                st.setString(4, password);
                st.setString(5, contactNo);
                st.setString(6, organisation);
                st.executeUpdate();
                
                // Close all the connections
                st.close();
                con.close();
                HttpSession session = req.getSession();
                session.setAttribute("email", email);
                res.sendRedirect("vehicleRegistration.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}