SELECT `equipos`.`Nombre`,
    `equipos`.`Ciudad`,
    `equipos`.`Conferencia`,
    `equipos`.`Division`
FROM `nba`.`equipos`;
SELECT `estadisticas`.`temporada`,
    `estadisticas`.`jugador`,
    `estadisticas`.`Puntos_por_partido`,
    `estadisticas`.`Asistencias_por_partido`,
    `estadisticas`.`Tapones_por_partido`,
    `estadisticas`.`Rebotes_por_partido`
FROM `nba`.`estadisticas`;
SELECT `jugadores`.`codigo`,
    `jugadores`.`Nombre`,
    `jugadores`.`Procedencia`,
    `jugadores`.`Altura`,
    `jugadores`.`Peso`,
    `jugadores`.`Posicion`,
    `jugadores`.`Nombre_equipo`
FROM `nba`.`jugadores`;
SELECT `partidos`.`codigo`,
    `partidos`.`equipo_local`,
    `partidos`.`equipo_visitante`,
    `partidos`.`puntos_local`,
    `partidos`.`puntos_visitante`,
    `partidos`.`temporada`
FROM `nba`.`partidos`;

drop table if exists cliente;

-- 1. Mostrar el nombre de todos los jugadores ordenados alfabéticamente.
SELECT Nombre, Peso, Posicion
FROM jugadores
WHERE Posicion='C' AND Peso>200
GROUP BY Nombre ASC;

-- 2. Mostrar el nombre de los jugadores que sean pivots (‘C’) y que pesen más de 200
-- libras, ordenados por nombre alfabéticamente.
SELECT Nombre
FROM jugadores
GROUP BY Nombre ASC;

-- 3. Mostrar el nombre de todos los equipos ordenados alfabéticamente.
SELECT *
FROM equipos
GROUP BY Nombre ASC;

-- 4. Mostrar el nombre de los equipos del este (East).
SELECT Nombre, Conferencia
FROM equipos
WHERE Conferencia='East';

-- 5. Mostrar los equipos donde su ciudad empieza con la letra ‘c’, ordenados por nombre.
SELECT Nombre, Ciudad
FROM equipos
WHERE Ciudad LIKE 'C%'
ORDER BY Nombre ASC;

SELECT Nombre, Ciudad
FROM equipos
WHERE LEFT(`Ciudad`, 1) = 'C'
ORDER BY Nombre ASC;

-- 6. Mostrar todos los jugadores y su equipo ordenados por nombre del equipo.
SELECT Nombre, Nombre_equipo
FROM jugadores
ORDER BY Nombre_equipo ASC;

-- 7. Mostrar todos los jugadores del equipo “Raptors” ordenados por nombre.
SELECT Nombre, Nombre_equipo
FROM jugadores
WHERE Nombre_equipo LIKE 'Raptors'
ORDER BY Nombre ASC;

-- 8. Mostrar los puntos por partido del jugador ‘Pau Gasol’.
SELECT e.Temporada, e.Puntos_por_partido, e.jugador, j.nombre
FROM estadisticas e
INNER JOIN jugadores j ON e.jugador = j.codigo
WHERE j.Nombre LIKE 'Pau Gasol';

SELECT e.temporada,
       j.Nombre AS Nombre_del_jugador,
       e.Puntos_por_partido
FROM estadisticas AS e
INNER JOIN jugadores AS j ON e.jugador = j.codigo
WHERE j.Nombre = 'Pau Gasol';

-- 9. Mostrar los puntos por partido del jugador ‘Pau Gasol’ en la temporada ’04/05′.
SELECT e.temporada,
       j.Nombre AS Nombre_del_jugador,
       e.Puntos_por_partido
FROM estadisticas AS e
INNER JOIN jugadores AS j ON e.jugador = j.codigo
WHERE j.Nombre = 'Pau Gasol' AND e.temporada='04/05' ;

-- 10. Mostrar el número de puntos de cada jugador en toda su carrera.
SELECT  ROUND(sum(e.Puntos_por_partido)) AS puntos_en_su_carrera, 
		j.Nombre AS Nombre_del_jugador
FROM estadisticas AS e
INNER JOIN jugadores AS j ON e.jugador = j.codigo
GROUP BY j.nombre 
ORDER BY puntos_en_su_carrera DESC; 

SELECT j.Nombre AS `Nombre del Jugador`,
       SUM(e.Puntos_por_partido) AS `Puntos en Toda la Carrera`
