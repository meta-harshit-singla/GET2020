package com.metacube.parking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userdetail")
public class UserDetail extends HttpServlet {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        String name = null,gender = null,contactNo = null,organisation = null;
        Connection con;
        PreparedStatement st,st1;
        HttpSession session  = req.getSession();
        int id = (int) session.getAttribute("id");
        try{
            con = javaConnection.initializeDatabase();
            String sql = "update userdetail SET fullName=?,gender=?,email=?,contactNo=?,organisation=? where id=?";
            st = con.prepareStatement(sql);
            st.setString(1,req.getParameter("fullName"));
            st.setString(2,req.getParameter("gender"));
            st.setString(3,req.getParameter("email"));
            st.setString(4,req.getParameter("contact"));
            st.setString(5,req.getParameter("org"));
            st.setInt(6,id);
            st.executeUpdate();
            st.close();
            
            String sql1 = "update vehicledetail SET vehicleName=?,vehicleType=?,vehicleno=?,identification=? where empid=?";
            st1 = con.prepareStatement(sql1);
            st1.setString(1,req.getParameter("vehicletype"));
            st1.setString(2,req.getParameter("vehiclename"));
            st1.setString(3,req.getParameter("vehicleno"));
            st1.setString(4,req.getParameter("vehicleidentity"));
            st1.setInt(5,id);
            st1.executeUpdate();
            st1.close();
            
            con.close();
            res.sendRedirect("showUpdateMsg.jsp");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}