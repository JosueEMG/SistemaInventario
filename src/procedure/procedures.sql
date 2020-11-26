use sistemainventario;
delimiter@@
create procedure AdicionProducto(nom varchar(25), stock int, precio int, fecha_ingreso varchar(25), fecha_vencimiento varchar(25), idcat int, idpro int, idusu int)
begin
declare nro int;
declare nrohis int;
select Max(Id_producto)+1 into nro from productos;
select Max(Id_historial)+1 into nrohis from historial;
insert into productos values (nro, nom, stock, precio, fecha_ingreso, fecha_vencimiento, idcat, idpro, nrohis, idusu);
insert into historial values (nrohis, "-", stock, nro, "Ingreso");
end@@
delimiter;

use sistemainventario;
call AdicionProducto("Kgada", 100, 2000, "2020-12-10", "2021-12-10", 1, 2, 7);

use sistemainventario;
delimiter@@
create procedure RetiroProducto(cantidad int, idproducto int)
begin
declare stockanterior int;
declare nrohis int;
select stock from productos where id_producto=idproducto into stockanterior;
Update productos set stock = stockanterior-cantidad where id_producto=idproducto;
select Max(Id_historial)+1 into nrohis from historial;
insert into historial values (nrohis, curdate() , cantidad, idproducto, "Retiro");
end@@
delimiter;

use sistemainventario;
call RetiroProducto(50, 1);
