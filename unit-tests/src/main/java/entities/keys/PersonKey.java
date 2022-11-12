package entities.keys;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class PersonKey implements Serializable {
    private static final long serialVersionUID = 7102989917525496325L;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Column(nullable = false)
    private Integer personId;
}
