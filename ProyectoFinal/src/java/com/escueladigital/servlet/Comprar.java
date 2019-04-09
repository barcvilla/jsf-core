package com.escueladigital.servlet;

import com.escueladigital.dao.CompraDAO;
import com.escueladigital.excepciones.ExcepcionGeneral;
import com.escueladigital.modelos.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Comprar", urlPatterns = {"/Comprar"})
public class Comprar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession();
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        CompraDAO compraDao = new CompraDAO();
        
        String proveedor = request.getParameter("proveedor");
        String producto  = request.getParameter("producto");
        String cantidad  = request.getParameter("cantidad");
        String valor     = request.getParameter("valor");
        
        short iProveedor = 0, iProducto = 0, iCantidad = 0, iValor = 0;
        try {
            iProveedor = Short.parseShort(proveedor);
            iProducto  = Short.parseShort(producto);
            iCantidad  = Short.parseShort(cantidad);
            iValor     = Short.parseShort(valor);
        } catch (NumberFormatException nfe) {
            request.setAttribute("mensaje__error", "No se puede convertir el dato solicitado.");
        }
        
        try {
            short idCompra = compraDao.comprar(iProveedor, iProducto, iCantidad, iValor, usuario.id_usuario);
            request.setAttribute("mensaje__exito", "La compra fue realizada con el id: "+idCompra);
        } catch (ExcepcionGeneral eg) {
            request.setAttribute("mensaje__error", eg.getMessage());
        }
        getServletContext().getRequestDispatcher("/compras.jsp").forward(request, response);
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
