/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.facebook;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author dantas
 */
@WebServlet(name = "FacebookSocialNetworkingServiceCallback", urlPatterns = "/FacebookSocialNetworkingServiceCallback")
public class FacebookSocialNetworkingServiceCallback extends HttpServlet {

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
            String fb_session_key = request.getParameter("fb_sig_session_key");
            if (fb_session_key != null) {
                // use session key obtained from Facebook
                session.setAttribute("facebook_session_key", fb_session_key);
                //redirecting to application context path (application root)
                response.sendRedirect(request.getContextPath());
            }
            String authToken = request.getParameter("auth_token");
            if (authToken != null) {
                // auth_token obtained from Login servlet response
                // sent back to login method to get session key from Facebook, using auth_token
                session.setAttribute("facebook_auth_token", authToken);
                FacebookSocialNetworkingServiceAuthenticator.login(request, response);
            }
            String sessionKey = FacebookSocialNetworkingServiceAuthenticator.getSessionKey(request, response);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FacebookCallback</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FacebookCallback at " + request.getContextPath() + "</h1>");
            out.println("<p> Your Session Key is " + sessionKey + "</p>");
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
