/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxtstayz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;
import com.example.nxtstayz.service.*;

@RestController
public class HotelController {
    @Autowired
    private HotelJpaService hotelservice;

    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        return hotelservice.getHotels();
    }

    @GetMapping("/hotels/{hotelId}")
    public Hotel getHotelById(@PathVariable("hotelId") int hotelId) {
        return hotelservice.getHotelById(hotelId);
    }

    @PostMapping("/hotels")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelservice.addHotel(hotel);
    }

    @PutMapping("/hotels/{hotelId}")
    public Hotel updateHotel(@PathVariable("hotelId") int hotelId, @RequestBody Hotel hotel) {
        return hotelservice.updateHotel(hotelId, hotel);
    }

    @DeleteMapping("/hotels/{hotelId}")
    public void deleteHotel(@PathVariable("hotelId") int hotelId) {
        hotelservice.deleteHotel(hotelId);
    }

    @GetMapping("/hotels/{hotelId}/rooms")
    public List<Room> getHotelRooms(@PathVariable("hotelId") int hotelId) {
        return hotelservice.getHotelRooms(hotelId);
    }

}
