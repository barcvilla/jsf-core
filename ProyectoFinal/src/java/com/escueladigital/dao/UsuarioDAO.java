package com.escueladigital.dao;

import com.escueladigital.excepciones.ExcepcionGeneral;
import com.escueladigital.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private static final Logger LOG = Logger.getLogger(UsuarioDAO.class.getName());
    // Llamamos a la funcion autenticacion
    private static final String CONSULTA  = "SELECT id_usuario, nombre, id_perfil, perfil FROM autenticacion(?,?)";
    
    public Usuario autenticar(String user, String password) throws ExcepcionGeneral {
        Usuario usuario = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultados = null;
        try {
            conexion = DAO.conectar();
            sentencia = conexion.prepareStatement(CONSULTA);
            sentencia.setString(1, user);
            sentencia.setString(2, password);
            resultados = sentencia.executeQuery();
            if (resultados.next()) {
                usuario = convertir(resultados);
            }
        } catch (SQLException sqle) {
            LOG.log(Level.SEVERE, "Error en UsuarioDAO: {0}", sqle.getMessage());
            throw new ExcepcionGeneral(sqle.getMessage());
        } finally {
            DAO.cerrar(conexion, sentencia, resultados);
        }
        return usuario;
    }
    
    private Usuario convertir(ResultSet rs) throws SQLException {
        Usuario usuario    = new Usuario();
        usuario.id_usuario = rs.getShort("id_usuario");
        usuario.nombre     = rs.getString("nombre");
        usuario.id_perfil  = rs.getShort("id_perfil");
        usuario.perfil     = rs.getString("perfil");
        return usuario;
    }
        
}
