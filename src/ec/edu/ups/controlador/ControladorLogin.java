/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ec.edu.ups.modelo.Persona;

/**
 *
 * @author vinic
 */
public class ControladorLogin {

    EntityManager em;

    public ControladorLogin() {
        em = MySQLDB.init();
    }

    public boolean loginUsuario(String cedula, String contra) {
        Query q = em.createQuery("SELECT u FROM Persona u WHERE u.cedula = '"+cedula+"' AND u.contracenia = '"+contra+"'");
        List<Persona> lis = q.getResultList();
        if(lis.size() == 1){
            System.out.println(lis.get(0).getNombre());
            return true;
        }
        return false;
    }
    
    public boolean loginSecretaria(String cedula, String contra) {
        Query q = em.createQuery("SELECT u FROM Persona u, Secretaria s WHERE u.cedula = '"+cedula+"' AND u.contracenia = '"+contra+"' AND u.idUsuario = s.idUsuario.idUsuario");
        List<Persona> lis = q.getResultList();
        if(lis.size() == 1){
            System.out.println(lis.get(0).getNombre());
            return true;
        }
        return false;
    }
    
     public boolean loginAdministrador(String cedula, String contra) {
        Query q = em.createQuery("SELECT u FROM Persona u, Administrador s WHERE u.cedula = '"+cedula+"' AND u.contracenia = '"+contra+"' AND u.idUsuario = s.idUsuario.idUsuario");
        List<Persona> lis = q.getResultList();
        if(lis.size() == 1){
            System.out.println(lis.get(0).getNombre());
            return true;
        }
        return false;
    }
}
