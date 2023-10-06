SELECT *
FROM cliente;
SELECT *
FROM detalle_pedido;
SELECT *
FROM empleado;
SELECT *
FROM gama_producto;
SELECT *
FROM oficina;
SELECT *
FROM pago;
SELECT *
FROM pedido;
SELECT *
FROM producto;
-- Consultas sobre una tabla
-- 1. Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.
SELECT codigo_oficina, ciudad
FROM oficina;

-- 2. Devuelve un listado con la ciudad y el teléfono de las oficinas de España.
SELECT ciudad, telefono, pais
FROM oficina
WHERE pais LIKE 'España';
-- 3. Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7
SELECT nombre, apellido1, apellido2, email, codigo_jefe
FROM empleado
WHERE codigo_jefe=7;
-- 4. Devuelve el nombre del puesto, nombre, apellidos y email del jefe de la empresa.
SELECT puesto as 'Nombre del puesto', nombre, apellido1, apellido2, email
FROM empleado;

-- 5. Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados que no sean representantes de ventas.
SELECT puesto as 'Nombre del puesto', nombre, apellido1, apellido2
FROM empleado
WHERE puesto <> 'Representante Ventas'
ORDER BY puesto ASC;
-- 6. Devuelve un listado con el nombre de los todos los clientes españoles.
SELECT nombre_cliente, pais
FROM cliente
WHERE pais = 'Spain';

-- 7. Devuelve un listado con los distintos estados por los que puede pasar un pedido.
SELECT DISTINCT estado
FROM pedido;

-- 8. Devuelve un listado con el código de cliente de aquellos clientes que realizaron algún pago en 2008. Tenga en 
-- cuenta que deberá eliminar aquellos códigos de cliente que aparezcan repetidos. Resuelva la consulta: OJO 
-- o Utilizando la función YEAR de MySQL.
SELECT DISTINCT codigo_cliente,fecha_pago
FROM pago
WHERE YEAR(fecha_pago) = 2008;
-- o Utilizando la función DATE_FORMAT de MySQL.
SELECT DISTINCT codigo_cliente, fecha_pago
FROM pago
WHERE DATE_FORMAT(fecha_pago, '%Y') = '2008';
-- o Sin utilizar ninguna de las funciones anteriores.
SELECT *
FROM pago;
SELECT DISTINCT codigo_cliente,fecha_pago
FROM pago
WHERE fecha_pago >= '2008-01-01' AND fecha_pago <= '2008-12-31';
-- 9. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los 
-- pedidos que no han sido entregados a tiempo.
SELECT DISTINCT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
FROM pedido
WHERE fecha_entrega>fecha_esperada;
-- 10. Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de
-- entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha esperada.
-- o Utilizando la función ADDDATE de MySQL.
-- función ADDDATE para restar 2 días a la fecha esperada y luego comparamos la fecha de entrega con esta fecha 
-- calculada. Si la fecha de entrega es al menos dos días antes de la fecha esperada, se selecciona el registro.
SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
FROM pedido
WHERE fecha_entrega <= ADDDATE(fecha_esperada, -2);
-- o Utilizando la función DATEDIFF de MySQL.
-- función DATEDIFF para calcular la diferencia en días entre la fecha esperada y la fecha de entrega. Luego, 
-- comparamos esta diferencia con 2 para seleccionar los registros donde la fecha de entrega es al menos dos días 
-- antes de la fecha esperada.
SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
FROM pedido
WHERE DATEDIFF(fecha_esperada, fecha_entrega) >= 2;

-- 11. Devuelve un listado de todos los pedidos que fueron rechazados en 2009.
SELECT *
FROM pedido;
SELECT codigo_pedido, fecha_entrega, estado
FROM pedido
WHERE DATE_FORMAT(fecha_entrega, '%Y') = '2009' AND estado = 'Rechazado';

-- 12. Devuelve un listado de todos los pedidos que han sido entregados en el mes de enero de cualquier año.
SELECT codigo_pedido, fecha_entrega, estado
FROM pedido
WHERE DATE_FORMAT(fecha_entrega, '%m') = '01';

