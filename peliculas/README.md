# Service Base Movies
    Aplicacion backend para el catalogo de peliculas y sus categorias.

# Tecnologias Utilizadas

    * Spring boot: https://spring.io/projects/spring-boot
    * JPA
    * Lombook
    * Commons validator: https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
    * Junit y mockito
    * Java 1 
    * MySQL
    * Arquitectura Limpia: puertos y adaptadores
    

# Requisitos Previos
    para ejecutar el proyecto (por ejemplo, tener instalado Java JDK versión 17, MySQL 8, etc.).
	1. Instalar Intellij Idea ( puede ser el Community Edition ) https://www.jetbrains.com/es-es/idea/download/#section=windows
	2. Verificar si se tiene instalado el PLUGIN de Lombok para el Intellij y si no se tiene, instalarlo ( Files -> Settings -> Plugins )
	3. Verificar si se tiene instalado el PLUGIN de Maven para el Intellij y si no se tiene, instalarlo ( Files -> Settings -> Plugins )    
    4. Descargar el repositorio : https://github.com/alexbreiner/catalogo_peluculas
	5. Abrir nuestro proyecto en Intellij Idea.
    6. Para descargar las dependencias, es necesario que de build al proyecto dependiedo el gestor.
	7. Dirigirse a derecha superior, donde se podra ver una pequeña pestaña de Maven. Abrirla y presionar en el simbolo de refrescar. Esto con la intencion de que se descarguen todas las dependencias necesarias.
	8. Una vez todo esta listo, en la pestaña del punto 6, nos dirigimos a parte superior derecha para darle  RUN. Nuestra aplicación estará disponible en http://localhost:8080/api 
	   si se desea un contexto diferente a "api", puede cambiarse en el archivo de configuraci�n "application.yml" que est� dentro de la carpeta de recursos del proyecto principal.

# Api Rest
    1. Obtener la lista completa de películas (el endpoint debe tener paginación dinámica).
        * metodo Get:
             @GetMapping("/peliculas")
             * parametros:
                1. pageSize.
                2. pageNumber.
                3. sort.dir. required = false
                4. sort. required = false
             Api:  
                http://localhost:8080/api/peliculas?pageSize=3&pageNumber=0
    2. Agregar una nueva película.
        * metodo Post:@PostMapping("/pelicula")
             Api:             
                http://localhost:8080/api/pelicula
    3. Obtener detalles de una película específica.
        * metodo Get:@GetMapping("/pelicula/{id}")
            Api:
                http://localhost:8080/api/pelicula/2          
    4. Buscar por categoria, puntuacion, y duracion
        * Metodo Get: @GetMapping("/pelicula/filtrar")
             * parametros:
                1. CategoriaId.
                2. Puntuacion.
                3. Duracion
             Api:
                http://localhost:8080/api/pelicula/filtrar?categoriaId=1&puntuacion=3&duracion=2

# Buenas Practicas de Codificación
    * Claridad sobre rendimiento: Asegúrate de que tu código es tan claro como sea posible. La legibilidad a menudo es más importante que la optimización de rendimiento.
    * Consistencia: Sigue un conjunto consistente de nombres y estructuras de codificación a lo largo de tu proyecto.
    * Convenciones de Java: Sigue las convenciones de codificación estándar de Java para nombres de clases, métodos, variables y otras construcciones.
    * Principios SOLID: Aplica los principios de diseño SOLID para crear un código más limpio, extensible y mantenible.
    * Manejo de Excepciones: Utiliza un manejo de excepciones coherente y significativo.
    * Control de versiones: Utiliza control de versiones y mantén un historial limpio con mensajes de commit claros y descriptivos.
    * Pruebas: Incluye pruebas unitarias y de integración para asegurarte de que tu código funciona como se espera y para prevenir regresiones.