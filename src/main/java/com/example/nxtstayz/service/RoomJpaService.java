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
public class RoomJpaService implements RoomRepository {

    @Autowired
    private HotelJpaRepository hotelrepo;

    @Autowired
    private RoomJpaRepository roomrepo;

    @Override
    public ArrayList<Room> getRooms() {
        List<Room> list = roomrepo.findAll();
        ArrayList<Room> arr = new ArrayList<>(list);
        return arr;
    }

    @Override
    public Room getRoomById(int roomId) {
        try {
            Room room = roomrepo.findById(roomId).get();
            return room;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Room addRoom(Room room) {
        Hotel hotel = room.getHotel();
        int hotelId = hotel.getHotelId();

        try {
            hotel = hotelrepo.findById(hotelId).get();
            room.setHotel(hotel);
            roomrepo.save(room);
            return room;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Room updateRoom(int roomId, Room room) {
        try {
            Room rooms = roomrepo.findById(roomId).get();
            if (room.getRoomNumber() != null) {
                rooms.setRoomNumber(room.getRoomNumber());
            }
            if (room.getRoomType() != null) {
                rooms.setRoomType(room.getRoomType());
            }
            if (room.getPrice() != 0) {
                rooms.setPrice(room.getPrice());
            }
            if (room.getHotel() != null) {
                int hotelId = room.getHotel().getHotelId();
                Hotel newHotel = hotelrepo.findById(hotelId).get();
                rooms.setHotel(newHotel);
            }
            return rooms;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteRoom(int roomId) {
        try {
            roomrepo.deleteById(roomId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Hotel getHotelRooms(int roomId) {
        try {
            Room room = roomrepo.findById(roomId).get();
            Hotel hotel = room.getHotel();
            return hotel;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}