SELECT codigo_pedido, codigo_cliente, fecha_esperada, fecha_entrega
FROM pedido
WHERE MONTH(fecha_entrega) = 1;
-- 13. Devuelve un listado con todos los pagos que se realizaron en el año 2008 mediante Paypal.
SELECT *
FROM pago;
SELECT codigo_cliente, forma_pago , fecha_pago
FROM pago
WHERE forma_pago = 'PayPal' AND YEAR (fecha_pago)='2008';

-- Ordene el resultado de mayor a menor. DESC
-- 14. Devuelve un listado con todas las formas de pago que aparecen en la tabla pago. Tenga en
-- cuenta que no deben aparecer formas de pago repetidas.
SELECT distinct forma_pago 
FROM pago; 

-- 15. Devuelve un listado con todos los productos que pertenecen a la gama Ornamentales y que tienen más de 100 unidades 
-- en stock. El listado deberá estar ordenado por su precio de venta, mostrando en primer lugar los de mayor precio.
SELECT *
FROM producto;
SELECT gama, cantidad_en_stock, precio_venta
FROM producto
WHERE gama = 'Ornamentales' AND cantidad_en_stock>100 
order by precio_venta DESC;

-- 16. Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo
-- representante de ventas tenga el código de empleado 11 o 30.
SELECT nombre_cliente, ciudad, codigo_empleado_rep_ventas
FROM cliente
WHERE ciudad='Madrid' and codigo_empleado_rep_ventas IN (11, 30);

-- Consultas multitabla (Composición interna)
-- Las consultas se deben resolver con INNER JOIN.
-- 1. Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.
SELECT c.nombre_cliente, e.nombre as 'Nombre empleado',CONCAT(e.apellido1, ' ', e.apellido2) as 'Apellido'
FROM cliente as c 
INNER JOIN  empleado as e ON c.codigo_empleado_rep_ventas= e.codigo_empleado;

-- 2. Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus representantes de ventas.
SELECT c.nombre_cliente AS Nombre_Cliente, e.nombre AS 'Nombre_Representante', p.forma_pago
FROM cliente AS c
INNER JOIN pago AS p ON c.codigo_cliente = p.codigo_cliente
INNER JOIN empleado AS e ON c.codigo_empleado_rep_ventas= e.codigo_empleado;

-- 3. Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de
-- sus representantes de ventas.
SELECT c.nombre_cliente AS Nombre_Cliente, e.nombre AS Nombre_Representante
FROM cliente AS c
INNER JOIN empleado AS e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE NOT EXISTS (
    SELECT 1
    FROM pago AS p
    WHERE p.codigo_cliente = c.codigo_cliente
);

-- 4. Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes junto con la ciudad 
-- de la oficina a la que pertenece el representante.
SELECT 
    c.nombre_cliente AS Nombre_Cliente, 
    e.nombre AS Nombre_Representante, 
    o.ciudad AS Ciudad_Oficina
FROM 
    cliente AS c
INNER JOIN 
    empleado AS e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
INNER JOIN 
    oficina AS o ON e.codigo_oficina = o.codigo_oficina
INNER JOIN 
    pago AS p ON c.codigo_cliente = p.codigo_cliente;
-- 5. Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes junto con la 
-- ciudad de la oficina a la que pertenece el representante.
SELECT 
    c.nombre_cliente AS Nombre_Cliente, 
    e.nombre AS Nombre_Representante, 
    o.ciudad AS Ciudad_Oficina
FROM 
    cliente AS c
INNER JOIN 
    empleado AS e ON c.codigo_empleado_rep_ventas = e.codigo_empleado
INNER JOIN 
    oficina AS o ON e.codigo_oficina = o.codigo_oficina
WHERE 
    NOT EXISTS (
        SELECT 1
        FROM pago AS p
        WHERE c.codigo_cliente = p.codigo_cliente
    );
    SELECT 
    c.nombre_cliente,
    r.nombre,
    r.apellido1,
    r.apellido2,
    o.ciudad
