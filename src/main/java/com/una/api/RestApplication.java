package com.una.api;

import com.una.api.controllers.CourseController;

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
        h.add(CourseController.class);
        return h;
    }
}