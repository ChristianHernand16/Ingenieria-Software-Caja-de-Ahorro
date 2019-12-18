/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcela
 */
@Entity
@Table(name = "ahorro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ahorro.findAll", query = "SELECT a FROM Ahorro a")
    , @NamedQuery(name = "Ahorro.findByIdAhorro", query = "SELECT a FROM Ahorro a WHERE a.idAhorro = :idAhorro")
    , @NamedQuery(name = "Ahorro.findByFecha", query = "SELECT a FROM Ahorro a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Ahorro.findByCantidad", query = "SELECT a FROM Ahorro a WHERE a.cantidad = :cantidad")})
public class Ahorro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAhorro")
    private Integer idAhorro;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @JoinColumn(name = "idLibretas", referencedColumnName = "idLibretas")
    @ManyToOne(optional = false)
    private Libretas idLibretas;

    public Ahorro() {
    }

    public Ahorro(Integer idAhorro) {
        this.idAhorro = idAhorro;
    }

    public Ahorro(Integer idAhorro, Date fecha, BigDecimal cantidad, Libretas idLibretas) {
        this.idAhorro = idAhorro;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.idLibretas = idLibretas;
    }
    
    
    public Ahorro(Integer idAhorro, Date fecha, BigDecimal cantidad) {
        this.idAhorro = idAhorro;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public Integer getIdAhorro() {
        return idAhorro;
    }

    public void setIdAhorro(Integer idAhorro) {
        this.idAhorro = idAhorro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Libretas getIdLibretas() {
        return idLibretas;
    }

    public void setIdLibretas(Libretas idLibretas) {
        this.idLibretas = idLibretas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAhorro != null ? idAhorro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ahorro)) {
            return false;
        }
        Ahorro other = (Ahorro) object;
        if ((this.idAhorro == null && other.idAhorro != null) || (this.idAhorro != null && !this.idAhorro.equals(other.idAhorro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.modelo.Ahorro[ idAhorro=" + idAhorro + " ]";
    }
    
}
