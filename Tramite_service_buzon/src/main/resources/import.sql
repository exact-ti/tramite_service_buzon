
SET IDENTITY_INSERT [dbo].[tipo_buzon] ON
INSERT [dbo].[tipo_buzon] ([tipo_buzon_id], [nombre]) VALUES (1, 'PERSONAL')
INSERT [dbo].[tipo_buzon] ([tipo_buzon_id], [nombre]) VALUES (2, 'GRUPAL')
SET IDENTITY_INSERT [dbo].[tipo_buzon] OFF

SET IDENTITY_INSERT [dbo].[buzon] ON
INSERT [dbo].[buzon] ([buzon_id], [nombre], [ubicacion_id], [ubicacion_nombre], [tipo_buzon_id]) VALUES (1, 'ASISTENTE', 1, 'AREA TI', 1)
INSERT [dbo].[buzon] ([buzon_id], [nombre], [ubicacion_id], [ubicacion_nombre], [tipo_buzon_id]) VALUES (2, 'PROGRAMADOR', 1, 'AREA TI', 1)
INSERT [dbo].[buzon] ([buzon_id], [nombre], [ubicacion_id], [ubicacion_nombre], [tipo_buzon_id]) VALUES (3, 'ANALISTA', 2, 'PROYECTOS', 1)
INSERT [dbo].[buzon] ([buzon_id], [nombre], [ubicacion_id], [ubicacion_nombre], [tipo_buzon_id]) VALUES (4, 'TI', 2, 'AREA TI', 2)
SET IDENTITY_INSERT [dbo].[buzon] OFF

SET IDENTITY_INSERT [dbo].[buzon_usuario] ON
INSERT [dbo].[buzon_usuario] ([buzon_usuario_id], [usuario_id], [buzon_id]) VALUES (1, 1, 1)
INSERT [dbo].[buzon_usuario] ([buzon_usuario_id], [usuario_id], [buzon_id]) VALUES (2, 2, 2)
INSERT [dbo].[buzon_usuario] ([buzon_usuario_id], [usuario_id], [buzon_id]) VALUES (3, 3, 3)
INSERT [dbo].[buzon_usuario] ([buzon_usuario_id], [usuario_id], [buzon_id]) VALUES (4, 4, 4)
SET IDENTITY_INSERT [dbo].[buzon_usuario] OFF