FROM
    cliente c
        LEFT JOIN
    pago p ON c.codigo_cliente = p.codigo_cliente
        INNER JOIN
    empleado r ON c.codigo_empleado_rep_ventas = r.codigo_empleado
        INNER JOIN
    oficina o ON r.codigo_oficina = o.codigo_oficina
WHERE
    p.codigo_cliente IS NULL;
-- 6. Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.
SELECT o.linea_direccion1, o.linea_direccion2
FROM oficina as o
INNER JOIN empleado as e ON o.codigo_oficina=e.codigo_oficina
INNER JOIN cliente as c ON e.codigo_empleado=c.codigo_empleado_rep_ventas
WHERE c.ciudad = 'Fuenlabrada';

SELECT 
    o.linea_direccion1, o.linea_direccion2
FROM
    oficina o
        INNER JOIN
    empleado r ON r.codigo_oficina = o.codigo_oficina
        INNER JOIN
    cliente c ON c.codigo_empleado_rep_ventas = r.codigo_empleado
WHERE
    c.ciudad LIKE 'Fuenlabrada';

-- 7. Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad
-- de la oficina a la que pertenece el representante.
SELECT c.nombre_cliente,e.nombre as 'Nombre empleado', o.ciudad
FROM oficina as o
INNER JOIN empleado as e ON o.codigo_oficina=e.codigo_oficina
INNER JOIN cliente as c ON e.codigo_empleado=c.codigo_empleado_rep_ventas;

-- 8. Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
SELECT e.nombre, j.nombre AS jefe
FROM empleado e
INNER JOIN empleado j ON e.codigo_jefe = j.codigo_empleado;

SELECT *
FROM empleado;  -- es asi misma la tabla, los jefes estan entre los empleados
-- 9. Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.
SELECT c.nombre_cliente, p.estado,p.fecha_esperada,p.fecha_entrega
FROM cliente as c
INNER JOIN pedido p ON c.codigo_cliente= p.codigo_cliente
WHERE fecha_entrega>fecha_esperada
GROUP BY c.nombre_cliente;
SELECT *
FROM pedido;

-- 10. Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
SELECT g.gama, c.nombre_cliente
FROM gama_producto as g
INNER JOIN producto as p ON g.gama=p.gama
INNER JOIN detalle_pedido as dp ON p.codigo_producto=dp.codigo_producto
INNER JOIN pedido as pe ON dp.codigo_pedido=pe.codigo_pedido
INNER JOIN cliente as c ON pe.codigo_cliente=c.codigo_cliente;

SELECT distinct g.gama, c.nombre_cliente
FROM cliente as c
INNER JOIN pedido as pe ON pe.codigo_cliente=c.codigo_cliente
INNER JOIN detalle_pedido as dp ON dp.codigo_pedido=pe.codigo_pedido
INNER JOIN producto as p ON p.codigo_producto=dp.codigo_producto
INNER JOIN gama_producto as g ON g.gama=p.gama;

-- Consultas multitabla (Composición externa)
-- Resuelva todas las consultas utilizando las cláusulas LEFT JOIN, RIGHT JOIN, JOIN.
-- 1. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
SELECT c.nombre_cliente
FROM cliente as c
LEFT JOIN pago as p ON c.codigo_cliente=p.codigo_cliente
WHERE p.codigo_cliente IS NULL;

-- 2. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.
SELECT c.nombre_cliente
FROM cliente as c
LEFT JOIN pedido AS p ON c.codigo_cliente=p.codigo_cliente
WHERE p.codigo_cliente IS NULL;

-- 3. Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado 
-- ningún pedido.
SELECT c.nombre_cliente
FROM cliente as c
LEFT JOIN pago as p ON c.codigo_cliente=p.codigo_cliente
LEFT JOIN pedido AS pe ON c.codigo_cliente=pe.codigo_cliente
WHERE p.codigo_cliente IS NULL AND pe.codigo_cliente IS NULL;

-- 4. Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.
SELECT e.nombre
FROM empleado as e
LEFT JOIN oficina as o ON e.codigo_oficina=o.codigo_oficina
WHERE o.codigo_oficina IS NULL;

