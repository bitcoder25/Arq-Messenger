/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author arqsoft2017i
 */
@Embeddable
public class MessagePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdConversation")
    private int idConversation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdUser")
    private int idUser;

    public MessagePK() {
    }

    public MessagePK(int id, int idConversation, int idUser) {
        this.id = id;
        this.idConversation = idConversation;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdConversation() {
        return idConversation;
    }

    public void setIdConversation(int idConversation) {
        this.idConversation = idConversation;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) idConversation;
        hash += (int) idUser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MessagePK)) {
            return false;
        }
        MessagePK other = (MessagePK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.idConversation != other.idConversation) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataAccess.Entity.MessagePK[ id=" + id + ", idConversation=" + idConversation + ", idUser=" + idUser + " ]";
    }
    
}
