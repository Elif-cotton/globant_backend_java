-- Tenemos que adivinar la clave y posición de una caja fuerte. El cerrojo consta de 4 candados, cada candado tiene de 
-- clave, un número que puede ser de más de 1 cifra y una posición que puede ir desde 1 a 4.
-- Nosotros tenemos los 4 candados en la mano (Candado A, Candado B, Candado C y Candado D) debemos averiguar la
--  posición de cada candado y la clave del mismo.

-- CANDADO A
-- Posición: El candado A está ubicado en la posición calculada a partir del número obtenido en la/s siguiente/s consulta/s:
-- Teniendo el máximo de asistencias por partido, muestre cuantas veces se logró dicho máximo. Este resultado nos dará
-- la posición del candado (1, 2, 3 o 4)
SELECT COUNT(*) AS cuantas_max_asistencia
FROM estadisticas
WHERE asistencias_por_partido = (
	SELECT MAX(asistencias_por_partido)
	FROM estadisticas
    );
    
-- Resultado Posición A 2 
SELECT COUNT(*) AS veces_max_asistencias
FROM (
  SELECT MAX(Asistencias_por_partido) AS max_asistencias
  FROM estadisticas
) AS max_asistencias_global
JOIN estadisticas ON estadisticas.Asistencias_por_partido = max_asistencias_global.max_asistencias;
-- Clave: La clave del candado A estará con formada por la/s siguientes consulta/s a la base de datos:
-- Muestre la suma total del peso de los jugadores, donde la conferencia sea Este y la posición sea centro o esté 
-- comprendida en otras posiciones.
SELECT SUM(j.Peso) as suma_peso_Jugadores
FROM jugadores as j
INNER JOIN equipos as e ON j.Nombre_equipo= e.Nombre
WHERE e.Conferencia like 'East' and j.Posicion LIKE '%C%';

-- Resultado clave A 14043
SELECT *
FROM jugadores;
SELECT *
FROM equipos;

-- CANDADO B
-- Posición: El candado B está ubicado en la posición calculada a partir del número obtenido en la/s siguiente/s consulta/s:
-- Muestre la cantidad de jugadores que poseen más asistencias por partidos, que el número de jugadores que tiene 
-- el equipo Heat. Este resultado nos dará la posición del candado (1, 2, 3 o 4)
SELECT COUNT(*) AS jugadores_mas_asistencia
FROM jugadores as j
INNER JOIN estadisticas as e ON e.jugador=j.codigo
WHERE e.Asistencias_por_partido >(
	SELECT count(*)
    FROM jugadores
    WHERE Nombre_equipo='Heat');
SELECT *
FROM jugadores;


SELECT COUNT(*) AS jugadores_con_mas_asistencias
FROM jugadores j
JOIN estadisticas e ON j.codigo = e.jugador
JOIN equipos eq ON j.Nombre_equipo = eq.Nombre
WHERE e.Asistencias_por_partido > (
  SELECT COUNT(*) 
  FROM jugadores
  WHERE Nombre_equipo = 'Heat'
);

-- Resultado Posición B 3

-- Clave: La clave del candado B estará con formada por la/s siguientes consulta/s a la base de datos:
-- La clave será igual al conteo de partidos jugados durante las temporadas del año 1999.
SELECT COUNT(*) AS cantidad_partidos_jugados
FROM partidos
WHERE temporada LIKE '%99%';

-- Resultado clave B 3480

-- CANDADO C
-- Posición: El candado C está ubicado en la posición calculada a partir del número obtenido en la/s siguiente/s consulta/s:
-- La posición del código será igual a la cantidad de jugadores que proceden de Michigan y forman
-- parte de equipos de la conferencia oeste.
-- Al resultado obtenido lo dividiremos por la cantidad de jugadores cuyo peso es mayor o igual a
-- 195, y a eso le vamos a sumar 0.9945. Este resultado nos dará la posición del candado (1, 2, 3 o 4)
SELECT 
    (SELECT 
            (SELECT 
                        COUNT(*)
                    FROM
                        jugadores j
                            INNER JOIN
                        equipos e ON j.nombre_equipo = e.nombre
                    WHERE
                        j.procedencia = 'Michigan'
                            AND e.conferencia = 'West') / (SELECT 
                        COUNT(*)
                    FROM
                        jugadores
                    WHERE
                        peso >= 195)
        ) + 0.9945 AS posicionC;
        
-- Resultado posición C 1

-- Clave: La clave del candado B estará con formada por la/s siguientes consulta/s a la base de datos:
-- Para obtener el siguiente código deberás redondear hacia abajo el resultado que se devuelve de sumar: el promedio 
-- de puntos por partido, el conteo de asistencias por partido, y la suma de tapones por partido. Además, este
--  resultado debe ser, donde la división sea central.
SELECT  FLOOR(AVG(e.puntos_por_partido) + COUNT(e.asistencias_por_partido) + SUM(e.tapones_por_partido)) AS claveC
FROM estadisticas e
INNER JOIN jugadores j ON e.jugador = j.codigo
INNER JOIN equipos eq ON j.nombre_equipo = eq.nombre
WHERE eq.division = 'Central';

-- Resultado clave C 631

-- CANDADO D
-- Posición: El candado D está ubicado en la posición calculada a partir del número obtenido en la/s siguiente/s consulta/s:
-- Muestre los tapones por partido del jugador Corey Maggette durante la temporada 00/01. Este resultado debe 
-- ser redondeado. Nota: el resultado debe estar redondeado Este resultado nos dará la posición del candado (1, 2, 3 o 4)
SELECT ROUND(e.tapones_por_partido) AS posicionD
FROM estadisticas e
INNER JOIN jugadores j ON e.jugador = j.codigo
INNER JOIN equipos eq ON j.nombre_equipo = eq.nombre
INNER JOIN partidos p ON eq.nombre = p.equipo_local
        OR eq.nombre = p.equipo_visitante
WHERE j.nombre = 'Corey Maggette'
        AND p.temporada = '00/01';
        
-- Resultado Posición D es 4
-- Clave: La clave del candado D estará con formada por la/s siguientes consulta/s a la base de datos:
-- Para obtener el siguiente código deberás redondear hacia abajo, la suma de puntos por partido de todos los 
-- jugadores de procedencia argentina.
SELECT 
    FLOOR(SUM(puntos_por_partido)) AS claveD
FROM
    estadisticas e
        INNER JOIN
    jugadores j ON e.jugador = j.codigo
WHERE
    j.procedencia = 'Argentina';
    
-- Resultado es clave D 191

-- RESULTADOS
-- Resultado Posición A 2 
-- Resultado clave A 14043
-- Resultado Posición B 3
-- Resultado clave B 3480
-- Resultado posición C 1
-- Resultado clave C 631
-- Resultado Posición D es 4
-- Resultado es clave D 191