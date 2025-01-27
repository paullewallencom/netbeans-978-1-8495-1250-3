/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.twitter;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author dantas
 */
@WebServlet(name = "TwitterWhatAreYouDoingServiceLogin", urlPatterns = "/TwitterWhatAreYouDoingServiceLogin")
public class TwitterWhatAreYouDoingServiceLogin extends HttpServlet {
   
    private static String CLASS_NAME = TwitterWhatAreYouDoingServiceLogin.class.getSimpleName();
    private static String CALLBACK_URL = CLASS_NAME.replace("Login", "Callback");
    
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
            out.println("<title>" + CLASS_NAME + "</title>");  
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"post\" action=\"./" + CALLBACK_URL + "\">");
            out.println("<br><br><br>");
            out.println("<table cellspacing=0 cellpadding=0 width=320 align=\"center\">");
            out.println("<tr><td>Username:</td><td>");
            out.println("<tr><td><input name=\"username\" type=\"text\" width=10></td></tr>");
            out.println("<tr><td>Password: </td><td>");
            out.println("<tr><td><input name=\"password\" type=\"password\" width=10></td></tr>");
            out.println("<tr><td colspan=2 align=\"center\"><input name=\"login\" type=\"submit\" value=\"Login!\"></td></tr>");
            out.println("</table>");
            out.println("</form>");
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