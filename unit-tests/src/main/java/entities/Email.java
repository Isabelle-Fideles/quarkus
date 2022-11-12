package entities;

import entities.keys.EmailKey;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "email")
public class Email extends PanacheEntity implements Serializable {

     @EmbeddedId
     private EmailKey emailKey;

    public EmailKey getEmailKey() {
        return emailKey;
    }

    public void setEmailKey(EmailKey emailKey) {
        this.emailKey = emailKey;
    }

    public static List<Email> findEmailByPersonId(Integer personId){
        return find("personId", personId).list();
    }
}
