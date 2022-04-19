package com.una.api;

import com.una.api.controllers.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> h = new HashSet<>();
        h.add(HelloResource.class);
        h.add(CareerController.class);
        h.add(CourseController.class);
        h.add(CycleController.class);
        h.add(EnrollmentController.class);
        h.add(GroupController.class);
        h.add(ProfessorController.class);
        h.add(StudentController.class);
        return h;
    }
}