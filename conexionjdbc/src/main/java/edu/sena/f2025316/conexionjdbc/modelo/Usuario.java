/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.conexionjdbc.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ismael
 */
@Entity
@Table(name = "tbl_usuarios")
public class Usuario implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "tipo_documento_id", nullable = false)
    private Integer tipoDocumentoId;
    
    @Column(name = "numero_documento", length = 45)
    private String documento;
    
    @Column(name = "nombres", length = 100, nullable = false)
    private String nombres;
    
    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;
    
    @Column(name = "nombre_usuario", length = 50, nullable = false)
    private String nombreUsuario;
    
    @Column(name = "clave", length = 45, nullable = false)
    private String clave;
    
    //<editor-fold defaultstate="collapsed" desc="Getters && Setters">
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(Integer tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

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
    
    //</editor-fold>

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", tipoDocumentoId=" + tipoDocumentoId + ", documento=" + documento + ", nombres=" + nombres + ", apellidos=" + apellidos + ", nombreUsuario=" + nombreUsuario + ", clave=" + clave + '}';
    }
    
    
}
