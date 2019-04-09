<%@page import="com.escueladigital.modelos.Tercero"%>
<%@page import="com.escueladigital.dao.TerceroDAO"%>
<%@page import="com.escueladigital.modelos.Producto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.escueladigital.dao.ProductoDAO"%>
<%@page import="com.escueladigital.modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuario = null;
    if (session.getAttribute("usuario") != null) {
        usuario = (Usuario) session.getAttribute("usuario");
    } else {
        response.sendRedirect("index.jsp");
    }
    
    String mensaje__error = null, mensaje__exito = null;
    
    if (request.getAttribute("mensaje__error") != null) {
        mensaje__error = (String) request.getAttribute("mensaje__error");
    }
    if (request.getAttribute("mensaje__exito") != null) {
        mensaje__exito = (String) request.getAttribute("mensaje__exito");
    }
    
    ProductoDAO productoDAO = new ProductoDAO();
    List<Producto> productos = new ArrayList<Producto>();
    productos = productoDAO.listar();

    TerceroDAO terceroDAO = new TerceroDAO();
    List<Tercero> terceros = new ArrayList<Tercero>();
    terceros = terceroDAO.listar();
%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimun-scale=1.0"/>
    <link rel="stylesheet" href="css/estilos.css"/>
    <link href="https://file.myfontastic.com/gVhWFfTbY55yVaY7oxJaF3/icons.css" rel="stylesheet"/>
    <title>Ventas</title>
  </head>
  <body class="ventas">
    <div class="main-container">
      <aside class="main-aside"><a href="/"><img src="img/logo.png" class="logo"/></a>
        <ul class="menu ed-menu">
          <li class="menu__item"><a href="compras.jsp" class="menu__link icon-compras">Compras</a></li>
          <li class="menu__item"><a href="ventas.jsp" class="menu__link icon-ventas">Ventas</a></li>
          <li class="menu__item"><a href="lista-compras.jsp" class="menu__link icon-lista-compras">Lista de compras</a></li>
          <li class="menu__item"><a href="lista-ventas.jsp" class="menu__link icon-lista-ventas">Lista de ventas</a></li>
          <li class="menu__item"><a href="lista-productos.jsp" class="menu__link icon-lista-productos">Lista de productos</a></li>
        </ul>
      </aside>
      <main class="main-content">
        <div class="usuario__sistema">Bienvenido 
            <%
                if (usuario != null) {
                    out.print(usuario.nombre);
                }
            %>
        </div>
        <h1>Ventas</h1>
        <form action="Vender" method="post">
          <div class="form-item ed-container">
            <div class="ed-item base-30">
              <label for="cliente">Cliente</label>
            </div>
            <div class="ed-item base-70">
              <select name="cliente" id="cliente">
                <%
                    for (Tercero tercero : terceros) {
                        out.println("<option value=\"" + tercero.id_tercero + "\">" + tercero.nombre + "</option>");
                    }
                %>
              </select>
            </div>
          </div>
          <div class="form-item ed-container">
            <div class="ed-item base-30">
              <label for="producto">Producto</label>
            </div>
            <div class="ed-item base-70">
              <select name="producto" id="producto">
                <%
                    for (Producto producto : productos) {
                        out.println("<option value=\"" + producto.id_producto + "\">" + producto.nombre + "</option>");
                    }
                %>
              </select>
            </div>
          </div>
          <div class="form-item ed-container">
            <div class="ed-item base-30">
              <label for="cantidad">Cantidad</label>
            </div>
            <div class="ed-item base-70">
              <input type="number" id="cantidad" name="cantidad"/>
            </div>
          </div>
          <div class="ed-container">
            <div class="ed-item">
              <input type="submit" value="vender"/>
            </div>
          </div>
            <div class="ed-container">
                <div clas="ed-item">
                    <%
                        if (mensaje__error != null) {
                            out.println("<div class=\"mensaje__error\">"+mensaje__error+"</div>");
                        }
                        if (mensaje__exito != null) {
                            out.println("<div class=\"mensaje__exito\">"+mensaje__exito+"</div>");
                        }
                    %>
                </div>
            </div>
        </form>
      </main>
    </div>
    <script src="js/efectos.js"></script>
  </body>
</html>