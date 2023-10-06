-- 1. Obtener los datos completos de los empleados.
-- 2. Obtener los datos completos de los departamentos.
SELECT *
FROM `personal`.`departamentos`;

SELECT *
FROM `personal`.`empleados`;

-- 3. Listar el nombre de los departamentos.
SELECT nombre_depto FROM departamentos;

-- 4. Obtener el nombre y salario de todos los empleados.
SELECT nombre, sal_emp FROM empleados;

-- 5. Listar todas las comisiones.
SELECT comision_emp FROM empleados;

-- 6. Obtener los datos de los empleados cuyo cargo sea ‘Secretaria’.
SELECT * From empleados WHERE cargo_emp="Secretaria";

-- 7. Obtener los datos de los empleados vendedores, ordenados por nombre alfabéticamente
SELECT * FROM empleados WHERE cargo_emp= "Vendedor" ORDER BY nombre ASC;

-- 8. Obtener el nombre y cargo de todos los empleados, ordenados por salario de menor a mayor.
SELECT nombre, cargo_emp, sal_emp FROM empleados order by sal_emp asc;

-- 9. Elabore un listado donde para cada fila, figure el alias ‘Nombre’ y ‘Cargo’ para las respectivas tablas 
-- de empleados.
SELECT nombre AS Nombre, cargo_emp AS Cargo
FROM empleados;

-- 10. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión de menor a mayor.
SELECT sal_emp, comision_emp, id_depto FROM empleados WHERE id_depto=2000 ORDER BY comision_emp ASC;

-- 11. Obtener el valor total a pagar que resulta de sumar el salario y la comisión de los
-- empleados del departamento 3000 una bonificación de 500, en orden alfabético del empleado.
SELECT nombre, id_depto, (sal_emp + comision_emp + 500) AS Total_Pagar
FROM empleados
WHERE id_depto = 3000
ORDER BY nombre;
-- 12. Muestra los empleados cuyo nombre empiece con la letra J.
SELECT nombre FROM empleados WHERE nombre like "J%";
-- Muestra los empleados cuyo nombre empiece entre las letras J y Z (rango).
-- Liste estos empleados y su cargo por orden alfabético.
select nombre, cargo_emp
from empleados
where lower(nombre) > 'j' and lower(nombre) < 'z'
order by nombre;

-- 13. Listar el salario, la comisión, el salario total (salario + comisión) y nombre, de
-- aquellos empleados que tienen comisión superior a 1000.
SELECT sal_emp, comision_emp, (sal_emp + comision_emp) as salario_total, nombre
FROM empleados
WHERE comision_emp > 1000;

-- 14. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión.
SELECT sal_emp, comision_emp, (sal_emp + comision_emp) as salario_total, nombre
FROM empleados
WHERE comision_emp = 0;

-- 15. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
SELECT nombre, sal_emp, comision_emp
FROM empleados 
WHERE sal_emp < comision_emp; 

-- 16. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.
SELECT nombre, sal_emp, comision_emp
FROM empleados 
WHERE comision_emp<= (sal_emp*0.3); 

-- 17. Hallar los empleados cuyo nombre no contiene la cadena “MA”
SELECT nombre
FROM empleados 
WHERE nombre NOT LIKE '%MA%';

-- 18. Obtener los nombres de los departamentos que sean “Ventas” ni “Investigación” ni ‘Mantenimiento.
SELECT nombre_depto
FROM departamentos
WHERE nombre_depto IN ("VENTAS","INVESTIGACIÓN", "MANTENIMIENTO"); 
-- NOT LIKE se utiliza para buscar registros que no coinciden con un patrón de texto específico,
--  mientras que NOT IN se utiliza para filtrar registros que no coinciden con una lista específica de valores en un campo. 

-- 19. Ahora obtener los nombres de los departamentos que no sean “Ventas” ni “Investigación” ni ‘Mantenimiento.
SELECT nombre_depto
FROM departamentos
WHERE nombre_depto NOT IN ("VENTAS","INVESTIGACIÓN", "MANTENIMIENTO"); 

