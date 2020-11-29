/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.controllers;

import edu.sena.f2025316.appwebmaven01.builder.UsuarioBuilder;
import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import edu.sena.f2025316.appwebmaven01.filtros.FiltroUsuario;
import edu.sena.f2025316.appwebmaven01.modelo.Usuario;
import edu.sena.f2025316.appwebmaven01.services.UsuarioService;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author ismael
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioService usuarioService;

    private Usuario usuario;
    private List<Usuario> usuarios;
    private FiltroUsuario filtro;

    public UsuarioController() {

    }

    @PostConstruct
    public void init() {
        usuario = UsuarioBuilder.builder()
                .tipoDocumentoId(null)
                .municipioId(null)
                .build();
        filtro = new FiltroUsuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public FiltroUsuario getFiltro() {
        return filtro;
    }

    public void setFiltro(FiltroUsuario filtro) {
        this.filtro = filtro;
    }
    

    public List<Usuario> getUsuarios() {
        try {
            if (Objects.isNull(usuarios)) {
                usuarios = usuarioService.consultaTodos();
            }
        } catch (ConexionExcpetion ex) {
            System.out.println("Error al consultar los usuarios.....");
            ex.printStackTrace();
        }
        return usuarios;
    }

    public void registrar() {
        try {
            System.out.println("Vamos a registrar el usuario...");
            System.out.println(usuario);
            usuarioService.registrar(usuario);
            init();
        } catch (ConexionExcpetion ex) {
            System.out.println("Error al registrar usuario");
            ex.printStackTrace();
        }
    }
    
    public void filtrar(){
        try {
            usuarios = usuarioService.buscarPorFiltro(filtro);
        } catch (ConexionExcpetion ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
