package dtos;

import entities.Email;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;

@RegisterForReflection
public class PersonRequest {
    private String personName;
    private String personType;
    private String originPersonCode;
    private List<Email> emails;

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

    public String getOriginPersonCode() {
        return originPersonCode;
    }

    public void setOriginPersonCode(String originPersonCode) {
        this.originPersonCode = originPersonCode;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

}
