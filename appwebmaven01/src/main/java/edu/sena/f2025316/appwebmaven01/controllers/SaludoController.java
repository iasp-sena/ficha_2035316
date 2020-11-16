/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ismael
 */
@Named//(value = "pepitoController")
@RequestScoped
public class SaludoController {
    
    private String nombre;

    public SaludoController() {
        nombre = "Pedrito";
    }

    public String getNombre() {
        System.out.println("Accedemos al valor...");
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void saludar(){
        System.out.println("Hola desde el controlador... " + nombre);
    }
    
}
