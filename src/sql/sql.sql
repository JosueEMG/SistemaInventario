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