SELECT 
    e.*
FROM
    empleado e
        LEFT JOIN
    oficina o ON e.codigo_oficina = o.codigo_oficina
WHERE
    e.codigo_oficina IS NULL;
-- 5. Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.
SELECT e.*
FROM empleado as e
LEFT JOIN cliente as c ON e.codigo_empleado=c.codigo_empleado_rep_ventas
WHERE c.codigo_cliente IS NULL;

SELECT 
    e.*
FROM
    empleado e
        LEFT JOIN
    cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE
    c.codigo_cliente IS NULL;
-- 6. Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un
--  cliente asociado.
SELECT e.*
FROM empleado as e
LEFT JOIN oficina as o ON e.codigo_oficina=o.codigo_oficina
 LEFT JOIN cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE o.codigo_oficina IS NULL AND c.codigo_cliente IS NULL;

SELECT 
    e.*
FROM
    empleado e
        LEFT JOIN
    oficina o ON e.codigo_oficina = o.codigo_oficina
        LEFT JOIN
    cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
WHERE
    e.codigo_oficina IS NULL
        AND c.codigo_cliente IS NULL;

-- 7. Devuelve un listado de los productos que nunca han aparecido en un pedido.
SELECT p.*
FROM pedido AS pe
INNER JOIN detalle_pedido AS dp ON pe.codigo_pedido=dp.codigo_pedido
RIGHT JOIN producto AS p ON dp.codigo_producto=p.codigo_producto
WHERE dp.codigo_producto IS NULL;

SELECT 
    prod.*
FROM
    pedido ped
        INNER JOIN
    detalle_pedido det_ped ON ped.codigo_pedido = det_ped.codigo_pedido
        RIGHT JOIN
    producto prod ON det_ped.codigo_producto = prod.codigo_producto
WHERE
    det_ped.codigo_producto IS NULL;

-- 8. Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de ventas 
-- de algún cliente que haya realizado la compra de algún producto de la gama Frutales.
SELECT 
    o.*
FROM
    oficina o
WHERE
    o.codigo_oficina IN (SELECT 
            e.codigo_oficina
        FROM
            empleado e
        WHERE
            e.codigo_empleado NOT IN (SELECT DISTINCT
                    c.codigo_empleado_rep_ventas
                FROM
                    cliente c
                        INNER JOIN
                    pedido ped ON ped.codigo_cliente = c.codigo_cliente
                        INNER JOIN
                    detalle_pedido det_ped ON det_ped.codigo_pedido = ped.codigo_pedido
                        INNER JOIN
                    producto prod ON prod.codigo_producto = det_ped.codigo_producto
                WHERE
                    prod.gama LIKE 'Frutales'));

-- 9. Devuelve un listado con los clientes que han realizado algún pedido, pero no han realizado ningún pago.
SELECT DISTINCT
    c.*
FROM
    cliente c
        LEFT JOIN
    pago pago ON pago.codigo_cliente = c.codigo_cliente
        INNER JOIN
    pedido ped ON ped.codigo_cliente = c.codigo_cliente
WHERE
    pago.codigo_cliente IS NULL;
    

-- 10. Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de su jefe
-- asociado.
SELECT
 e.*, j.nombre
FROM
    empleado e
        LEFT JOIN
    cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
        INNER JOIN
    empleado j ON j.codigo_empleado = e.codigo_jefe
WHERE
    c.codigo_cliente IS NULL;

-- Consultas resumen
-- 1. ¿Cuántos empleados hay en la compañía?
SELECT count(*) AS 'Cantidad empleados'
FROM empleado;

-- 2. ¿Cuántos clientes tiene cada país?
SELECT  count(*) as Cantidad_de_Clientes, pais
FROM cliente
GROUP BY pais
ORDER BY pais ASC;

-- 3. ¿Cuál fue el pago medio en 2009?
SELECT avg(total)
FROM pago
WHERE YEAR(fecha_pago) LIKE 2009;
SELECT *
FROM pago; 
SELECT 
    AVG(total)
