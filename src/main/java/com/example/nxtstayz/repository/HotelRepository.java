/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.nxtstayz.repository;

import java.util.*;
import com.example.nxtstayz.model.*;

public interface HotelRepository {
    ArrayList<Hotel> getHotels();

    Hotel getHotelById(int hotelId);

    Hotel addHotel(Hotel hotel);

    Hotel updateHotel(int hotelId, Hotel hotel);

    void deleteHotel(int hotelId);

    List<Room> getHotelRooms(int hotelId);

}
