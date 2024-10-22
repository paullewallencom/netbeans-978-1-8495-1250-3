/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.flickr;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author dantas
 */
@WebServlet(name = "FlickrPhotoServiceCallback", urlPatterns = "/FlickrPhotoServiceCallback")
public class FlickrPhotoServiceCallback extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);
            String frob = request.getParameter("frob");
            session.setAttribute("flickr_frob", frob);
            
            FlickrPhotoServiceAuthenticator.login(request, response);
            String authToken = FlickrPhotoServiceAuthenticator.getAuthToken(request, response);
         
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FlickrPhotoServiceCallback</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FlickrPhotoServiceCallback at " + request.getContextPath() + "</h1>");
            out.println("<p> Your authentication token is " + authToken + "</p>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
