/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.nxtstayz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;
import com.example.nxtstayz.repository.*;

@Service
public class HotelJpaService implements HotelRepository {

    @Autowired
    private HotelJpaRepository hotelrepo;

    @Autowired
    private RoomJpaRepository roomrepo;

    @Override
    public ArrayList<Hotel> getHotels() {
        List<Hotel> list = hotelrepo.findAll();
        ArrayList<Hotel> arr = new ArrayList<>(list);
        return arr;
    }

    @Override
    public Hotel getHotelById(int hotelId) {
        try {
            Hotel hotel = hotelrepo.findById(hotelId).get();
            return hotel;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        hotelrepo.save(hotel);
        return hotel;
    }

    @Override
    public Hotel updateHotel(int hotelId, Hotel hotel) {
        try {
            Hotel hotels = hotelrepo.findById(hotelId).get();
            if (hotel.getHotelName() != null) {
                hotels.setHotelName(hotel.getHotelName());
            }
            if (hotel.getLocation() != null) {
                hotels.setLocation(hotel.getLocation());
            }
            if (hotel.getRating() != 0) {
                hotels.setRating(hotel.getRating());
            }
            hotelrepo.save(hotels);
            return hotels;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteHotel(int hotelId) {
        try {
            hotelrepo.deleteById(hotelId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public List<Room> getHotelRooms(int hotelId) {
        try {
            Hotel hotel = hotelrepo.findById(hotelId).get();
            return roomrepo.findByHotel(hotel);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}