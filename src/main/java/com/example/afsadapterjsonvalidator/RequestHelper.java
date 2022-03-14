package com.example.afsadapterjsonvalidator;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/help")
public class RequestHelper {
    ObjectMapper objectMapper = new ObjectMapper();
    private static WebTarget afsTarget = ClientBuilder.newClient()
            .target("http://localhost:8080/AfsAdapterJsonValidator-1.0-SNAPSHOT/api/afs_adapter");

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void help() {
        System.out.println("Start RequestHelper");
        String response = afsTarget.request().get(String.class);
        System.out.println("End RequestHelper");
    }

}
