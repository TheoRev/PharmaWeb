/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrevfdz.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lheo2
 */
@Entity
@Table(name = "suppliers", catalog = "farmasur", schema = "pharmacy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suppliers.findAll", query = "SELECT s FROM Suppliers s")
    , @NamedQuery(name = "Suppliers.findByCodigo", query = "SELECT s FROM Suppliers s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "Suppliers.findByNombre", query = "SELECT s FROM Suppliers s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Suppliers.findByEncargado", query = "SELECT s FROM Suppliers s WHERE s.encargado = :encargado")
    , @NamedQuery(name = "Suppliers.findByTelefono", query = "SELECT s FROM Suppliers s WHERE s.telefono = :telefono")
    , @NamedQuery(name = "Suppliers.findByEmail", query = "SELECT s FROM Suppliers s WHERE s.email = :email")})
public class Suppliers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "encargado")
    private String encargado;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "codSupplier")
    private List<Laboratory> laboratoryList;

    public Suppliers() {
    }

    public Suppliers(Integer codigo) {
        this.codigo = codigo;
    }

    public Suppliers(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Laboratory> getLaboratoryList() {
        return laboratoryList;
    }

    public void setLaboratoryList(List<Laboratory> laboratoryList) {
        this.laboratoryList = laboratoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suppliers)) {
            return false;
        }
        Suppliers other = (Suppliers) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hrevfdz.models.Suppliers[ codigo=" + codigo + " ]";
    }
    
}
