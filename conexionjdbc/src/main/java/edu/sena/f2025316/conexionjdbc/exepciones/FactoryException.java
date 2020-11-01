/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.exepciones;

import edu.sena.f2025316.conexionjdbc.exepciones.enums.FactoryExcpetionEnum;

/**
 *
 * @author Ismael
 */
public class FactoryException extends Exception{
    
    private FactoryExcpetionEnum tipo;

    public FactoryException(FactoryExcpetionEnum tipo) {
        super(tipo.getMensaje());
        this.tipo = tipo;
    }

    public FactoryException(FactoryExcpetionEnum tipo, Throwable thrwbl) {
        super(tipo.getMensaje(), thrwbl);
        this.tipo = tipo;
    }

    public FactoryExcpetionEnum getTipo() {
        return tipo;
    }
    
}
