package com.una.api.controllers;

import com.una.api.models.Group;
import com.una.api.services.GroupService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/group")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GroupController {

    private final GroupService groupService = new GroupService();

    @GET
    public List<Group> getGroups(){
        return groupService.getAll();
    }

    @GET
    @Path("/{id}")
    public Group getGroup(@PathParam("id") int id){
        return groupService.get(id);
    }

    @POST
    public void addGroup(Group group){
        groupService.post(group);
    }

    @PUT
    @Path("/{id}")
    public void getGroup(@PathParam("id") int id, Group group){
        group.setId(id);
        groupService.put(group);
    }
}
