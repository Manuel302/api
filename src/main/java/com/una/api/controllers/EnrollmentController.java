package com.una.api.controllers;

import com.una.api.models.Enrollment;
import com.una.api.services.EnrollmentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/enrollment")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnrollmentController {

    private final EnrollmentService enrollmentService = new EnrollmentService();

    @GET
    public List<Enrollment> getEnrollments(){
        return enrollmentService.getAll();
    }

    @GET
    @Path("/{group}/{student}")
    public Enrollment getEnrollment(@PathParam("group") int group, @PathParam("student") int student){
        return enrollmentService.get(group, student);
    }

    @POST
    public void addEnrollment(Enrollment enrollment){
        enrollmentService.post(enrollment);
    }

    @PUT
    @Path("/{group}/{student}")
    public void addEnrollment(@PathParam("group") int group, @PathParam("student") int student, Enrollment enrollment){
        enrollment.setGroup(group);
        enrollment.setStudent(student);
        enrollmentService.put(enrollment);
    }

    @DELETE
    @Path("/{group}/{student}")
    public void deleteEnrollment(@PathParam("group") int group, @PathParam("student") int student){
        enrollmentService.delete(group, student);
    }
}
