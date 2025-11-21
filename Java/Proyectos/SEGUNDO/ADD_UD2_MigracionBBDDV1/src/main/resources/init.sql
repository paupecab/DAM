-- BDD origen
DROP DATABASE IF EXISTS prac2;
CREATE DATABASE prac2;
USE prac2;

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    dni CHAR(9),
    fecha_registro DATE,
    credito DECIMAL(10,2),
    activo TINYINT(1)
);

-- BDD destino (V1)
DROP DATABASE IF EXISTS prac2migra;
CREATE DATABASE prac2migra;
USE prac2migra;

CREATE TABLE clientesmigra (
    id_migra INT PRIMARY KEY, -- ID original
    nombre_migra VARCHAR(100),
    dni_migra CHAR(9),
    credito_migra DECIMAL(10,2),
    migrado TINYINT(1) -- 1 = True
);