FROM
    pago
WHERE
    YEAR(fecha_pago) = 2009;

-- 4. ¿Cuántos pedidos hay en cada estado? Ordena el resultado de forma descendente por el número de pedidos.
SELECT  count(*) as Cantidad_de_pedidos, estado
FROM pedido
GROUP BY estado
ORDER BY Cantidad_de_pedidos ASC;

SELECT 
    COUNT(estado), estado
FROM
    pedido
GROUP BY estado
ORDER BY COUNT(estado) DESC;
-- 5. Calcula el precio de venta del producto más caro y más barato en una misma consulta.
SELECT max(precio_venta) as Producto_mas_caro, min(precio_venta) as Producto_mas_barato
FROM producto;
-- 6. Calcula el número de clientes que tiene la empresa.
SELECT count(*) AS 'Cantidad clientes'
FROM cliente;

-- 7. ¿Cuántos clientes tiene la ciudad de Madrid?
SELECT count(*) AS Cantidad_clientes, ciudad
FROM cliente
WHERE ciudad = 'Madrid';

-- 8. ¿Calcula cuántos clientes tiene cada una de las ciudades que empiezan por M?
SELECT count(*) AS Cantidad_clientes, ciudad
FROM cliente
WHERE ciudad LIKE 'M%'
GROUP BY ciudad;

-- 9. Devuelve el nombre de los representantes de ventas y el número de clientes al que atiende cada uno.
SELECT count(c.codigo_cliente) AS cantidad_clientes, e.nombre as nombre_representante_ventas
FROM cliente as c
INNER JOIN empleado as e ON c.codigo_empleado_rep_ventas=e.codigo_empleado
GROUP BY e.nombre;

-- 10. Calcula el número de clientes que no tiene asignado representante de ventas.
SELECT count(c.codigo_cliente) AS cantidad_clientes
FROM cliente as c
INNER JOIN empleado as e ON c.codigo_empleado_rep_ventas=e.codigo_empleado
WHERE c.codigo_empleado_rep_ventas IS NULL;

SELECT 
    COUNT(*)
FROM
    cliente c
        LEFT JOIN
    empleado r ON r.codigo_empleado = c.codigo_empleado_rep_ventas
WHERE
    r.codigo_empleado IS NULL;
        
-- 11. Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado deberá mostrar
-- el nombre y los apellidos de cada cliente.
SELECT *
FROM cliente;
SELECT c.nombre_cliente, max(p.fecha_pago) as Fecha_primer_pago, min(p.fecha_pago) as Fecha_ultimo_pago
FROM cliente as c
INNER JOIN pago AS p ON c.codigo_cliente=p.codigo_cliente
GROUP BY c.codigo_cliente;

-- 12. Calcula el número de productos diferentes que hay en cada uno de los pedidos.
SELECT pe.codigo_pedido, count(p.codigo_producto) as numero_productos
FROM pedido AS pe
INNER JOIN detalle_pedido AS dp ON pe.codigo_pedido=dp.codigo_pedido
INNER JOIN producto AS p ON dp.codigo_producto=p.codigo_producto
GROUP BY pe.codigo_pedido;

SELECT 
    ped.codigo_pedido, COUNT(prod.codigo_producto)
FROM
    detalle_pedido dp
        INNER JOIN
    pedido ped ON dp.codigo_pedido = ped.codigo_pedido
        INNER JOIN
    producto prod ON dp.codigo_producto = prod.codigo_producto
GROUP BY ped.codigo_pedido;

-- 13. Calcula la suma de la cantidad total de todos los productos que aparecen en cada uno de los pedidos.
SELECT sum(dp.cantidad), pe.codigo_pedido
FROM pedido AS pe
INNER JOIN detalle_pedido AS dp ON pe.codigo_pedido=dp.codigo_pedido
INNER JOIN producto AS p ON dp.codigo_producto=p.codigo_producto
GROUP BY pe.codigo_pedido;

SELECT 
    ped.codigo_pedido, SUM(dp.cantidad)
