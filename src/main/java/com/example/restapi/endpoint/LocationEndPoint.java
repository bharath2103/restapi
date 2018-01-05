package com.example.restapi.endpoint;

import com.example.restapi.model.Location;
import com.example.restapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Component
@Path("/location")
public class LocationEndPoint {

    @Autowired
    public LocationService locationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Location> getAllLocation()
    {
        return locationService.getAllLocation();
    }




    @GET
    @Path("/{locationCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Location getLocationFromLocationCode(@PathParam("locationCode") Integer locationCode,
                                                @QueryParam("limit") int limit){
        return locationService.getlocation(locationCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Location addLocation(Location location){
        return locationService.addLocation(location);
    }

    @DELETE
    @Path("/{locationCode}")
    public String deleteLocationFromLocationCode(@PathParam("locationCode") Integer locationCode){
       return locationService.deleteLocation(locationCode);
    }

    @PUT
    @Path("/{locationCode}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateLocationFromLocationCode(@PathParam("locationCode") Integer locationCode,
                                                 Location location){
        return locationService.updateLocation(locationCode, location);
    }

}
