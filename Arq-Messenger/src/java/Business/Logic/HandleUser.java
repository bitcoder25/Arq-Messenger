package Business.Logic ; 
import DataAccess.DAO.UserDAO; 
import DataAccess.DAO.AuthenticationDAO;
import DataAccess.Entity.User ; 
import DataAccess.Entity.Authentication ; 

/**
 *
 * @author arqsoft2017i
 */ 
public class HandleUser { 
     
    public String createAccount ( String name, String passwordUser, String email ) { 
        User user = new User ( ) ; 
        Authentication authentication = new Authentication();
        user. setName ( name ) ; 
        user. setEmail ( email ) ; 
        authentication. setPassword (passwordUser);
         

        UserDAO userDAO = new UserDAO ( ) ; 
        AuthenticationDAO authenticationDAO = new AuthenticationDAO ( ) ; 
        Authentication authenticationE = authenticationDAO. persist (authentication) ; 
        
        User userE = userDAO. persist (user) ; 
        if ( userE != null && authenticationE !=null ) 
            return "la cuenta ha sido creada su Id de Usuario es " + user. getId ( ) + "." ; 
        else 
            return "la cuenta no pudo ser creada." ;  
    } 
    
    
    
}
   
