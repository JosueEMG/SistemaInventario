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
insert into categoria values (3, "", 100, 3);


use sistemainventario;
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
