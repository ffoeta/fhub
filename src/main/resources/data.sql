DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  firstname VARCHAR(250) DEFAULT NULL,
  lastname VARCHAR(250) DEFAULT NULL,
  email VARCHAR(250) DEFAULT NULL
);
 
-- INSERT INTO user (username, password, firstname) VALUES
--   ('user','123','Aliko', 'Dangote', 'a', '123')