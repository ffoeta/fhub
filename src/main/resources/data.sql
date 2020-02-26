DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  firstname VARCHAR(250) DEFAULT NULL,
  lastname VARCHAR(250) DEFAULT NULL,
  email VARCHAR(250) DEFAULT NULL,
  phone VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO user (username, password, firstname, lastname, email, phone) VALUES
  ('aaa','123','Aliko', 'Dangote', 'a', '123'),
  ('bbb','234','Bill', 'Gates', 'a', '123'),
  ('ccc','345','Folrunsho', 'Alakija', 'a', '123');