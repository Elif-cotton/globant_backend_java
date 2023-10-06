SELECT `fabricante`.`codigo`,
    `fabricante`.`nombre`
FROM `tienda`.`fabricante`;

SELECT *
FROM `tienda`.`producto`;

-- 1. Lista el nombre de todos los productos que hay en la tabla producto.
SELECT nombre AS productos
FROM producto;
-- 2. Lista los nombres y los precios de todos los productos de la tabla producto.
SELECT nombre, precio
FROM producto;

-- 3. Lista todas las columnas de la tabla producto.
SELECT *
FROM `tienda`.`producto`;

-- 4. Lista los nombres y los precios de todos los productos de la tabla producto, redondeando el valor del precio.
SELECT nombre , round(precio)
FROM producto;

-- 5. Lista el código de los fabricantes que tienen productos en la tabla producto.
SELECT codigo_fabricante
FROM producto;

-- 10. Lista el código de los fabricantes que tienen productos en la tabla producto, sin mostrar los repetidos.
SELECT DISTINCT codigo_fabricante
FROM producto;

-- DISTINCT:eliminando duplicados.

-- 11. Lista los nombres de los fabricantes ordenados de forma ascendente.
SELECT nombre
FROM fabricante
group by nombre ASC; 

-- 12. Lista los nombres de los productos ordenados en primer lugar por el nombre de
-- forma ascendente y en segundo lugar por el precio de forma descendente.
SELECT nombre, precio
FROM producto
group by nombre asc, precio desc;

-- 13. Devuelve una lista con las 5 primeras filas de la tabla fabricante.  OJO 
SELECT *
FROM fabricante
limit 5; 

-- 14. Lista el nombre y el precio del producto más barato. (Utilice solamente las cláusulas ORDER BY y LIMIT)
SELECT nombre, precio
FROM producto
ORDER BY precio
limit 1;

-- 15. Lista el nombre y el precio del producto más caro. (Utilice solamente las cláusulas ORDER BY y LIMIT)
SELECT nombre , precio
FROM producto
ORDER BY precio DESC
LIMIT 1;

-- 16. Lista el nombre de los productos que tienen un precio menor o igual a $120.
SELECT nombre, precio
FROM producto
WHERE precio <= 120;

-- 17. Lista todos los productos que tengan un precio entre $60 y $200. Utilizando el operador BETWEEN.
SELECT nombre, precio 
FROM producto
WHERE precio BETWEEN 60 AND 200
order by precio asc;

-- 18. Lista todos los productos donde el código de fabricante sea 1, 3 o 5. Utilizando el operador IN.
SELECT nombre, codigo_fabricante
FROM producto
WHERE codigo_fabricante IN(1,2,3);

-- 23. Devuelve una lista con el nombre de todos los productos que contienen la cadena Portátil en el nombre. OJO
SELECT nombre 
FROM producto
WHERE nombre LIKE '%Portátil%';

SELECT *
FROM `tienda`.`fabricante`;

SELECT *
FROM `tienda`.`producto`;
-- Consultas Multitabla
-- 1. Devuelve una lista con el código del producto, nombre del producto, código del fabricante y 
-- nombre del fabricante, de todos los productos de la base de datos.
SELECT p.codigo, p.nombre, p.codigo_fabricante, f.nombre, f.codigo
FROM producto p
JOIN fabricante f ON f.codigo=p.codigo_fabricante;

-- 2. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la
-- base de datos. Ordene el resultado por el nombre del fabricante, por orden alfabético.
SELECT p.nombre, p.precio, f.nombre
FROM producto p
JOIN fabricante f ON f.codigo=p.codigo_fabricante
group by f.nombre asc;

-- 3. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más barato.
SELECT p.nombre, p.precio,f.nombre
FROM producto p
JOIN fabricante f ON f.codigo=p.codigo_fabricante
order by p.precio asc
limit 1;

-- JOIN = INNER JOIN
SELECT p.nombre, p.precio, f.nombre
FROM producto p
INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE p.precio = (
    SELECT MIN(precio)
    FROM producto
);

-- 4. Devuelve una lista de todos los productos del fabricante Lenovo.
SELECT p.nombre, f.nombre
FROM producto p
INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE  f.nombre like 'Lenovo';

SELECT p.nombre, f.nombre
FROM producto p
INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE  f.nombre = 'Lenovo';

-- 5. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que $200.
SELECT p.nombre, p.precio, f.nombre
FROM producto p
INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE p.precio>200;

-- 6. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett- Packard. Utilizando el operador IN.
SELECT p.nombre, p.precio, f.nombre
FROM producto p
INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE f.nombre LIKE 'Asus' OR f.nombre LIKE  'Hewlett-Packard';

-- 7. Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos que
-- tengan un precio mayor o igual a $180. Ordene el resultado en primer lugar por el precio (en orden descendente)
-- y en segundo lugar por el nombre (en orden ascendente)
SELECT p.nombre, p.precio, f.nombre
FROM producto p
INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE p.precio >= 180
ORDER BY p.precio DESC, p.nombre ASC; 

-- Consultas Multitabla
-- Resuelva todas las consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.
-- 1. Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos que
-- tiene cada uno de ellos. El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.
SELECT f.nombre , p.nombre
FROM fabricante f
LEFT JOIN producto p ON p.codigo_fabricante = f.codigo
ORDER BY f.nombre, p.nombre;   -- ordenados
-- 2. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado. OJO
SELECT f.nombre , p.nombre
FROM fabricante f
LEFT JOIN producto p ON p.codigo_fabricante = f.codigo
WHERE p.nombre IS NULL;

