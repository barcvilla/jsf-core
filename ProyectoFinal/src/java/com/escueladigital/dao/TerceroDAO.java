package com.escueladigital.dao;

import com.escueladigital.modelos.Tercero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.List;
import java.util.logging.Level;

public class TerceroDAO {

    private static final Logger LOG = Logger.getLogger(TerceroDAO.class.getName());
    private final String CONSULTA = "SELECT id_tercero, nombre FROM consulta_terceros()";
    
    public List<Tercero> listar() {
        List<Tercero> listado = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DAO.conectar();
            ps = con.prepareStatement(CONSULTA);
            rs = ps.executeQuery();
            while (rs.next()) {
                listado.add(convertir(rs));
            }
        } catch (SQLException sqle) {
            LOG.log(Level.SEVERE, "Error en TerceroDAO: {0}", sqle.getMessage());
        } finally {
            DAO.cerrar(con, ps, rs);
        }
        return listado;
    }
    
    private Tercero convertir(ResultSet rs) throws SQLException{
        Tercero tercero = new Tercero();
        tercero.id_tercero = rs.getShort(1);
        tercero.nombre = rs.getString(2);
        return tercero;
    }
}