-- 20. Mostrar el salario más alto de la empresa.
SELECT max(sal_emp) AS salario_maximo
FROM empleados;

-- 21. Mostrar el nombre del último empleado de la lista por orden alfabético.
SELECT nombre
FROM empleados
ORDER BY nombre DESC 
LIMIT 1;

-- 22. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
SELECT 
MAX(sal_emp) AS salario_max,
MIN(sal_emp) AS salario_min,
MAX(sal_emp)-MIN(sal_emp) AS diferecia_salario
FROM empleados;

-- 23. Hallar el salario promedio por departamento.
SELECT id_depto, round(avg(sal_emp))
FROM empleados
group by id_depto;

-- Consultas con Having
-- 24. Hallar los departamentos que tienen más de tres empleados. Mostrar el número de empleados de esos departamentos.
SELECT id_depto, COUNT(*) AS Num_Empleados
FROM empleados
GROUP BY id_depto
HAVING count(*)>3;

SELECT id_depto, COUNT(id_emp) as 'Numero de empleados' 
FROM personal.empleados 
GROUP BY id_depto 
HAVING COUNT(id_emp) > 3;

SELECT d.nombre_depto, COUNT(e.id_emp) AS num_empleados
FROM departamentos d 
INNER JOIN empleados e ON d.id_depto = e.id_depto 
GROUP BY d.nombre_depto 
HAVING COUNT(e.id_emp) > 3;

-- 25. Mostrar el código y nombre de cada jefe, junto al número de empleados que
-- dirige. Solo los que tengan más de dos empleados (2 incluido). NOOOOOOOOSEEEEEE
SELECT e.nombre AS 'Nombre empleado', d.nombre_depto AS 'Departamento', d.nombre_jefe_depto AS 'Jefe departamento' 
FROM personal.empleados e 
JOIN personal.departamentos d 
ON e.id_depto = d.id_depto;

SELECT e.nombre AS 'Nombre empleado', d.nombre_depto AS 'Departamento', d.nombre_jefe_depto AS 'Jefe departamento' 
FROM personal.empleados e 
JOIN personal.departamentos d 
ON e.id_depto = d.id_depto
ORDER BY d.nombre_jefe_depto ASC;

SELECT e.nombre AS 'Nombre empleado', d.nombre_depto AS 'Departamento', d.nombre_jefe_depto AS 'Jefe departamento' 
FROM personal.empleados e 
JOIN personal.departamentos d 
ON e.id_depto = d.id_depto
GROUP BY d.id_depto
HAVING COUNT(*) > 2
ORDER BY d.nombre_jefe_depto ASC;

-- 26. Hallar los departamentos que no tienen empleados NOOOOOOSEEEEE
SELECT d.id_depto, d.nombre_depto
FROM departamentos d
LEFT JOIN empleados e ON d.id_depto = e.id_depto
WHERE e.id_depto IS NULL;

SELECT 
d.id_depto, d.nombre_depto
FROM departamentos d
WHERE D.id_depto not in 
(SELECT e.id_depto 
FROM empleados e
WHERE e.id_depto=d.id_depto);

SELECT d.nombre_depto 
FROM departamentos d 
LEFT JOIN empleados e ON d.id_depto = e.id_depto 
WHERE e.id_emp IS NULL;

-- Consulta con Subconsulta
-- 27. Mostrar la lista de los empleados cuyo salario es mayor o igual que el promedio
-- de la empresa. Ordenarlo por departamento.
SELECT e.nombre AS Nombre, e.sal_emp AS Salario, d.nombre_depto AS Departamento
FROM empleados e
INNER JOIN departamentos d ON e.id_depto = d.id_depto
WHERE e.sal_emp >= (
    SELECT AVG(sal_emp)
    FROM empleados
)
ORDER BY e.id_depto;

SELECT * FROM personal.empleados 
WHERE sal_emp >= (SELECT AVG(sal_emp)
 FROM personal.empleados) 
ORDER BY id_depto;
