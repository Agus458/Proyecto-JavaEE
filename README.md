# Proyecto-JavaEE

En el último año la industria de los videojuegos tuvo gran crecimiento, en parte por la
pandemia que obliga a las personas a permanecer en sus casas y por otro lado la gran
variedad de juegos disponibles. En particular en los últimos años han surgido muchos juegos
desarrollados por estudios pequeños y desconocidos o incluso desarrollados por una sola
persona.

En función de esto la empresa “SteamIndie” decidió desarrollar una plataforma web que
permita a los desarrolladores ofrecer sus juegos, a la vez que permite a los jugadores comprar
juegos y formar una comunidad con sus pares.

La plataforma ofrecerá a los usuarios la posibilidad de crear su perfil y poder interactuar con
otros usuarios. A su vez, estos podrán comprar juegos, de los cuales recibirán un enlace de
descarga, y mantener un registro (biblioteca) de los juegos comprados. Como parte del sentido
de comunidad, los jugadores podrán calificar los videojuegos que hayan comprado y dejar un
comentario sobre el juego que puede ser visualizado por otros jugadores.

A la hora de ofrecer los videojuegos, la plataforma ofrece un servicio de búsqueda que permite
buscar juegos por su nombre, por categoría o por tags personalizados de los usuarios. Los
usuarios contarán con su propia billetera en el sitio que utilizaran para comprar los videojuegos.
Esta podrán cargarla a través de tarjetas de crédito, Paypal o Google Wallet.

Para los creadores de videojuegos la empresa ofrece la posibilidad de publicar sus juegos. Las
publicaciones pueden incluir la descripción del juego, imágenes y videos promocionales.
También ofrecen la posibilidad de suscribirse a programas de ofertas o giveaways ofrecidos por
la plataforma.

La plataforma cobrará a los creadores de videojuegos un porcentaje de sus ventas, en principio
este porcentaje está estipulado en 10%.

El sistema deberá contar con dos módulos. Por un lado el backoffice para administración
general de la plataforma por parte de personal de SteamIndie. Y por otro lado un frontoffice
que permita a los usuarios (jugadores y creadores) acceder al contenido. A su vez interesa
que todas las funcionalidades del frontoffice se puedan acceder desde cualquier dispositivo.
A futuro está planeado el desarrollo de una aplicación móvil.

## Instalación:
```
Link al video tutorial: https://youtu.be/KP6ZDUXGddo

Instalar Eclipse IDE
	https://www.eclipse.org/downloads/
Abrir proyectos
	Esperar a que se abran

Propiedades central
	JPA
		Descargar eclipse link 2.5.2
			https://www.eclipse.org/downloads/download.php?file=/rt/eclipselink/releases/2.5.2/eclipselink-2.5.2.v20140319-9ad6abd.zip
		Agregar libreria eclipse link
			Downloads\eclipselink\jlib\eclipselink.jar
			Downloads\eclipselink\jlib\jpa\javax.persistence_2.1.0.v201304241213
		Marcar la librería con un tic
		Abrir XAMPP
			Iniciar Apache y MySQL
			Crear la base de datos
				http://localhost/phpmyadmin/index.php
				Nombre: steamindiedb
				Cotejamiento: utf8_unicode_ci
		Add conection
		Descargar mysql connector
			https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.25
		MySQL
		Nuevo Driver
			Name/Type: MySQL JDBC Driver v5.1
			JAR list: Borramos la default y agregamos la que descargamos anteriormente
			Properties: Cambiamos "database" por "steamindiedb"
		Test connection
	Java Compiler
		Window->Preferences->compiler->Compiler Compliance level 1.8
		Window->Preferences->Installed JREs
			Add->Stardard VM->Next
			Descargar JDK 8
				https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
			Agregar al JRE home la carpeta del jdk
	JPA->Generate tables from entities
	Maven->Download sources
	Maven->Update Project
Web
	Descargar apache tomcat 8.5
		https://tomcat.apache.org/download-80.cgi
	Servers->Create server->tomcat v8.5->Agregar la carpeta del tomcat descargada->next->add
	new web service client->service definition->http://localhost:1515/SteamIndieWS?wsdl->finish
	project facets->runtimes->Apache Tomcat v8.5
	run SteamIndieCentral/web_service/SteamIndiePublisher as java aplication
	windows->web browser->chrome
	run SteamIndieWeb on server
 
```
