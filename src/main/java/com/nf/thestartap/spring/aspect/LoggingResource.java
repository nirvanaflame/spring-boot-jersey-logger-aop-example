package com.nf.thestartap.spring.aspect;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Path("/logging/loggers")
@Component
public class LoggingResource {

    @Autowired
    LoggingService loggingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLoggers(@QueryParam("filter") String filter) {
        var loggers = loggingService.getLoggers(filter);
        return Response.ok(loggers).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setLogLevel(LoggerInfo loggerInfo) {
        loggingService.setLogLevel(loggerInfo);
        return Response.ok().build();
    }
}
