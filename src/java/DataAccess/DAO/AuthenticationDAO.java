/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;
import DataAccess.Entity.Authentication;
import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author arqsoft2017i
 */
public class AuthenticationDAO {
    
    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("MessengerUNPU");
    
    public Authentication persist(Authentication account) {
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
    
    public Authentication searchByAuthenticationNumber(Long authenticationID) {
        EntityManager em = emf1.createEntityManager();
        Authentication authentication = null;
        
        try {
            authentication = em.find(Authentication.class, authenticationID);
        } catch (Exception e){
        } finally {
            em.close();
        }
        return authentication;
    }
    
    
    public Authentication searchByDocument(BigInteger document) {
        EntityManager em = emf1.createEntityManager();
        Authentication authentication = null;
        Query q = em.createNamedQuery("Authentication.findByIdUser");
        q.setParameter(1, document);
        try {
            authentication = (Authentication) q.getSingleResult();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return authentication;
    }

    public Authentication searchUserLogin(String email, String password) {
           EntityManager em = emf1.createEntityManager();
           Authentication account = null;
           String peticion = "select a from Authentication a INNER JOIN User ON User.ID=a.IdUser where User.email = " + email + " AND a.password = '"+password+"'";
           Query q = em.createQuery(peticion);
           try {
               account = (Authentication) q.getSingleResult();
           } catch (Exception e){
           } finally {
               em.close();
               return account;
           }
    }
}
