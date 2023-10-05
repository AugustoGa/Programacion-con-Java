
CREATE TABLE `client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(75) NOT NULL,
  `lastname` VARCHAR(75) NOT NULL,
  `docNumber` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
  );


CREATE TABLE invoice(
  	id INT NOT NULL AUTO_INCREMENT,
      client_id INT NOT NULL,
      createdAt DATE NOT NULL,
      total DOUBLE NOT NULL,
      PRIMARY KEY (id),
      FOREIGN KEY (client_id) REFERENCES client(id)
  );


CREATE TABLE product(
  id INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(150) NOT NULL,
  `code` VARCHAR(50) NOT NULL,
  stock INT NOT NULL,
  price DOUBLE NOT NULL,
  PRIMARY KEY (id)
  );


CREATE TABLE invoice_detail (
      id INT NOT NULL AUTO_INCREMENT,
      invoice_id INT NOT NULL,
      amount INT NOT NULL,
      product_id INT NOT NULL,
      price DOUBLE NOT NULL,
      PRIMARY KEY (id),
      FOREIGN KEY (invoice_id) REFERENCES invoice(id),
      FOREIGN KEY (product_id) REFERENCES product(id)
  );