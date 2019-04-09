package com.escueladigital.servlet;

import com.escueladigital.dao.UsuarioDAO;
import com.escueladigital.excepciones.ExcepcionGeneral;
import com.escueladigital.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Autenticar", urlPatterns = {"/Autenticar"})
public class Autenticar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //creamos y mantenemos una session en el cliente
        HttpSession sesion = request.getSession(true);
        //capturamos la informacion desde el cliente: usuario y clave
        String usuario = request.getParameter("usuario");
        String clave   = request.getParameter("clave");
        UsuarioDAO dao = new UsuarioDAO();
        
        try {
            Usuario user = dao.autenticar(usuario, clave);
            sesion.setAttribute("usuario", user);
            response.sendRedirect("compras.jsp");
        } catch (ExcepcionGeneral eg) {
            request.setAttribute("mensaje", eg.getMessage());
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
