package com.una.api.controllers;

import com.una.api.models.Course;
import com.una.api.services.CourseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/course")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CourseController {

    private final CourseService courseService = new CourseService();

    @GET
    public List<Course> getCourses(){
        return courseService.getAll();
    }

    @GET
    @Path("/{id}")
    public Course getCourse(@PathParam("id") Long id){
        return courseService.get(id);
    }
}
