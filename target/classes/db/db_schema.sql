CREATE TABLE customer (
  id INT NOT NULL IDENTITY,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  birth_date DATE NOT NULL,
  name_of_mother VARCHAR(45) NOT NULL,
  active INT NOT NULL,
  id_card_number VARCHAR(45) NOT NULL,
  gender VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE account (
  id INT NOT NULL IDENTITY,
  active INT NOT NULL,
  account_type VARCHAR(45) NOT NULL,
  account_number VARCHAR(45) NOT NULL,
  current_balance DOUBLE NOT NULL,
  customer_id INT NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE card (
  id INT NOT NULL IDENTITY,
  card_number VARCHAR(45) NOT NULL,
  card_type VARCHAR(45) NOT NULL,
  valid_to DATE NOT NULL,
  active INT NOT NULL,
  customer_id INT NOT NULL,
  account_id INT NOT NULL,
  PRIMARY KEY (id));
