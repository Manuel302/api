package com.una.api.controllers;

import com.una.api.models.Cycle;
import com.una.api.services.CycleService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cycle")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CycleController {

    private final CycleService cycleService = new CycleService();

    @GET
    public List<Cycle> getCycles(){
        return cycleService.getAll();
    }

    @GET
    @Path("/{id}")
    public Cycle getCycle(@PathParam("id") int id){
        return cycleService.get(id);
    }
}
