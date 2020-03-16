

INSERT INTO tipo_buzon (nombre) VALUES ('PERSONAL')
INSERT INTO tipo_buzon (nombre) VALUES ('GENÉRICO')


INSERT INTO buzon (nombre, ubicacion_id, ubicacion_nombre, tipo_buzon_id) VALUES ('ADMINISTRADOR', 1, 'AREA ADMINISTRADOR', 1)
INSERT INTO buzon (nombre, ubicacion_id, ubicacion_nombre, tipo_buzon_id) VALUES ('PROGRAMADOR', 1, 'AREA TI', 1)
INSERT INTO buzon (nombre, ubicacion_id, ubicacion_nombre, tipo_buzon_id) VALUES ('ANALISTA', 2, 'PROYECTOS', 1)
INSERT INTO buzon (nombre, ubicacion_id, ubicacion_nombre, tipo_buzon_id) VALUES ('TI', 2, 'AREA TI', 2)


INSERT INTO buzon_usuario (buzon_usuario_id, usuario_id, buzon_id) VALUES (1, 1, 1)
INSERT INTO buzon_usuario (buzon_usuario_id, usuario_id, buzon_id) VALUES (2, 1, 2)
INSERT INTO buzon_usuario (buzon_usuario_id, usuario_id, buzon_id) VALUES (3, 3, 3)
INSERT INTO buzon_usuario (buzon_usuario_id, usuario_id, buzon_id) VALUES (4, 4, 4)
