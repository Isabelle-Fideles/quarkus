package usecase.Impl;

import dtos.PersonRequest;
import dtos.PersonResponse;
import entities.Email;
import entities.Person;
import usecase.PersonUseCase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PersonUseCaseImpl  implements PersonUseCase {

    public PersonResponse importPerson(PersonRequest personRequest){
        PersonResponse personResponse = new PersonResponse();
        Person personExistence = Person.findPersonByOriginPersonCode(personRequest.getOriginPersonCode());
        if (personExistence != null){
            personResponse.setPersonId(personExistence.getPersonKey().getPersonId());
            return personResponse;
        }
        Person person = new Person();
        person.setPersonName(personRequest.getPersonName());
        person.setPersonType(personRequest.getPersonType());
        person.setEmails(personRequest.getEmails());
        person.setOriginPersonCode(personRequest.getOriginPersonCode());
        Person.savePerson(person);
        saveEmail(person.getEmails(), person);
        personResponse.setPersonId(person.getPersonKey().getPersonId());
        return personResponse;
    }

    private void saveEmail(List<Email> emails, Person person ){
        for (Email email : emails){
            email.getEmailKey().setPersonId(person.getPersonKey().getPersonId());
            email.persist();
        }
    }

    public Person getPersonByOriginPersonCode(String OriginPerson){
       return Person.findPersonByOriginPersonCode(OriginPerson);
    }
}
