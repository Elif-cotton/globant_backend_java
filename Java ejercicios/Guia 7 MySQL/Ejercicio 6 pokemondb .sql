-- 1. Mostrar el nombre de todos los pokemon.
SELECT nombre, peso
FROM pokemon
Order BY nombre ASC;

-- 2. Mostrar los pokemon que pesen menos de 10k.
SELECT nombre, peso
FROM pokemon
WHERE peso <10.0
ORDER BY peso ASC;

-- 3. Mostrar los pokemon de tipo agua.
SELECT p.numero_pokedex, p.nombre, p.peso, p.altura, t.nombre
FROM pokemon p
JOIN pokemon_tipo pt ON p.numero_pokedex = pt.numero_pokedex
JOIN tipo t ON pt.id_tipo = t.id_tipo
WHERE t.nombre = 'Agua';
SELECT `tipo`.`id_tipo`,
    `tipo`.`nombre`,
    `tipo`.`id_tipo_ataque`
FROM `pokemondb`.`tipo`;
SELECT `pokemon_tipo`.`numero_pokedex`,
    `pokemon_tipo`.`id_tipo`
FROM `pokemondb`.`pokemon_tipo`;
SELECT `pokemon`.`numero_pokedex`,
    `pokemon`.`nombre`,
    `pokemon`.`peso`,
    `pokemon`.`altura`
FROM `pokemondb`.`pokemon`;

-- 4. Mostrar los pokemon de tipo agua, fuego o tierra ordenados por tipo.
SELECT p.numero_pokedex, p.nombre, p.peso, p.altura, t.nombre
FROM pokemon p
JOIN pokemon_tipo pt ON p.numero_pokedex = pt.numero_pokedex
JOIN tipo t ON pt.id_tipo = t.id_tipo
WHERE t.nombre IN ( 'Agua','Fuego','Tierra');

-- 5. Mostrar los pokemon que son de tipo fuego y volador.
SELECT p.numero_pokedex, p.nombre, p.peso, p.altura, t.nombre
FROM pokemon p
JOIN pokemon_tipo pt ON p.numero_pokedex = pt.numero_pokedex
JOIN tipo t ON pt.id_tipo = t.id_tipo
WHERE t.nombre IN ( 'Fuego','Volador');
-- 6. Mostrar los pokemon con una estadística base de ps mayor que 200.
SELECT *
FROM estadisticas_base;
SELECT  p.numero_pokedex, p.nombre, p.peso, p.altura, eb.ps
FROM pokemon p
JOIN estadisticas_base eb ON p.numero_pokedex = eb.numero_pokedex
WHERE eb.ps >200;

-- 7. Mostrar los datos (nombre, peso, altura) de la prevolución de Arbok.
SELECT  numero_pokedex, nombre, peso, altura 
FROM pokemon 
WHERE nombre= 'Arbok';

select p.nombre, p.altura, p.peso
from pokemon p, evoluciona_de ev
where p.numero_pokedex = ev.pokemon_origen
and ev.pokemon_evolucionado = (select numero_pokedex 
                    from pokemon 
                    where LOWER(nombre) = 'arbok');
-- La función LOWER es una función en SQL (Structured Query Language) que se utiliza para convertir un valor
--  de texto (cadena de caracteres) en minúsculas. 
-- 8. Mostrar aquellos pokemon que evolucionan por intercambio.
SELECT *
FROM tipo_evolucion;
SELECT p.numero_pokedex, p.nombre, p.peso, p.altura, te.tipo_evolucion
FROM pokemon p
JOIN pokemon_tipo pt ON p.numero_pokedex = pt.numero_pokedex
JOIN tipo_evolucion te ON pt.id_tipo = te.id_tipo_evolucion
WHERE tipo_evolucion= 'Intercambio'; 

-- 9. Mostrar el nombre del movimiento con más prioridad.
SELECT nombre
FROM movimiento
WHERE prioridad = (SELECT MAX(prioridad) FROM movimiento);
SELECT *
from movimiento
order by prioridad desc;
-- 10. Mostrar el pokemon más pesado.
SELECT nombre, peso
FROM pokemon
WHERE peso = (SELECT MAX(peso) FROM pokemon);

SELECT nombre, peso
FROM pokemon
ORDER BY peso DESC
LIMIT 2;

SELECT nombre, peso
FROM pokemon
ORDER BY peso DESC;

-- 11. Mostrar el nombre y tipo del ataque con más potencia.
SELECT m.nombre AS nombre_ataque, t.nombre AS tipo_ataque, m.potencia
FROM movimiento AS m
JOIN (
    SELECT MAX(potencia) AS max_potencia
    FROM movimiento
) AS subquery ON m.potencia = subquery.max_potencia
JOIN tipo AS t ON m.id_tipo = t.id_tipo;

