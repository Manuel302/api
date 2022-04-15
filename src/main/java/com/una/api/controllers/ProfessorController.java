package com.una.api.controllers;

import com.una.api.models.Professor;
import com.una.api.services.ProfessorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/professor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorController {

    private final ProfessorService professorService = new ProfessorService();

    @GET
    public List<Professor> getProfessors(){
        return professorService.getAll();
    }

    @GET
    @Path("/{id}")
    public Professor getProfessor(@PathParam("id") int id){
        return professorService.get(id);
    }
}
