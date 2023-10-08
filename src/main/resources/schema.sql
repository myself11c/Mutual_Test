DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS
( user_id INT NOT NULL AUTO_INCREMENT,
  username varchar(25) NOT NULL,
  password varchar(60) NOT NULL
);



DROP TABLE IF EXISTS EMPLEADOS;
CREATE TABLE EMPLEADOS
(
     id_Empleado int AUTO_INCREMENT PRIMARY KEY,
     nombres varchar(30) NOT NULL,
     apellidos varchar(30) NOT NULL,
     sexo varchar(20) NOT NULL,
     edad int NOT NULL,
     correo varchar(30) NOT NULL
);

