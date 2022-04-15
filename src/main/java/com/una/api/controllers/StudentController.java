package com.una.api.controllers;

import com.una.api.models.Student;
import com.una.api.services.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentController {

    private final StudentService studentService = new StudentService();

    @GET
    public List<Student> getStudents(){
        return studentService.getAll();
    }

    @GET
    @Path("/{id}")
    public Student getStudent(@PathParam("id") int id){
        return studentService.get(id);
    }
}
