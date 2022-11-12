package controllers;


import dtos.PersonRequest;
import dtos.PersonResponse;
import entities.Person;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.jboss.resteasy.reactive.RestResponse;
import usecase.PersonUseCase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/person")
public class ClientController {

    @Inject
    PersonUseCase personUseCase;


    @POST
    @Path("/importPerson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<PersonResponse> importPerson(@RequestBody PersonRequest personRequest){
        return RestResponse.ok(personUseCase.importPerson(personRequest));
    }

    @GET
    @Path("/{originPerson}")
    public RestResponse<Person> getPerson( String originPerson){
        return RestResponse.ok(personUseCase.getPersonByOriginPersonCode(originPerson));
    }


}