-- Subconsultas (En la cláusula WHERE)
-- Con operadores básicos de comparación
-- 1. Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT p.nombre, f.nombre, p.precio
FROM producto p
RIGHT JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE  f.nombre = 'Lenovo';

SELECT p.nombre, p.precio, (
    SELECT f.nombre
    FROM fabricante f
    WHERE f.codigo = 2
) AS nombre_fabricante
FROM producto p
WHERE p.codigo_fabricante = 2;

-- 2. Devuelve todos los datos de los productos que tienen el mismo precio que el
-- producto más caro del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT p.codigo, p.nombre, p.precio, p.codigo_fabricante,
       (SELECT f.codigo FROM fabricante f WHERE f.nombre = 'Lenovo') AS codigo_fabricante_lenovo,
       (SELECT f.nombre FROM fabricante f WHERE f.nombre = 'Lenovo') AS nombre_fabricante_lenovo
FROM producto p
WHERE p.precio = (
    SELECT MAX(precio)
    FROM producto
    WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo')
);

SELECT p.codigo, p.nombre, p.precio, p.codigo_fabricante,
       (SELECT f.codigo FROM fabricante f WHERE f.codigo = 2) AS codigo_fabricante_lenovo,
       (SELECT f.nombre FROM fabricante f WHERE f.codigo = 2) AS nombre_fabricante_lenovo
FROM producto p
WHERE p.precio = (
    SELECT MAX(precio)
    FROM producto
    WHERE codigo_fabricante = 2
);

SELECT p.codigo_producto, p.nombre_producto, p.precio, p.codigo_fabricante,
       f.codigo_fabricante AS codigo_fabricante_lenovo, f.nombre_fabricante AS nombre_fabricante_lenovo
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante
WHERE p.precio = (
    SELECT MAX(precio)
    FROM producto
    WHERE codigo_fabricante = 2
);

SELECT p.codigo_producto, p.nombre_producto, p.precio, p.codigo_fabricante,
       f.codigo_fabricante AS codigo_fabricante_lenovo, f.nombre_fabricante AS nombre_fabricante_lenovo
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo_fabricante
WHERE p.precio = (
    SELECT MAX(precio)
    FROM producto
    WHERE codigo_fabricante = 2
);

SELECT p.codigo, p.nombre, p.precio, p.codigo_fabricante,
       f.codigo AS codigo_fabricante_lenovo, f.nombre AS nombre_fabricante_lenovo
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE p.precio = (
    SELECT MAX(precio)
    FROM producto
    WHERE codigo_fabricante = 2
);

-- 3. Lista el nombre del producto más caro del fabricante Lenovo.
SELECT p.nombre, p.precio, f.nombre
FROM producto p
INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE  f.nombre = 'Lenovo' 
ORDER BY p.precio DESC
LIMIT 1;
 
-- 4. Lista todos los productos del fabricante Asus que tienen un precio superior al precio medio de todos sus productos.
SELECT p.nombre, p.precio, f.nombre
FROM producto p
INNER JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE  f.nombre = 'Asus';

SELECT p.nombre, p.precio, f.nombre, avg(p.precio)
FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE f.nombre = 'Asus'
AND p.precio > (
    SELECT AVG(precio)
    FROM producto
    WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus')
);

SELECT p.nombre, p.precio
FROM producto p
WHERE p.codigo_fabricante = (
    SELECT codigo
    FROM fabricante
    WHERE nombre = 'Asus'
)
AND p.precio > (
    SELECT AVG(precio)
    FROM producto
    WHERE codigo_fabricante = (
        SELECT codigo
        FROM fabricante
        WHERE nombre = 'Asus'
    )
);

-- Subconsultas con IN y NOT IN
-- 1. Devuelve los nombres de los fabricantes que tienen productos asociados.(Utilizando IN o NOT IN).
SELECT nombre
FROM fabricante
WHERE codigo IN (
    SELECT DISTINCT codigo_fabricante
    FROM producto
);

-- 2. Devuelve los nombres de los fabricantes que no tienen productos asociados (Utilizando IN o NOT IN).
SELECT nombre
FROM fabricante
WHERE codigo NOT IN (
    SELECT DISTINCT codigo_fabricante
    FROM producto
);
SELECT f.nombre
FROM fabricante f
LEFT JOIN producto p ON f.codigo = p.codigo_fabricante
WHERE p.codigo_fabricante IS NULL;

-- Subconsultas (En la cláusula HAVING)
-- 1. Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número de productos que 
-- el fabricante Lenovo.
SELECT f.nombre
FROM fabricante f
JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre
HAVING COUNT(p.codigo) = (
    SELECT COUNT(p2.codigo)
    FROM producto p2
    JOIN fabricante f2 ON p2.codigo_fabricante= f2.codigo
    WHERE f2.nombre = 'Lenovo'
);

SELECT f.nombre
FROM fabricante f
JOIN producto p ON f.codigo = p.codigo_fabricante
GROUP BY f.nombre
HAVING COUNT(p.codigo) = (
    SELECT COUNT(p2.codigo)
    FROM producto p2
    JOIN fabricante f2 ON p2.codigo_fabricante = f2.codigo
    WHERE f2.nombre = 'Lenovo'
)
AND f.nombre <> 'Lenovo';

SELECT `fabricante`.`codigo`,
    `fabricante`.`nombre`
FROM `tienda`.`fabricante`;
SELECT `producto`.`codigo`,
    `producto`.`nombre`,
    `producto`.`precio`,
    `producto`.`codigo_fabricante`
FROM `tienda`.`producto`;
