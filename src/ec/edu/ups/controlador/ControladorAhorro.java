/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import ec.edu.ups.modelo.Ahorro;

/**
 *
 * @author christian Hernandez
 * Vinicio Barzallo
 * Mario Torres
 * Edison Huinaizaca
 */
public class ControladorAhorro {

    EntityManager em;

    public ControladorAhorro() {
        em = MySQLDB.init();
    }

    public void Crear(Ahorro u) {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Ahorro> findAll() {
        Query query = em.createNamedQuery("Ahorro.findAll");
        return query.getResultList();
    }

    public Ahorro findByID(int id) {
        Ahorro u = em.find(Ahorro.class, id);
        if (u == null) {
            u = null;
        }
        return u;
    }
    
    

    public boolean eliminar(int id) {
        try {
            em.getTransaction().begin();
            Ahorro u = em.find(Ahorro.class, id);
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public boolean edit(Ahorro u) {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }
}
