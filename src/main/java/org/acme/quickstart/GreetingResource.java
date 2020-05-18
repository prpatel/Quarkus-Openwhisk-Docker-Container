package org.acme.quickstart;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class GreetingResource {

    @Inject
    GreetingService service;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus";
    }

    @POST
    @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    public Response root() {
        System.out.println("/root");
        Message msg = new Message("hello root");
        return Response.ok(msg).build();
    }

    @GET
    @Path("/health_check")
    public Response healthCheck() {
        System.out.println("/health_check");
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello/greeting/{name}")
    public String greeting(@PathParam("name") String name) {
        return service.greeting(name);
    }


}
