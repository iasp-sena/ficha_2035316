/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc;

import edu.sena.f2025316.conexionjdbc.dao.UsuarioDAO;
import edu.sena.f2025316.conexionjdbc.dao.fabricas.Factory;
import edu.sena.f2025316.conexionjdbc.dao.fabricas.FactoryDAO;
import edu.sena.f2025316.conexionjdbc.exepciones.ConexionExcpetion;
import edu.sena.f2025316.conexionjdbc.exepciones.FactoryException;
import edu.sena.f2025316.conexionjdbc.modelo.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.sena.f2025316.conexionjdbc.dao.TipoDocumentoDAO;
import edu.sena.f2025316.conexionjdbc.modelo.TipoDocumento;
import java.util.List;

/**
 *
 * @author Ismael
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            FactoryDAO factoryDAO = Factory.getFactoryDAO();
            UsuarioDAO uDAO = factoryDAO.getUsuarioDAO();
            TipoDocumentoDAO tdDAO = factoryDAO.getTipoDocumentoDAO();
            
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
            uDAO.registrar(ur);
            */
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            //Consultar por id
            Usuario u = uDAO.consultarPorId(2);
            System.out.println(String.format("Id: %d - Nombre: %s - Apellidos: %s",
                    u.getId(), u.getNombres(), u.getApellidos()));
            System.out.println("Todo bien....");
            
            TipoDocumento td = tdDAO.consultarPorId(2);
            System.out.println(td);
            
            //System.out.println(u.getTipoDocumento().getCodigo());
            
            
            List<Usuario> us = uDAO.consultarTodos();
            List<TipoDocumento> tds = tdDAO.consultarTodos();
            
            System.out.println("############################ USUARIOS ##################################");
            us.forEach(System.out::println);
            
            
            System.out.println("############################ TD ##################################");
            tds.forEach(System.out::println);
            
            
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
