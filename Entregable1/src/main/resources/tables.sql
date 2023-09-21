DROP TABLE IF EXISTS client;
CREATE TABLE client(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(75) NOT NULL,
    lastname VARCHAR(75) NOT NULL,
    doc_number VARCHAR(11) UNIQUE NOT NULL
);

DROP TABLE IF EXISTS products;
CREATE TABLE products(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(50),
    code VARCHAR(50),
    stock INTEGER UNIQUE NOT NULL,
    price DOUBLE
);

DROP TABLE IF EXISTS invoice;
CREATE TABLE invoice(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    client_id INT NOT NULL,
    created_at DATE NOT NULL,
    total DOUBLE NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id)
);

DROP TABLE IF EXISTS invoice_details;
CREATE TABLE invoice_details(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    invoice_id INT NOT NULL,
    amount INT NOT NULL,
    product_id INT NOT NULL,
    price DOUBLE NOT NULL,
    FOREIGN KEY (invoice_id) REFERENCES invoice(id),
    FOREIGN KEY (product_id) REFERENCES products(id)

);



