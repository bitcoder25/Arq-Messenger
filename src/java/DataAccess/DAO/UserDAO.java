/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author arqsoft2017i
 */
public class UserDAO {

    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("MessengerUN");
    public User persist(User account) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(account);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return account;
    }
    public User searchUser(String email, String password) {
           EntityManager em = emf1.createEntityManager();
           User account = null;
           String peticion = "select a from User a where a.email = " + email + " AND a.password = '"+password+"'";
           Query q = em.createQuery(peticion);
           try {
               account = (User) q.getSingleResult();
           } catch (Exception e){
           } finally {
               em.close();
               return account;
           }
}
}