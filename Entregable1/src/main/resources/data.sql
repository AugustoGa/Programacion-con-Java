-- Insertar datos en la tabla `client`
INSERT INTO client(name, lastname, doc_number)
VALUES
    ('Augusto', 'Pérez', '1111111111'),
    ('Santiago', 'López', '2222222222'),
    ('Mauri', 'González', '3333333333');

-- Insertar datos en la tabla `product`
INSERT INTO products(description, code, stock, price)
VALUES
    ('Producto 1', 'PROD001', 50, 25.99),
    ('Producto 2', 'PROD002', 30, 10.50),
    ('Producto 3', 'PROD003', 100, 5.75);


-- Insertar datos en la tabla `invoice`
INSERT INTO invoice(client_id, created_at, total)
VALUES
    (1, '2023-09-20', 100.50),
    (2, '2023-09-21', 75.20),
    (3, '2023-09-22', 200.75);


-- Insertar datos en la tabla `invoice_detail`
INSERT INTO invoice_details(invoice_id, amount, product_id, price)
VALUES
    (1, 2, 1, 25.99),
    (1, 3, 2, 10.50),
    (2, 1, 3, 5.75);