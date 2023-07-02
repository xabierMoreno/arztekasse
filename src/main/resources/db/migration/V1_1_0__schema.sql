DROP TABLE IF EXISTS TBL_EMPLOYEES;

CREATE TABLE STORE (
  store_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL
);

CREATE TABLE BUSINESS_HOURS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  day_of_week INT NOT NULL,
  start_time VARCHAR(250) NOT NULL,
  end_time VARCHAR(250) NOT NULL,
  store_id INT REFERENCES STORE(store_id)
);