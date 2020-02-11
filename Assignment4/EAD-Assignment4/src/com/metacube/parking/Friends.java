package com.metacube.parking;

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
import javax.servlet.http.HttpSession;

@WebServlet("/friends")
public class Friends extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        try {
            
            HttpSession session = request.getSession();
            String org = (String)session.getAttribute("organisation");
            System.out.print(org);
            
            Connection con = javaConnection.initializeDatabase();
            String sql = "select * from userdetail where organisation='"+org+"'";
            Statement stmt=con.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int eId=rs.getInt("id");
                out.print("<a href=friendDetails?id="+eId+"><input type=button style=color:orange;border-radius:10px;margin:3px;float:center; value="+rs.getString("fullName")+"></a><br>" );
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}