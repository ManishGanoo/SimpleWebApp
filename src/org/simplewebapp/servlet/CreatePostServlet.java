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
 
import org.simplewebapp.beans.Posts;
import org.simplewebapp.utils.DBUtils;
 
@WebServlet(urlPatterns = { "/createPost" })
public class CreatePostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreatePostServlet() {
        super();
    }
 
    // Show post creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createPostView.jsp");
        dispatcher.forward(request, response);
    }
 
    // When the user enters the post information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String userid = request.getParameter("userid");
        String title = (String) request.getParameter("code");
        String body = (String) request.getParameter("name");
    
        String errorString = null;
        
        if (title != null || body.length()<400) {
	        try {
	            DBUtils.insertPost(userid, title, body);
	        } catch (IOException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
        }else {
        	errorString = "Title should be filled or body length should be less than 400";
        }
	        	
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
 
        // If error, forward to create page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createPostView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the post listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/posts");
        }
    }
 
}