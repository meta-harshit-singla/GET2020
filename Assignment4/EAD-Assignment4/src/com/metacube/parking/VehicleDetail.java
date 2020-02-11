package com.metacube.parking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/vehicledetail")
public class VehicleDetail extends HttpServlet {
    
    protected void doPost(HttpServletRequest req,HttpServletResponse res){
        Connection con;
        try{
            String emailId = req.getParameter("email");
            con = javaConnection.initializeDatabase();
            String sql = "select * from userdetail where email=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, req.getParameter("email"));
            ResultSet rs = st.executeQuery();
            rs.next();
            int empId = rs.getInt("id");
            String vehicleName = req.getParameter("vehiclename");
            String vehicleType = req.getParameter("vehicletype");
            String vehicleNo = req.getParameter("vehicleno");
            String vehicleIdentification = req.getParameter("vehicleidentification");
            st = con.prepareStatement("insert into vehicledetail values(?,?,?,?,?)");
            st.setInt(1, empId);
            st.setString(2, vehicleName);
            st.setString(3, vehicleType);
            st.setString(4, vehicleNo);
            st.setString(5, vehicleIdentification);
            st.executeUpdate();
            if(vehicleType.equalsIgnoreCase("cycle")){
                HttpSession session= req.getSession();
                session.setAttribute("vehicle", "Cycle");
                session.setAttribute("priceDaily", 5);
                session.setAttribute("priceMonthly", 100);
                session.setAttribute("priceYearly", 500);
                res.sendRedirect("vehiclePrice.jsp");
            }
            else if(vehicleType.equalsIgnoreCase("motorCycle") ){	
                HttpSession session= req.getSession();
                session.setAttribute("vehicle", "MotorCycle");
                session.setAttribute("priceDaily", 10);
                session.setAttribute("priceMonthly", 200);
                session.setAttribute("priceYearly", 1000);
                res.sendRedirect("vehiclePrice.jsp");
                
            }
            else if(vehicleType.equalsIgnoreCase("fourWheelers")){
                HttpSession session= req.getSession();
                session.setAttribute("vehicle", "FourWheeler");
                session.setAttribute("priceDaily", 20);
                session.setAttribute("priceMonthly", 500);
                session.setAttribute("priceYearly", 3500);
                res.sendRedirect("vehiclePrice.jsp");
                
            }
            // Close all the connections
            st.close();
            con.close();	
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}