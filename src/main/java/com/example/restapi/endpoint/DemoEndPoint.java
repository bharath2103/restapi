package com.example.restapi.endpoint;

import com.example.restapi.model.User;
import com.example.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Component
@Path("/users")
public class DemoEndPoint {

    @Autowired
    private UserService userService;

    @GET
    @Path("/sample")
    public String sampleMessage(){
        return "happyworld";
    }



    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getEventVersion1(@PathParam("id") String id) {
        return userService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUserThruPost(User user){
        return userService.addUserThruPost(user);
    }
}
