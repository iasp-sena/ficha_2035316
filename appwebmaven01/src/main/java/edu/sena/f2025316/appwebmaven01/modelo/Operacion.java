/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ismael
 */
@Entity
@Table(name = "tbl_operaciones")
@NamedQueries({
    @NamedQuery(name = "Operacion.findAll", query = "SELECT o FROM Operacion o"),
    @NamedQuery(name = "Operacion.findById", query = "SELECT o FROM Operacion o WHERE o.id = :id"),
    @NamedQuery(name = "Operacion.findByNombre", query = "SELECT o FROM Operacion o WHERE o.nombre = :nombre"),
    @NamedQuery(name = "Operacion.findByIcono", query = "SELECT o FROM Operacion o WHERE o.icono = :icono")})
public class Operacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "icono")
    private String icono;
    @Lob
    @Size(max = 65535)
    @Column(name = "link")
    private String link;
    @OneToMany(mappedBy = "operacionSuperior", fetch = FetchType.LAZY)
    private List<Operacion> subOperaciones;
    @JoinColumn(name = "tbl_operacion_superior_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Operacion operacionSuperior;

    public Operacion() {
    }

    public Operacion(Integer id) {
        this.id = id;
    }

    public Operacion(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Operacion> getSubOperaciones() {
        return subOperaciones;
    }

    public void setSubOperaciones(List<Operacion> subOperaciones) {
        this.subOperaciones = subOperaciones;
    }

    public Operacion getOperacionSuperior() {
        return operacionSuperior;
    }

    public void setOperacionSuperior(Operacion operacionSuperior) {
        this.operacionSuperior = operacionSuperior;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operacion)) {
            return false;
        }
        Operacion other = (Operacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.f2025316.appwebmaven01.modelo.Operacion[ id=" + id + " ]";
    }
    
}