FROM estadisticas AS e
INNER JOIN jugadores AS j ON e.jugador = j.codigo
GROUP BY j.Nombre
ORDER BY `Puntos en Toda la Carrera` DESC;

-- 11. Mostrar el número de jugadores de cada equipo.
SELECT Nombre_equipo, COUNT(*) AS `Número de Jugadores`
FROM jugadores
GROUP BY Nombre_equipo
ORDER BY `Número de Jugadores` ASC;

-- 12. Mostrar el jugador que más puntos ha realizado en toda su carrera.
SELECT  ROUND(sum(e.Puntos_por_partido)) AS puntos_en_su_carrera, 
		j.Nombre AS Nombre_del_jugador
FROM estadisticas AS e
INNER JOIN jugadores AS j ON e.jugador = j.codigo
GROUP BY j.nombre 
ORDER BY puntos_en_su_carrera DESC
LIMIT 5; 

-- 13. Mostrar el nombre del equipo, conferencia y división del jugador más alto de la NBA.
SELECT `Nombre` AS `Nombre del Equipo`, `Conferencia`, `Division`
FROM `equipos`
WHERE `Nombre` = 'NBA'; -- NO EXISTE NBA

SELECT Nombre, Altura, Nombre_equipo
FROM jugadores
WHERE `Nombre_equipo` = 'NBA'
ORDER BY Altura DESC
LIMIT 1;

-- 14. Mostrar la media de puntos en partidos de los equipos de la división Pacific.
SELECT DISTINCT `Nombre`
FROM `equipos`
WHERE `Division` = 'Pacific';

SELECT AVG(`Puntos`) AS `Media de Puntos en Partidos`
FROM (
  SELECT `puntos_local` AS `Puntos`
  FROM `nba`.`partidos`
  WHERE `equipo_local` IN (
    SELECT DISTINCT `Nombre`
    FROM `equipos`
    WHERE `Division` = 'Pacific'
  )
  
  UNION ALL
  
  SELECT `puntos_visitante` AS `Puntos`
  FROM `nba`.`partidos`
  WHERE `equipo_visitante` IN (
    SELECT DISTINCT `Nombre`
    FROM `equipos`
    WHERE `Division` = 'Pacific'
  )
) AS PuntosPacific;

-- 15. Mostrar el partido o partidos (equipo_local, equipo_visitante y diferencia) con mayor diferencia de puntos.
SELECT `equipo_local`, `equipo_visitante`, ABS(`puntos_local` - `puntos_visitante`) AS `Diferencia`
FROM `partidos`
WHERE ABS(`puntos_local` - `puntos_visitante`) = (
  SELECT MAX(ABS(`puntos_local` - `puntos_visitante`))
  FROM `partidos`
);

-- 16. Mostrar la media de puntos en partidos de los equipos de la división Pacific.
SELECT AVG(Puntos) AS `Media de Puntos en Partidos de la División Pacific`
FROM (
  SELECT `puntos_local` AS Puntos
  FROM `partidos` AS p
  INNER JOIN `equipos` AS e ON p.`equipo_local` = e.`Nombre`
  WHERE e.`Division` = 'Pacific'
  
  UNION ALL
  
  SELECT `puntos_visitante` AS Puntos
  FROM `partidos` AS p
  INNER JOIN `equipos` AS e ON p.`equipo_visitante` = e.`Nombre`
  WHERE e.`Division` = 'Pacific'
) AS PuntosPacific;

-- 17. Mostrar los puntos de cada equipo en los partidos, tanto de local como de visitante.
SELECT codigo, equipo_local, equipo_visitante,puntos_local, puntos_visitante, temporada
FROM partidos;
SELECT
    `codigo`,
    `equipo_local` AS `Nombre del Equipo`,
    `puntos_local` AS `Puntos`,
    `temporada`
FROM `partidos`
UNION ALL
SELECT
    `codigo`,
    `equipo_visitante` AS `Nombre del Equipo`,
    `puntos_visitante` AS `Puntos`,
    `temporada`
FROM `partidos`;

-- 18. Mostrar quien gana en cada partido (codigo, equipo_local, equipo_visitante, equipo_ganador), en caso de empate sera null.
SELECT `codigo`, `equipo_local`,`equipo_visitante`,
    CASE
        WHEN `puntos_local` > `puntos_visitante` THEN `equipo_local`
        WHEN `puntos_local` < `puntos_visitante` THEN `equipo_visitante`
        ELSE NULL
    END AS `equipo_ganador`
FROM `partidos`;