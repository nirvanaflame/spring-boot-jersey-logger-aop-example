package com.nf.thestartap.spring.common;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

@Path("/")
@Component
public class HelloWorldResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String say() {
        return "Hello, World!";
    }
}
