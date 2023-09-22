-- Insertar datos en la tabla `client`
INSERT INTO client (name, last_name, doc_number)
VALUES
    ('Augusto', 'Gallo', '1234567890'),
    ('Martin', 'Merlo', '0987654321'),
    ('Karina', 'González', '5678901234');

-- Insertar datos en la tabla `invoice`
INSERT INTO invoice (client_id, created_at, total)
VALUES
    (1, '2023-09-20', 100.50),
    (2, '2023-09-21', 75.20),
    (3, '2023-09-22', 200.75);

-- Insertar datos en la tabla `product`
INSERT INTO product (description, code, stock, price)
VALUES
    ('Producto 1', 'PROD0C1', 50, 225.99),
    ('Producto 2', 'PROD0C2', 10, 1500.50),
    ('Producto 3', 'PROD0C3', 100, 95.75);

-- Insertar datos en la tabla `invoice_detail`
INSERT INTO invoice_detail (invoice_id, amount, product_id, price)
VALUES
    (1, 2, 1, 25.99),
    (1, 3, 2, 10.50),
    (2, 1, 3, 5.75);