package com.ed.test;

import com.escueladigital.dao.UsuarioDAO;
import com.escueladigital.modelos.Usuario;

public class PruebaConexion {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.autenticar("alozada", "Clave123+");
        System.out.println("Nombre: "+usuario.nombre);
        System.out.println("Perfil: "+usuario.perfil);
    }
}
