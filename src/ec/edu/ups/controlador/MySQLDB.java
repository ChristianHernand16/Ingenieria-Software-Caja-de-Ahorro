/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author christian Hernandez
 * Vinicio Barzallo
 * Mario Torres
 * Edison Huinaizaca
 */
public class MySQLDB {

    public static EntityManager conexion = null;

    public static EntityManager init() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CajaPU");
        MySQLDB.conexion = factory.createEntityManager();
        return conexion;
    }
}
