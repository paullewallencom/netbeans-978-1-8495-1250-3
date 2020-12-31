package servlets;

import beans.CounterManufacturerEJB;
import beans.ManufacturerEJB;
import entities.Manufacturer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ManufacturerServlet", urlPatterns={"/ManufacturerServlet"})
public class ManufacturerServlet extends HttpServlet {
        CounterManufacturerEJB counterManufacturerEJB = lookupCounterManufacturerEJBBean();
        @EJB
        ManufacturerEJB manufacturerEJB;
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            List<Manufacturer> l = manufacturerEJB.findAll();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManufacturerServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<b>Number of times counter was accessed<b>  " + counterManufacturerEJB.counter() + "<br><br>" );
            for(int i = 0; i < 10; i++ )
                out.println("<b>City</b> " + l.get(i).getCity() + ", <b>State</b> " + l.get(i).getState() +"<br>" );
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
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private CounterManufacturerEJB lookupCounterManufacturerEJBBean() {
        try {
            Context c = new InitialContext();
            return (CounterManufacturerEJB) c.lookup("java:global/EJBApplication/CounterManufacturerEJB!beans.CounterManufacturerEJB");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
