/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.controllers;

import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import edu.sena.f2025316.appwebmaven01.modelo.Operacion;
import edu.sena.f2025316.appwebmaven01.modelo.Rol;
import edu.sena.f2025316.appwebmaven01.modelo.RolOperacion;
import edu.sena.f2025316.appwebmaven01.modelo.Usuario;
import edu.sena.f2025316.appwebmaven01.modelo.UsuarioRol;
import edu.sena.f2025316.appwebmaven01.services.UsuarioService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ismael
 */
@Named
@SessionScoped
public class SessionController implements Serializable{
    
    @EJB
    private UsuarioService usuarioService;
    
    private String nombreUsuario;
    private String clave;
    
    private Usuario usuario;
    private List<Rol> rolesUsuario;
    private Integer rolActivoId;
    
    public String ingresar(){
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            usuario = usuarioService.consultarPorUsuarioYClave(nombreUsuario, clave);
            if(Objects.nonNull(usuario)){
                filtrarRolesHabiltadosUsuario();
                if(!rolesUsuario.isEmpty()){
                    rolActivoId = rolesUsuario.get(0).getId();
                } else{
                    usuario = null;
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sin rol asignado", "No se le ha asignado ningún para utilizar el sistema.");
                    fc.addMessage(null, message);
                }
                System.out.println(usuario.getNombres());
                return "index.xhtml?faces-redirect=true";
            } else{
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales invalidas", "Verifique su usuario y clave e intente nuevamente.");
                fc.addMessage(null, message);
            }
        } catch (ConexionExcpetion ex) {
            ex.printStackTrace();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getTipo().getMensaje());
            fc.addMessage(null, message);
        }
        return "";
    }
    
    public void salir() throws IOException{
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.invalidateSession();
        ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
    }
    
    public boolean sesionIniciada(){
        return Objects.nonNull(this.usuario);
    }
    
    public void validarSesion() throws IOException{
        if(!sesionIniciada()){
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
        }
    }
    
    public void cambiarRol(Rol rol){
        //this.rolActivo = rol;
    }
    
    private void filtrarRolesHabiltadosUsuario(){
        List<UsuarioRol> rolesUsuario = usuario.getRoles();
        this.rolesUsuario = new ArrayList<>();
        for(UsuarioRol ur : rolesUsuario){
            if(ur.getHabilitado()){
                this.rolesUsuario.add(ur.getRol());
            }
        }
        /*
        this.rolesUsuario = usuario.getRoles().stream()
                .filter(UsuarioRol::getHabilitado)
                .map(UsuarioRol::getRol)
                .collect(Collectors.toList())
                ;
        */
    }
    
    public List<Operacion> getOperacionesRol(){
        Rol rolSeleccionado = rolesUsuario.stream()
                .filter(r-> r.getId().equals(rolActivoId))
                .findFirst()
                .get();
        /*
        return rolSeleccionado.getOperaciones().stream()
                .filter(RolOperacion::getHabilitado)
                .map(RolOperacion::getOperacion)
                .collect(Collectors.toList())
                ;
        */
        List<Operacion> operaciones = new ArrayList<>();
        for(RolOperacion ro : rolSeleccionado.getOperaciones()){
            if(ro.getHabilitado()){
                operaciones.add(ro.getOperacion());
            }
        }
        return operaciones;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getClave() {
        return clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public List<Rol> getRolesUsuario() {
        return rolesUsuario;
    }

    public Integer getRolActivoId() {
        return rolActivoId;
    }

    public void setRolActivoId(Integer rolActivoId) {
        this.rolActivoId = rolActivoId;
    }
    //</editor-fold>
    
}
