/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.data.jpa.repository.JpaRepository;
 * import org.springframework.stereotype.Repository;
 * 
 */

// Write your code here
package com.example.nxtstayz.repository;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface HotelJpaRepository extends JpaRepository<Hotel, Integer> {

}