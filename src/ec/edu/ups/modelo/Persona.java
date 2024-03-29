/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author christian Hernandez
 * Vinicio Barzallo
 * Mario Torres
 * Edison Huinaizaca
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Persona u")
    , @NamedQuery(name = "Usuario.findAproSI", query = "SELECT u FROM Persona u WHERE u.prestamo = 'SI' ")
    , @NamedQuery(name = "Usuario.findAproNO", query = "SELECT u FROM Persona u WHERE u.prestamo = 'NO' ")
    , @NamedQuery(name = "Usuario.findSecre", query = "SELECT t1 FROM Persona t1 WHERE NOT EXISTS (SELECT NULL FROM Secretaria t2 WHERE t2.idUsuario.idUsuario = t1.idUsuario)")
    , @NamedQuery(name = "Usuario.findAdmin", query = "SELECT t1 FROM Persona t1 WHERE NOT EXISTS (SELECT NULL FROM Administrador t2 WHERE t2.idUsuario.idUsuario = t1.idUsuario)")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Persona u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByCedula2", query = "SELECT u FROM Persona u WHERE u.prestamo = 'SI' and u.cedula = :cedula")
    , @NamedQuery(name = "Usuario.findByCedula", query = "SELECT u FROM Persona u WHERE u.cedula = :cedula")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Persona u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Persona u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Persona u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Persona u WHERE u.direccion = :direccion")
    , @NamedQuery(name = "Usuario.findByContracenia", query = "SELECT u FROM Persona u WHERE u.contracenia = :contracenia")
    , @NamedQuery(name = "Usuario.findByPrestamo", query = "SELECT u FROM Persona u WHERE u.prestamo = :prestamo")})
public class Persona implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Administrador> administradorCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "contracenia")
    private String contracenia;
    @Column(name = "prestamo")
    private String prestamo;
    @Column(name = "motivo")
    private String motivo;

    public Persona() {
    }

    public Persona(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Persona(Integer idUsuario, String cedula, String nombre, String apellido, String telefono, String direccion, String contracenia, String prestamo, String motivo) {
        this.idUsuario = idUsuario;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contracenia = contracenia;
        this.prestamo = prestamo;
        this.motivo = motivo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContracenia() {
        return contracenia;
    }

    public void setContracenia(String contracenia) {
        this.contracenia = contracenia;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Usuario[ idUsuario=" + idUsuario + " ]";
    }

    @XmlTransient
    public Collection<Administrador> getAdministradorCollection() {
        return administradorCollection;
    }

    public void setAdministradorCollection(Collection<Administrador> administradorCollection) {
        this.administradorCollection = administradorCollection;
    }

}
