/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.builder;

import edu.sena.f2025316.appwebmaven01.modelo.TipoDocumento;
import edu.sena.f2025316.appwebmaven01.modelo.Usuario;
/**
 *
 * @author Ismael
 */
public class UsuarioBuilder {
    
    private Usuario usuario;

    private UsuarioBuilder() {
        usuario = new Usuario();
    }
    
    public static UsuarioBuilder builder(){
        return new UsuarioBuilder();
    }
    
    public UsuarioBuilder id(Integer id){
        usuario.setId(id);
        return this;
    }
    
    public UsuarioBuilder tipoDocumentoId(Integer tipoDocumentoId){
        //usuario.setTipoDocumentoId(tipoDocumentoId);
        return this;
    }
    
    public UsuarioBuilder documento(String documento){
        usuario.setDocumento(documento);
        return this;
    }
    
    public UsuarioBuilder nombres(String nombres){
        usuario.setNombres(nombres);
        return this;
    }
    
    public UsuarioBuilder nombreUsuario(String nombreUsuario){
        usuario.setNombreUsuario(nombreUsuario);
        return this;
    }
    
    public UsuarioBuilder clave(String clave){
        usuario.setClave(clave);
        return this;
    }
    
    public UsuarioBuilder apellidos(String apellidos){
        usuario.setApellidos(apellidos);
        return this;
    }
    
    public UsuarioBuilder tipoDocumento(TipoDocumento tipoDocumento){
        usuario.setTipoDocumento(tipoDocumento);
        return this;
    }
    
    public Usuario build(){
        return usuario;
    }
    
}
