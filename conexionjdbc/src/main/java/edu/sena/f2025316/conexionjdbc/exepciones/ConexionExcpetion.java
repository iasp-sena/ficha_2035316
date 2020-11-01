/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.exepciones;

import edu.sena.f2025316.conexionjdbc.exepciones.enums.ConexionExcpetionEnum;

/**
 *
 * @author Ismael
 */
public class ConexionExcpetion extends Exception {
    
    private ConexionExcpetionEnum tipo;

    public ConexionExcpetion(ConexionExcpetionEnum tipo) {
        super(tipo.getMensaje());
        this.tipo = tipo;
    }

    public ConexionExcpetion(ConexionExcpetionEnum tipo, Throwable thrwbl) {
        super(tipo.getMensaje(), thrwbl);
        this.tipo = tipo;
    }

    public ConexionExcpetionEnum getTipo() {
        return tipo;
    }
    
    
}
