/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.flickr;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author dantas
 */
@WebServlet(name = "FlickrPhotoServiceLogin", urlPatterns = "/FlickrPhotoServiceLogin")
public class FlickrPhotoServiceLogin  extends HttpServlet {
   
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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Flickr Authorization Page</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Please click on the following link to log into your Flickr account and authorize this application to access your account:</p>");
            HttpSession session = request.getSession(true);
            
            String authToken = (String) session.getAttribute("flickr_auth_token");
            
            if (authToken != null) {
                out.println("<p>Already logged in.</b>");
            } else {
                String apiKey = FlickrPhotoServiceAuthenticator.getApiKey(request, response);
                String perms = "delete";
                String apiSig = FlickrPhotoServiceAuthenticator.sign(
                        new String[][] {
                            {"api_key", apiKey}, 
                            {"perms", perms}});
                           
                out.println("<a href=\"http://www.flickr.com/services/auth/?api_key="+apiKey+"&perms="+perms+"&api_sig="+apiSig+"\">Flickr Login</a>");
            }
            out.println("</body>");
            out.println("</html>");
        } catch(IOException iox) {
            out.println("Exception occured: "+iox.getMessage());
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
