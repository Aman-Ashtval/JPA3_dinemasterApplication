CREATE TABLE restaurant (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR,
    address VARCHAR,
    cuisineType VARCHAR,
    rating INTEGER
);

CREATE TABLE chef (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR,
    lastName VARCHAR,
    expertise VARCHAR,
    experienceYears INTEGER,
    restaurantId INTEGER,
    FOREIGN KEY (restaurantId) REFERENCES restaurant(id)
);