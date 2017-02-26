/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arqsoft2017i
 */
@Entity
@Table(name = "Authentication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authentication.findAll", query = "SELECT a FROM Authentication a")
    , @NamedQuery(name = "Authentication.findById", query = "SELECT a FROM Authentication a WHERE a.id = :id")
    , @NamedQuery(name = "Authentication.findByPassword", query = "SELECT a FROM Authentication a WHERE a.password = :password")
    , @NamedQuery(name = "Authentication.findByLastConnection", query = "SELECT a FROM Authentication a WHERE a.lastConnection = :lastConnection")
    , @NamedQuery(name = "Authentication.findByIdUser", query = "SELECT a FROM Authentication a WHERE a.idUser = :idUser")})
public class Authentication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LastConnection")
    private String lastConnection;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdUser")
    private Integer idUser;
    @JoinColumn(name = "IdUser", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public Authentication() {
    }

    public Authentication(Integer idUser) {
        this.idUser = idUser;
    }

    public Authentication(Integer idUser, int id, String password, String lastConnection) {
        this.idUser = idUser;
        this.id = id;
        this.password = password;
        this.lastConnection = lastConnection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection(String lastConnection) {
        this.lastConnection = lastConnection;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authentication)) {
            return false;
        }
        Authentication other = (Authentication) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.Authentication[ idUser=" + idUser + " ]";
    }
    
}
