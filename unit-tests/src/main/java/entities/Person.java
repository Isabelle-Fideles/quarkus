package entities;

import entities.keys.PersonKey;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "person")
public class Person extends PanacheEntity implements Serializable {

    @EmbeddedId
    private PersonKey personKey;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Email> emails;

    @Column(nullable = true, length = 20)
    private String personName;

    @Column(nullable = true, length = 1)
    private String personType;

    @Column(nullable = false)
    private String originPersonCode;

    public String getOriginPersonCode() {
        return originPersonCode;
    }

    public void setOriginPersonCode(String originPersonCode) {
        this.originPersonCode = originPersonCode;
    }

    public PersonKey getPersonKey() {
        return personKey;
    }

    public void setPersonKey(PersonKey personId) {
        this.personKey = personId;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public static Person savePerson(Person person){
        person.persistAndFlush();
        return person;
    }

    public static Person findPersonByOriginPersonCode(String originPersonCode){
        Optional<Person> personOptional = find("originPersonCode", originPersonCode).singleResultOptional();
        return personOptional.orElse(null);
    }

    public static Person findPersonById(Integer personId){
        return find("personId", personId).firstResult();
    }

    public static long deletePersonById(Integer personId){
        return delete("personId", personId);
    }


}
