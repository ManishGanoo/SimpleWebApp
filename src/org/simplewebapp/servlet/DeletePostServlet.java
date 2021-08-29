package org.simplewebapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
import org.simplewebapp.utils.DBUtils;

@WebServlet(urlPatterns = { "/deletePost" })
public class DeletePostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public DeletePostServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        String id = (String) request.getParameter("id");
 
        String errorString = null;
 
        try {
            DBUtils.deletePost(id);
        } catch (IOException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } 
         
        // If has an error, outpur error
        if (errorString != null) {
            System.out.println(errorString);
        }
        // If everything nice.
        // Redirect to the post listing page.        
        else {
            response.sendRedirect(request.getContextPath() + "/postList");
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}