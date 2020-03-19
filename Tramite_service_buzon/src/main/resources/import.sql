

INSERT INTO tipo_buzon (nombre) VALUES ('PERSONAL')
INSERT INTO tipo_buzon (nombre) VALUES ('GENÉRICO')


INSERT INTO buzon (nombre, ubicacion_codigo, tipo_buzon_id) VALUES ('ADMINISTRADOR', '515T3M45',  1)
INSERT INTO buzon (nombre, ubicacion_codigo, tipo_buzon_id) VALUES ('PROGRAMADOR', '515T3M45', 1)
INSERT INTO buzon (nombre, ubicacion_codigo, tipo_buzon_id) VALUES ('ANALISTA', 'C0M3RC14L', 1)
INSERT INTO buzon (nombre, ubicacion_codigo, tipo_buzon_id) VALUES ('TI', 'C0M3RC14L', 2)


INSERT INTO buzon_usuario (buzon_usuario_id, usuario_id, buzon_id) VALUES (1, 1, 1)
INSERT INTO buzon_usuario (buzon_usuario_id, usuario_id, buzon_id) VALUES (2, 1, 2)
INSERT INTO buzon_usuario (buzon_usuario_id, usuario_id, buzon_id) VALUES (3, 3, 3)
INSERT INTO buzon_usuario (buzon_usuario_id, usuario_id, buzon_id) VALUES (4, 4, 4)
