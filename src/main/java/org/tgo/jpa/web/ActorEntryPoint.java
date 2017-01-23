package org.tgo.jpa.web;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tgo.jpa.services.ActorService;

@Path("/actor")
public class ActorEntryPoint {
    
    @EJB
    private ActorService actorService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getActors() {
        return Response.ok(actorService.getAllActors(), MediaType.APPLICATION_JSON).build();
    }

}
