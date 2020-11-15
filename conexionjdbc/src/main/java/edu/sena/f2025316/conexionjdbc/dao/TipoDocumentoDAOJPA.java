/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.dao;

import edu.sena.f2025316.conexionjdbc.conexion.Conexion;
import static edu.sena.f2025316.conexionjdbc.dao.UsuarioDAOJPA.PU;
import edu.sena.f2025316.conexionjdbc.exepciones.ConexionExcpetion;
import edu.sena.f2025316.conexionjdbc.exepciones.enums.ConexionExcpetionEnum;
import edu.sena.f2025316.conexionjdbc.modelo.TipoDocumento;
import edu.sena.f2025316.conexionjdbc.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Ismael
 */
public class TipoDocumentoDAOJPA extends GenericDAO<TipoDocumento, Integer> implements TipoDocumentoDAO{
    
    public TipoDocumentoDAOJPA(){
        super(TipoDocumento.class);
    }
    
}
