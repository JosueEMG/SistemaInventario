select h.id_historial, p.fecha_ingreso, fecha_salida, cantidad, p.nombre_producto
from historial h inner join productos p
on h.id_producto = p.id_producto;


select id_categoria, nombre_categoria from categoria;
use sistemainventario;
insert into categoria (nombre_categoria) values ("Josue");
delete from categoria where nombre_categoria = "nada";
select id_categoria, nombre_categoria from categoria;

select nombre, dni , correo, t.nombre_tipo 
from usuario u inner join tipo_usuario t 
on u.id_tipo = t.id_tipo where id = 1;

insert into productos values (3, "nombre", 100, 4.5, "2020-12-12", "2021-05-06", 1, 1, 1, 1);
update productos set nombre_producto = "", precio = 2, fecha_ingreso = "", fecha_vencimiento = "", id_categoria = 1, id_proveedor = 1, stock = 2 where id_producto = ?; 

insert into categoria values (3, "", 100, 3);


use sistemainventario;
select  nombre_producto, precio, fecha_ingreso, fecha_vencimiento, nombre_categoria, nombre_proveedores, stock 
from productos p, proveedores pro, usuario u, categoria c 
where p.Id_proveedores=pro.Id_proveedores 
and p.Id_Usuario=u.Id 
and p.Id_categoria=c.Id_categoria
and id_producto = 1;

use sistemainventario;
select h.id_historial, p.fecha_ingreso, fecha_salida, cantidad, p.nombre_producto, estado
from historial h inner join productos p
on h.id_producto = p.id_producto

use sistemainventario;
select Id_producto, Nombre_Producto, Stock, Precio, Fecha_Ingreso, Fecha_vencimiento, Nombre_categoria, Nombre_proveedores, Nombre 
from productos p, proveedores pro, usuario u, categoria c 
where p.Id_proveedores=pro.Id_proveedores 
and p.Id_categoria=c.Id_categoria
and u.id = p.id_usuario


select Id_proveedores, Nombre_proveedores from proveedores;

use sistemainventario;
insert into proveedores (Nombre_proveedores) values ("San Jose");

use sistemainventario;
delete from proveedores where Id_proveedores=3;

use sistemainventario;
select Id, Nombre, DNI, Correo, Nombre_tipo from usuario u inner join tipo_usuario t where u.Id_tipo=t.Id_tipo;

use sistemainventario;
insert into usuario (Nombre, DNI, Contraseña, Correo, Id_tipo) values ("Enzo", 895689, 123456789, "hghghgh", 2);


use sistemainventario;
delete from usuario where Id=4;

use sistemainventario;
select Id_producto, Nombre_Producto, Stock, Precio, Fecha_Ingreso, Fecha_vencimiento, Nombre_categoria, Nombre_proveedores, Nombre 
from productos p, proveedores pro, usuario u, categoria c 
where p.Id_proveedores=pro.Id_proveedores 
and p.Id_Usuario=u.Id 
and p.Id_categoria=c.Id_categoria;

use sistemainventario;
select Id_producto, Nombre_Producto, Stock, Precio, Fecha_Ingreso, Fecha_vencimiento, Nombre_categoria, Nombre_proveedores, Nombre 
from productos p, proveedores pro, usuario u, categoria c 
where p.Id_proveedores=pro.Id_proveedores 
and p.Id_Usuario=u.Id 
and p.Id_categoria=c.Id_categoria 
and p.Id_categoria=1;

use sistemainventario;
select Id_producto, Nombre_Producto, Stock, Precio, Fecha_Ingreso, Fecha_vencimiento, Nombre_categoria, Nombre_proveedores, Nombre 
from productos p, proveedores pro, usuario u, categoria c 
where p.Id_proveedores=pro.Id_proveedores 
and p.Id_Usuario=u.Id 
and p.Id_categoria=c.Id_categoria 
and Nombre_Producto 
like "Leche Gloria";



DELIMITER @@
DROP PROCEDURE AdicionProducto @@
CREATE PROCEDURE sistemainventario.AdicionProducto
(nom varchar(25), stock int, precio int, fecha_ingreso varchar(25), fecha_vencimiento varchar(25), idcat int, idpro int, idusu int)
begin
declare nro int;
declare nrohis int;
select Max(Id_producto)+1 into nro from productos;
select Max(Id_historial)+1 into nrohis from historial;
insert into productos values (nro, nom, stock, precio, fecha_ingreso, fecha_vencimiento, idcat, idpro, nrohis, idusu);
insert into historial values (nrohis, fecha_ingreso,"-", stock, nom, "Ingreso");
end @@ 
DELIMITER ; 


DELIMITER @@
DROP PROCEDURE RetiroProducto @@
CREATE PROCEDURE sistemainventario.RetiroProducto
(cantidad int, idproducto int)
begin
declare stockanterior int;
declare nrohis int;
declare nomProducto varchar(30);
declare fechaIngreso varchar(25);
select stock from productos where id_producto=idproducto into stockanterior;
select nombre_producto from productos where id_producto=idproducto into nomProducto;
select fecha_ingreso from productos where id_producto=idproducto into fechaIngreso;
Update productos set stock = stockanterior-cantidad where id_producto=idproducto;
select Max(Id_historial)+1 into nrohis from historial;
insert into historial values (nrohis, fechaIngreso, curdate(), cantidad, nomProducto, "Retiro");
end @@ 
DELIMITER ; 



