/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic;
import DataAccess.Entity.Authentication;
import DataAccess.DAO.AuthenticationDAO;
import java.io.Serializable ; 
/**
 *
 * @author arqsoft2017i
 */
public class Login implements Serializable { 
    public String login ( String document, String password ) { 
        AuthenticationDAO accountDAO = new AuthenticationDAO ( ) ; 
        Authentication accountE = accountDAO.searchUserLogin(document, password ) ; 
       
        if ( accountE != null ) 
            return "Welcome " + accountE. getIdUser(); 
        else 
            return "User not found" ; 
    } 
}
