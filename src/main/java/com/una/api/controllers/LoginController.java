package com.una.api.controllers;

import com.una.api.models.User;
import com.una.api.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginController {

    private final UserService userService = new UserService();

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") int id){
        return userService.get(id);
    }
}
