/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcela
 */
@Entity
@Table(name = "libretas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libretas.findAll", query = "SELECT l FROM Libretas l")
    , @NamedQuery(name = "Libretas.findByIdLibretas", query = "SELECT l FROM Libretas l WHERE l.idLibretas = :idLibretas")
    , @NamedQuery(name = "Libretas.findByEstado", query = "SELECT l FROM Libretas l WHERE l.estado = :estado")
    , @NamedQuery(name = "Libretas.findByDescripcion", query = "SELECT l FROM Libretas l WHERE l.descripcion = :descripcion")
    , @NamedQuery(name = "Libretas.findByTotal", query = "SELECT l FROM Libretas l WHERE l.total = :total")})
public class Libretas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idLibretas")
    private Integer idLibretas;
    @Basic(optional = false)
    @Column(name = "estado")
    private short estado;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "total")
    private BigDecimal total;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Persona idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLibretas")
    private Collection<Ahorro> ahorroCollection;

    public Libretas() {
    }

    public Libretas(Integer idLibretas) {
        this.idLibretas = idLibretas;
    }

    public Libretas(Integer idLibretas, short estado, String descripcion, BigDecimal total) {
        this.idLibretas = idLibretas;
        this.estado = estado;
        this.descripcion = descripcion;
        this.total = total;
    }

    public Libretas(Integer idLibretas, short estado, String descripcion, BigDecimal total, Persona idUsuario) {
        this.idLibretas = idLibretas;
        this.estado = estado;
        this.descripcion = descripcion;
        this.total = total;
        this.idUsuario = idUsuario;
        this.ahorroCollection = ahorroCollection;
    }
    
    public Integer getIdLibretas() {
        return idLibretas;
    }

    public void setIdLibretas(Integer idLibretas) {
        this.idLibretas = idLibretas;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Persona getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Persona idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<Ahorro> getAhorroCollection() {
        return ahorroCollection;
    }

    public void setAhorroCollection(Collection<Ahorro> ahorroCollection) {
        this.ahorroCollection = ahorroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibretas != null ? idLibretas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libretas)) {
            return false;
        }
        Libretas other = (Libretas) object;
        if ((this.idLibretas == null && other.idLibretas != null) || (this.idLibretas != null && !this.idLibretas.equals(other.idLibretas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.modelo.Libretas[ idLibretas=" + idLibretas + " ]";
    }
    
}