-- 12. Mostrar el número de movimientos de cada tipo.
SELECT t.nombre AS tipo, COUNT(*) AS cantidad_de_movimientos
FROM movimiento AS m
JOIN tipo AS t ON m.id_tipo = t.id_tipo
GROUP BY t.nombre;
SELECT `movimiento`.`id_movimiento`,
    `movimiento`.`nombre`,
    `movimiento`.`potencia`,
    `movimiento`.`precision_mov`,
    `movimiento`.`descripcion`,
    `movimiento`.`pp`,
    `movimiento`.`id_tipo`,
    `movimiento`.`prioridad`
FROM `pokemondb`.`movimiento`;

-- 13. Mostrar todos los movimientos que puedan envenenar.NOSE
SELECT id_movimiento, nombre
FROM movimiento
WHERE descripcion LIKE '%envenenar%';

-- 14. Mostrar todos los movimientos que causan daño, ordenados alfabéticamente por nombre.
SELECT nombre, potencia
FROM movimiento
WHERE potencia>0
ORDER BY nombre ASC;
-- 15. Mostrar todos los movimientos que aprende pikachu.
select distinct m.nombre
from movimiento m, pokemon p, pokemon_movimiento_forma pmf
where p.numero_pokedex = pmf.numero_pokedex and pmf.id_movimiento = m.id_movimiento
and lower(p.nombre) = 'pikachu';
-- 16. Mostrar todos los movimientos que aprende pikachu por MT (tipo de aprendizaje).
select distinct m.nombre
from movimiento m, pokemon p, pokemon_movimiento_forma pmf, forma_aprendizaje fa, tipo_forma_aprendizaje tfa
where p.numero_pokedex = pmf.numero_pokedex 
and pmf.id_movimiento = m.id_movimiento
and pmf.id_forma_aprendizaje = fa.id_forma_aprendizaje
and fa.id_tipo_aprendizaje = tfa.id_tipo_aprendizaje
and lower(tfa.tipo_aprendizaje) = 'mt'
and lower(p.nombre) = 'pikachu';
-- 17. Mostrar todos los movimientos de tipo normal que aprende pikachu por nivel.
select distinct m.nombre
from movimiento m, pokemon p, 
pokemon_movimiento_forma pmf, 
forma_aprendizaje fa, 
tipo_forma_aprendizaje tfa,
tipo t
where p.numero_pokedex = pmf.numero_pokedex 
and pmf.id_movimiento = m.id_movimiento
and pmf.id_forma_aprendizaje = fa.id_forma_aprendizaje
and fa.id_tipo_aprendizaje = tfa.id_tipo_aprendizaje
and m.id_tipo = t.id_tipo
and lower(t.nombre) = 'normal'
and lower(tfa.tipo_aprendizaje) = 'nivel'
and lower(p.nombre) = 'pikachu';
-- 18. Mostrar todos los movimientos de efecto secundario cuya probabilidad sea mayor al 30%.
SELECT m.nombre, ms.probabilidad
FROM movimiento as m
INNER JOIN movimiento_efecto_secundario as ms ON m.id_movimiento=ms.id_movimiento
WHERE ms.probabilidad>30;

-- 19. Mostrar todos los pokemon que evolucionan por piedra.
create or replace view pokemon_evolucion_piedra as
select distinct p.numero_pokedex, p.nombre
from pokemon p, pokemon_forma_evolucion pfe, 
forma_evolucion fe, tipo_evolucion te
where p.numero_pokedex = pfe.numero_pokedex 
and pfe.id_forma_evolucion = fe.id_forma_evolucion
and fe.tipo_evolucion = te.id_tipo_evolucion
and lower(te.tipo_evolucion) = 'piedra';
select * from pokemon_evolucion_piedra;
-- 20. Mostrar todos los pokemon que no pueden evolucionar.
create or replace view pokemon_no_evolucionan as
select p.numero_pokedex, p.nombre
from pokemon p, evoluciona_de ev
where p.numero_pokedex = ev.pokemon_evolucionado
and not exists (select pokemon_origen from evoluciona_de where pokemon_origen = p.numero_pokedex)
union
select p.numero_pokedex, p.nombre
from pokemon p
where not exists (select * 
                    from evoluciona_de 
                    where pokemon_origen = p.numero_pokedex or pokemon_evolucionado = p.numero_pokedex);
                    
select * from pokemon_no_evolucionan;
-- 21. Mostrar la cantidad de los pokemon de cada tipo.
SELECT t.nombre AS tipo, COUNT(*) AS cantidad_de_pokemon
FROM pokemon_tipo AS pt
JOIN pokemon AS p ON pt.numero_pokedex = p.numero_pokedex
JOIN tipo AS t ON pt.id_tipo = t.id_tipo
GROUP BY t.nombre;