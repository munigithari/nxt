create table if not exists hotel(
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(255),
   location VARCHAR(255),
   rating INT
);

create table if not exists room(
   id INT PRIMARY KEY AUTO_INCREMENT,
   roomnumber VARCHAR(255),
   type VARCHAR(255),
   price DOUBLE,
   hotelId INT,
   FOREIGN KEY (hotelId) REFERENCES hotel(id)
);