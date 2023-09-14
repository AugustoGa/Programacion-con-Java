
CREATE TABLE Clientes (
	nombre VARCHAR(150) NOT NULL,
	apellido VARCHAR(150) NOT NULL,
  	dni INT PRIMARY KEY NOT NULL,
  	edad INT NOT NULL,
);

INSERT INTO Clientes (nombre , apellido, dni, edad) VALUES('Augusto', 'Gallo', 123456789, 21),
('Juan', 'Perez', 123456712, 39),
('Marcelo', 'Merlo', 123456734, 40),
('Luis', 'Cabrera', 123456756, 50);

SELECT * FROM Clientes;

//Clientes con cantidad igual a 25 anios
SELECT * FROM Clientes WHERE edad <= 25;

//Clientes entre 35 y 45 anios
SELECT * FROM Clientes WHERE edad BETWEEN 35 AND 45;


