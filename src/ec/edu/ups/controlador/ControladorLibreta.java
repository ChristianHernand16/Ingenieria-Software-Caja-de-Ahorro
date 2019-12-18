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
import ec.edu.ups.modelo.Libretas;

/**
 *
 * @author christian Hernandez
 * Vinicio Barzallo
 * Mario Torres
 * Edison Huinaizaca
 */
public class ControladorLibreta {

    EntityManager em;

    public ControladorLibreta() {
        em = MySQLDB.init();
    }

    public void Crear(Libretas u) {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Libretas> findAll() {
        Query query = em.createNamedQuery("Libretas.findAll");
        return query.getResultList();
    }

    public Libretas findByID(int id) {
        Libretas u = em.find(Libretas.class, id);
        if (u == null) {
            u = null;
        }
        return u;
    }

    public boolean eliminar(int id) {
        try {
            em.getTransaction().begin();
            Libretas u = em.find(Libretas.class, id);
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public boolean edit(Libretas u) {
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
