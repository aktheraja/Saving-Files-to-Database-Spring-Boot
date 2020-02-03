
CREATE TABLE  IF NOT EXISTS students(
    ID SERIAL NOT NULL PRIMARY KEY,
    first_name CHAR (100) NOT NULL,
    last_name CHAR (100) NOT NULL,
    username CHAR(100) NOT NULL UNIQUE,
    email CHAR(100) NOT NULL,
    city CHAR(100) NOT NULL,
    state CHAR(100) NOT NULL,
    zip CHAR (100) NOT NULL,
    photo CHAR(500)
);