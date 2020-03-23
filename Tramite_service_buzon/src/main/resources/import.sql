
-- CATALOGO --
INSERT INTO tipo_buzon (nombre) VALUES ('PERSONAL')
INSERT INTO tipo_buzon (nombre) VALUES ('GENÉRICO')

-- IMPORT --


INSERT INTO buzon(nombre,codigo_ubicacion,tipo_buzon_id) VALUES('ADMINISTRADOR','C000052',1);
INSERT INTO buzon(nombre,codigo_ubicacion,tipo_buzon_id) VALUES('Javier Gonzales','C000052',1);
INSERT INTO buzon(nombre,codigo_ubicacion,tipo_buzon_id) VALUES('Mario Carrasco','C000053',1);
INSERT INTO buzon(nombre,codigo_ubicacion,tipo_buzon_id) VALUES('Sergio Ramos','C000054',1);
INSERT INTO buzon(nombre,codigo_ubicacion,tipo_buzon_id) VALUES('Andrea Soto','C000055',1);
INSERT INTO buzon(nombre,codigo_ubicacion,tipo_buzon_id) VALUES('Luis Flores','C000056',1);
INSERT INTO buzon(nombre,codigo_ubicacion,tipo_buzon_id) VALUES('Katty Robles','C000057',1);
INSERT INTO buzon(nombre,codigo_ubicacion,tipo_buzon_id) VALUES('Eduardo Huaman','C000058',1);


INSERT INTO buzon_usuario(usuario_id,buzon_id) VALUES(1,1);
INSERT INTO buzon_usuario(usuario_id,buzon_id) VALUES(2,2);
INSERT INTO buzon_usuario(usuario_id,buzon_id) VALUES(3,3);
INSERT INTO buzon_usuario(usuario_id,buzon_id) VALUES(4,4);
INSERT INTO buzon_usuario(usuario_id,buzon_id) VALUES(5,5);
INSERT INTO buzon_usuario(usuario_id,buzon_id) VALUES(6,6);
INSERT INTO buzon_usuario(usuario_id,buzon_id) VALUES(7,7);
INSERT INTO buzon_usuario(usuario_id,buzon_id) VALUES(8,8);

