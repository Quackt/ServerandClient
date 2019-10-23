package com.example.demo.components;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public interface RestWebService {
    @GET
    @Path("/convert/{text}")
    @Produces({"text/xml"})
    public String convert(@PathParam(value = "text") String text);
}