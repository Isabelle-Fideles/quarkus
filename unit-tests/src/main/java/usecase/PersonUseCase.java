package usecase;

import dtos.PersonRequest;
import dtos.PersonResponse;
import entities.Person;

public interface PersonUseCase {

    PersonResponse importPerson(PersonRequest personRequest);
    public Person getPersonByOriginPersonCode(String OriginPerson);

}
