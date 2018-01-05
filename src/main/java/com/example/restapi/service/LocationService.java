package com.example.restapi.service;

import com.example.restapi.model.Location;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class LocationService {

    public Map<Integer,Location> locationMap;
    public Location location1;
    @PostConstruct
    private void loadLocation(){
        location1 = new Location();
        location1.setNorth(10);
        location1.setSouth(20);
        location1.setEast(30);
        location1.setWest(40);

        locationMap= new HashMap<>();
        locationMap.put(1,location1);
    }


    public List<Location> getAllLocation(){
        List<Location> allLocations = locationMap.values().stream().collect(Collectors.toList());
        return allLocations;
    }

    public Location getlocation(Integer locationCode){
        return locationMap.get(locationCode);
    }

    public Location addLocation(Location location){
        locationMap.put((locationMap.size()+1),location);

        location.setNorth(999);
        return location;
    }

    public String deleteLocation(Integer locationCode){
        locationMap.remove(locationCode);
        return "remove successfully";
    }
    public String updateLocation(Integer locationCode, Location location){
        locationMap.put(locationCode, location);
        return "updated Successfully";

    }
}