FROM
    detalle_pedido dp
        INNER JOIN
    pedido ped ON dp.codigo_pedido = ped.codigo_pedido
        INNER JOIN
    producto prod ON dp.codigo_producto = prod.codigo_producto
GROUP BY ped.codigo_pedido;
-- 14. Devuelve un listado de los 20 productos más vendidos y el número total de unidades que se han vendido de 
-- cada uno. El listado deberá estar ordenado por el número total de unidades vendidas.
SELECT sum(dp.cantidad), pe.codigo_pedido, dp.codigo_producto, p.nombre
FROM pedido AS pe
INNER JOIN detalle_pedido AS dp ON pe.codigo_pedido=dp.codigo_pedido
INNER JOIN producto AS p ON dp.codigo_producto=p.codigo_producto
GROUP BY dp.codigo_producto
ORDER BY sum(dp.cantidad) DESC
LIMIT 20;

SELECT 
    SUM(dp.cantidad), dp.codigo_producto, p.nombre
FROM
    detalle_pedido dp
        INNER JOIN
    producto p ON dp.codigo_producto = p.codigo_producto
GROUP BY dp.codigo_producto
ORDER BY SUM(dp.cantidad) DESC
LIMIT 20;
-- 15. La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el IVA y el total
-- facturado. La base imponible se calcula sumando el coste del producto por el número de unidades vendidas de la 
-- tabla detalle_pedido. El IVA es el 21 % de la base imponible, y el total la suma de los dos campos anteriores.
SELECT 
    SUM((dp.cantidad * dp.precio_unidad) + (dp.cantidad * dp.precio_unidad) * 0.21) AS total_facturacion
FROM
    pago p
        INNER JOIN
    pedido ped ON P.codigo_cliente = ped.codigo_cliente
        INNER JOIN
    detalle_pedido dp ON ped.codigo_pedido = dp.codigo_pedido;
-- 16. La misma información que en la pregunta anterior, pero agrupada por código de producto.
SELECT 
     dp.codigo_producto,
     SUM((dp.cantidad * dp.precio_unidad) + (dp.cantidad * dp.precio_unidad) * 0.21) AS total_facturacion
FROM
    pago p
        INNER JOIN
    pedido ped ON P.codigo_cliente = ped.codigo_cliente
        INNER JOIN
    detalle_pedido dp ON ped.codigo_pedido = dp.codigo_pedido
GROUP BY  dp.codigo_producto;
-- 17. La misma información que en la pregunta anterior, pero agrupada por código de producto
-- filtrada por los códigos que empiecen por OR.
SELECT 
     dp.codigo_producto,
     SUM((dp.cantidad * dp.precio_unidad) + (dp.cantidad * dp.precio_unidad) * 0.21) AS total_facturacion
FROM
    pago p
        INNER JOIN
    pedido ped ON P.codigo_cliente = ped.codigo_cliente
        INNER JOIN
    detalle_pedido dp ON ped.codigo_pedido = dp.codigo_pedido
WHERE dp.codigo_producto LIKE 'OR%'
GROUP BY  dp.codigo_producto;
-- 18. Lista las ventas totales de los productos que hayan facturado más de 3000 euros. Se mostrará el nombre, 
-- unidades vendidas, total facturado y total facturado con impuestos (21% IVA)
SELECT 
    dp.codigo_producto,
    SUM((dp.cantidad * dp.precio_unidad)) AS total_facturacion,
    SUM((dp.cantidad * dp.precio_unidad) + (dp.cantidad * dp.precio_unidad) * 0.21) AS total_facturacion_iva
FROM
    pago p
        INNER JOIN
    pedido ped ON P.codigo_cliente = ped.codigo_cliente
        INNER JOIN
    detalle_pedido dp ON ped.codigo_pedido = dp.codigo_pedido
GROUP BY dp.codigo_producto
HAVING SUM((dp.cantidad * dp.precio_unidad)) > 3000;

