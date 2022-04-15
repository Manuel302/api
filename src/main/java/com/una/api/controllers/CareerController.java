package com.una.api.controllers;

import com.una.api.models.Career;
import com.una.api.services.CareerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/career")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CareerController {

    private final CareerService careerService = new CareerService();

    @GET
    public List<Career> getCareers(){
        return careerService.getAll();
    }

    @GET
    @Path("/{id}")
    public Career getCareer(@PathParam("id") int id){
        return careerService.get(id);
    }
}
