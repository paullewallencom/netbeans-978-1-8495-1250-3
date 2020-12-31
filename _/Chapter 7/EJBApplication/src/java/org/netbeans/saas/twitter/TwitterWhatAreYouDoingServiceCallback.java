/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.twitter;

import java.io.*;
import java.lang.reflect.Method;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author dantas
 */
@WebServlet(name = "TwitterWhatAreYouDoingServiceCallback", urlPatterns = "/TwitterWhatAreYouDoingServiceCallback")
public class TwitterWhatAreYouDoingServiceCallback extends HttpServlet {
    private static String CLASS_NAME = TwitterWhatAreYouDoingServiceCallback.class.getSimpleName();
    private static String AUTH_CLASS_NAME = CLASS_NAME.replace("Callback", "Authenticator");
    private static String ATTR_PREFIX = AUTH_CLASS_NAME.toLowerCase();
    private static String USERNAME_ATTR = ATTR_PREFIX + "_username";
    private static String PASSWORD_ATTR = ATTR_PREFIX + "_password";

    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
   
        session.setAttribute(USERNAME_ATTR, username);
        session.setAttribute(PASSWORD_ATTR, password);
        
        try {
            Class authClass = this.getClass().forName(this.getClass().getPackage().getName() + "." + AUTH_CLASS_NAME);
            Method m = authClass.getMethod("login", new Class[] {HttpServletRequest.class, HttpServletResponse.class});
            m.invoke(authClass, request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IOException(ex.getMessage());
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
