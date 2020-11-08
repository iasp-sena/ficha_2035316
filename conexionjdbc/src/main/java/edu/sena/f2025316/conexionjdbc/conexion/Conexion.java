/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.conexion;

import edu.sena.f2025316.conexionjdbc.exepciones.ConexionExcpetion;
import edu.sena.f2025316.conexionjdbc.exepciones.enums.ConexionExcpetionEnum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ismael
 */
public class Conexion {

    private static Connection conexion;

    private Conexion() {

    }

    public static Connection getInstance() throws ConexionExcpetion {
        if (Objects.isNull(conexion)) {
            iniciarConexion();
        }
        return conexion;
    }

    private static void iniciarConexion() throws ConexionExcpetion {
        try {
            Properties propiedadesConexion = new Properties();
            propiedadesConexion.put("url", "jdbc:mysql://localhost:3307/ejemplo_crud");
            propiedadesConexion.put("user", "root");
            propiedadesConexion.put("password", "1234567890");
            conexion = DriverManager.getConnection(
                    propiedadesConexion.getProperty("url"),
                    propiedadesConexion);
        } catch (SQLException ex) {
            throw new ConexionExcpetion(ConexionExcpetionEnum.ERROR_CONEXION, ex);
        }
    }

}