-- Subconsultas con operadores básicos de comparación
-- 1. Devuelve el nombre del cliente con mayor límite de crédito.
SELECT nombre_cliente
FROM cliente
WHERE limite_credito = (SELECT MAX(limite_credito) FROM cliente);

SELECT 
    nombre_cliente
FROM
    cliente
WHERE
    limite_credito = (SELECT 
            MAX(limite_credito)
        FROM
            cliente);
-- 2. Devuelve el nombre del producto que tenga el precio de venta más caro.
SELECT nombre
FROM producto
WHERE precio_venta = (SELECT MAX(precio_venta) FROM producto);

SELECT nombre, precio_venta
FROM producto
ORDER BY precio_venta DESC
LIMIT 1;

-- 3. Devuelve el nombre del producto del que se han vendido más unidades. (Tenga en cuenta que tendrá que calcular 
-- cuál es el número total de unidades que se han vendido de cada producto a partir de los datos de la tabla 
-- detalle_pedido. Una vez que sepa cuál es el código del producto, puede obtener su nombre fácilmente.)
SELECT p.nombre as Nombre_producto, SUM(dp.cantidad) AS Total_unidades_vendidas
FROM detalle_pedido as dp
INNER JOIN producto as p ON dp.codigo_producto=p.codigo_producto
GROUP BY p.codigo_producto
ORDER BY Total_unidades_vendidas DESC
LIMIT 1;

SELECT 
    p.nombre
FROM
    producto p
WHERE
    codigo_producto = (SELECT 
            codigo_producto
        FROM
            detalle_pedido
        GROUP BY codigo_producto
        ORDER BY SUM(cantidad) DESC
        LIMIT 1);
        
    SELECT 
    p.nombre AS Nombre_Producto,
    SUM(dp.cantidad) AS Total_Unidades_Vendidas
FROM 
    detalle_pedido AS dp
INNER JOIN 
    producto AS p ON dp.codigo_producto = p.codigo_producto
GROUP BY 
    p.codigo_producto
ORDER BY 
    Total_Unidades_Vendidas DESC
LIMIT 1;    
-- 4. Los clientes cuyo límite de crédito sea mayor que los pagos que haya realizado. (Sin utilizar INNER JOIN).
SELECT c.*
FROM 
	cliente c,
	pago p
WHERE
    c.codigo_cliente = p.codigo_cliente
GROUP BY c.codigo_cliente , c.limite_credito
HAVING c.limite_credito > SUM(p.total);

-- 5. Devuelve el producto que más unidades tiene en stock.
SELECT *
FROM producto; 
SELECT *
FROM producto
WHERE cantidad_en_stock = (SELECT MAX(cantidad_en_stock) FROM producto);

-- 6. Devuelve el producto que menos unidades tiene en stock.
SELECT *
FROM producto
WHERE cantidad_en_stock = (SELECT MIN(cantidad_en_stock) FROM producto);

-- 7. Devuelve el nombre, los apellidos y el email de los empleados que están a cargo de Alberto Soria.
SELECT 
    e.nombre, e.apellido1, e.apellido2, e.email
FROM
    empleado e,
    empleado j
WHERE
    e.codigo_jefe = j.codigo_empleado
        AND j.nombre = 'Alberto'
        AND j.apellido1 = 'Soria';
        
-- Subconsultas con ALL y ANY (COMPARACIONES). ALL, puedes comparar el límite de crédito de cada cliente con todos 
-- los demás límites de crédito en la tabla cliente.El operador ANY se utiliza para verificar si una expresión es 
-- verdadera para al menos uno de los valores devueltos por una subconsulta.
-- 1. Devuelve el nombre del cliente con mayor límite de crédito.
SELECT nombre_cliente
FROM cliente
WHERE
    limite_credito = ALL (SELECT 
            MAX(limite_credito)
        FROM
            cliente);
            
SELECT 
    nombre_cliente
FROM
    cliente
WHERE
    limite_credito = ANY (SELECT 
            MAX(limite_credito)
        FROM
            cliente);            
            
