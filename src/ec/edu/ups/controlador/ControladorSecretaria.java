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
import ec.edu.ups.modelo.Secretaria;

/**
 *
 * @author christian Hernandez
 * Vinicio Barzallo
 * Mario Torres
 * Edison Huinaizaca
 */
public class ControladorSecretaria {

    EntityManager em;

    public ControladorSecretaria() {
        em = MySQLDB.init();
    }

    public void Crear(Secretaria u) {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Secretaria> findAll() {
        Query query = em.createNamedQuery("Secretaria.findAll");
        return query.getResultList();
    }

    public Secretaria findByID(int id) {
        Secretaria u = em.find(Secretaria.class, id);
        if (u == null) {
            u = null;
        }
        return u;
    }

    public boolean eliminar(int id) {
        try {
            em.getTransaction().begin();
            Secretaria u = em.find(Secretaria.class, id);
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public boolean edit(Secretaria u) {
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
