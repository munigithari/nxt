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
public class RoomController {
    @Autowired
    private RoomJpaService hotelservice;

    @GetMapping("/hotels/rooms")
    public List<Room> getRoomss() {
        return hotelservice.getRooms();
    }

    @GetMapping("/hotels/rooms/{roomId}")
    public Room getRoomById(@PathVariable("roomId") int roomId) {
        return hotelservice.getRoomById(roomId);
    }

    @PostMapping("/hotels/rooms")
    public Room addRoom(@RequestBody Room room) {
        return hotelservice.addRoom(room);
    }

    @PutMapping("/hotels/rooms/{roomId}")
    public Room updateRoom(@PathVariable("roomId") int roomId, @RequestBody Room room) {
        return hotelservice.updateRoom(roomId, room);
    }

    @DeleteMapping("/hotels/rooms/{roomId}")
    public void deleteRoom(@PathVariable("roomId") int roomId) {
        hotelservice.deleteRoom(roomId);
    }

    @GetMapping("/rooms/{roomId}/hotel")
    public Hotel getHotelRooms(@PathVariable("roomId") int roomId) {
        return hotelservice.getHotelRooms(roomId);
    }
}
