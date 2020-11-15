/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc;

import edu.sena.f2025316.conexionjdbc.conexion.Conexion;
import edu.sena.f2025316.conexionjdbc.dao.ProductoDAO;
import edu.sena.f2025316.conexionjdbc.dao.UsuarioDAO;
import edu.sena.f2025316.conexionjdbc.dao.UsuarioDAOMySql;
import edu.sena.f2025316.conexionjdbc.dao.UsuarioDAOPostgreSQL;
import edu.sena.f2025316.conexionjdbc.dao.fabricas.Factory;
import edu.sena.f2025316.conexionjdbc.dao.fabricas.FactoryDAO;
import edu.sena.f2025316.conexionjdbc.dao.fabricas.FactoryDAOMySQL;
import edu.sena.f2025316.conexionjdbc.exepciones.ConexionExcpetion;
import edu.sena.f2025316.conexionjdbc.exepciones.FactoryException;
import edu.sena.f2025316.conexionjdbc.modelo.Usuario;
import edu.sena.f2025316.conexionjdbc.modelo.builders.UsuarioBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ismael
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            FactoryDAO factoryDAO = Factory.getFactoryDAO();
            UsuarioDAO uDao = factoryDAO.getUsuarioDAO();
            ProductoDAO pDAO = factoryDAO.getProductoDAO();
            
            /*
            //Registrar
            Usuario ur = UsuarioBuilder.builder()
                    .tipoDocumentoId(1)
                    .documento("2222222222")
                    .nombres("Pepito")
                    .apellidos("Perez")
                    .nombreUsuario("pepito")
                    .clave("1234")
                    .build();
            uDao.registrar(ur);
            */
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            //Consultar por id
            Usuario u = uDao.consultarPorId(2);
            System.out.println(String.format("Id: %d - Nombre: %s - Apellidos: %s",
                    u.getId(), u.getNombres(), u.getApellidos()));
            System.out.println("Todo bien....");
            
            System.out.println(u.getTipoDocumento().getCodigo());
            
        } catch (ConexionExcpetion ex) {
            System.out.println(ex.getTipo().getCodigo() + ex.getTipo().getMensaje());
            ex.printStackTrace();
        } catch (FactoryException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            System.out.println("Esto siempre se ejecuta....");
        }
    }
}