SELECT nombre_cliente
FROM cliente c1
WHERE limite_credito >= ALL (
    SELECT limite_credito
    FROM cliente c2
    WHERE c2.codigo_cliente <> c1.codigo_cliente
);

-- 2. Devuelve el nombre del producto que tenga el precio de venta más caro.
SELECT nombre
FROM producto
WHERE
    precio_venta = ALL (SELECT 
            MAX(precio_venta)
        FROM
            producto);

SELECT nombre
FROM producto
WHERE
    precio_venta = ANY (SELECT 
            MAX(precio_venta)
        FROM
            producto);
            
-- 3. Devuelve el producto que menos unidades tiene en stock. 
SELECT nombre
FROM producto
WHERE
    cantidad_en_stock = ALL (SELECT 
            MIN(cantidad_en_stock)
        FROM
            producto);
                     
-- Subconsultas con IN y NOT IN.  IN y NOT IN se utilizan para filtrar registros basados en si un valor está presente 
-- o no en un conjunto de valores devueltos por una subconsulta. 
-- 1. Devuelve el nombre, apellido1 y cargo de los empleados que no representen a ningún cliente.
SELECT 
    nombre, apellido1, apellido2, puesto
FROM
    empleado
WHERE
    codigo_empleado NOT IN (SELECT 
            codigo_empleado_rep_ventas
        FROM
            cliente);

SELECT nombre, apellido1, puesto
FROM empleado
WHERE codigo_empleado NOT IN (
    SELECT DISTINCT codigo_empleado_rep_ventas
    FROM cliente
    WHERE codigo_empleado_rep_ventas IS NOT NULL
);
-- 2. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
SELECT *
FROM cliente
WHERE codigo_cliente NOT IN( 
	SELECT codigo_cliente
    FROM pago
);
SELECT *
FROM pago;

SELECT 
    *
FROM
    cliente
WHERE
    codigo_cliente NOT IN (SELECT 
            codigo_cliente
        FROM
            pago);
-- 3. Devuelve un listado que muestre solamente los clientes que sí han realizado ningún pago.
SELECT *
FROM cliente
WHERE codigo_cliente IN( 
	SELECT codigo_cliente
    FROM pago
);
-- 4. Devuelve un listado de los productos que nunca han aparecido en un pedido.
SELECT *
FROM producto
WHERE codigo_producto NOT IN (
	SELECT codigo_producto
    FROM detalle_pedido
);
SELECT * FROM producto WHERE codigo_producto NOT IN (SELECT codigo_producto FROM detalle_pedido);

-- 5. Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que no sean representante
 -- de ventas de ningún cliente. 
 SELECT e.nombre, e.apellido1, e.apellido2, e.puesto, o.telefono
 FROM empleado as e
 INNER JOIN oficina as o ON e.codigo_oficina=o.codigo_oficina
 WHERE e.codigo_empleado NOT IN (
	SELECT codigo_empleado_rep_ventas
    FROM cliente
 );
 
 -- Subconsultas con EXISTS y NOT EXISTS
-- 1. Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.
SELECT c.*
FROM cliente c
WHERE
    NOT EXISTS( SELECT 
            *
        FROM
            pago p
        WHERE
            c.codigo_cliente = p.codigo_cliente);
-- 2. Devuelve un listado que muestre solamente los clientes que sí han realizado ningún pago.
SELECT c.*
FROM cliente c
WHERE
    EXISTS( SELECT 
            *
        FROM
            pago p
        WHERE
            c.codigo_cliente = p.codigo_cliente);
-- 3. Devuelve un listado de los productos que nunca han aparecido en un pedido.
SELECT p.*
FROM producto as p
WHERE
    NOT EXISTS( SELECT 
            *
        FROM
            detalle_pedido as dp
        WHERE
            p.codigo_producto=dp.codigo_producto);
-- 4. Devuelve un listado de los productos que han aparecido en un pedido alguna vez.
SELECT p.*
FROM producto as p
WHERE
    EXISTS( SELECT 
            *
        FROM
            detalle_pedido as dp
        WHERE
            p.codigo_producto=dp.codigo_producto);