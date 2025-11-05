# Servidor

Un servidor es un equipo (físico o virtual) que **almacena, procesa y envía información a otros dispositivos llamados** clientes (como tu PC, tu celular o una aplicación). El servidor "sirve" datos y servicios

- Cuando abres YouTube → un servidor te envía los videos
- Cuando abres WhatsApp → un servidor guarda y entrega tus mensajes
- Cuando haces login en una web → un servidor verifica tus datos

## Tipos de server

| Tipo                   | Función                                          |
| ---------------------- | ------------------------------------------------ |
| **Web server**         | Sirve páginas web (Nginx, Apache)                |
| **Database server**    | Guarda y gestiona datos (MySQL, PostgreSQL)      |
| **Application server** | Ejecuta lógica de negocio (Spring Boot, Node.js) |
| **File server**        | Comparte archivos                                |
| **Mail server**        | Maneja correos electrónicos                      |
| **DNS server**         | Convierte nombres como google.com a IPs          |
| **Cloud server**       | Servidor hospedado en la nube (AWS, Azure, GCP)  |

## Características 
| Concepto   | Significado                                  |
| ---------- | -------------------------------------------- |
| IP         | Dirección única                              |
| Puertos    | Canales de comunicación (e.g. 80, 443, 5432) |
| Protocolos | Reglas (HTTP, HTTPS, FTP, SSH)               |
| Uptime     | Tiempo activo sin caerse                     |

## Seguridad básica de servidores

Cuando despliegas una aplicación (Spring Boot, Node, etc.), debes proteger el servidor donde corre. Aquí entran cuatro pilares:

- Firewall - Controla qué tráfico puede entrar o salir del servidor.
- SSL / HTTPS - Cifrar comunicación entre usuario y servidor (Evita espionaje, robo de contraseñas, manipulación de datos).
- Control de acceso (roles, permisos) - Viene definido dentro de la lógica de la app.
- Actualizaciones y parches - Un servidor desactualizado es vulnerable.

## Ejecución de programa SB
Ejecutar una aplicación que **actúa como servidor, exponiendo endpoints** para que otros (navegadores, apps, servicios) puedan enviar peticiones y recibir respuestas.

Spring Boot trae un servidor web embebido (por defecto Tomcat), así que tú no necesitas instalarlo aparte. Cuando ejecutas tu app, ya estás montando un servidor.

### Cuando corres tu app (por ejemplo con mvn spring-boot:run o desde el IDE):

- Spring Boot levanta el servidor interno (Tomcat/Jetty/Undertow)
- Abre un puerto, normalmente 8080
- Registra tus controladores (@RestController)
- Empieza a aceptar solicitudes HTTP
- Es decir, tu programa se convierte en un servidor REST.

| Concepto           | En Spring Boot                         |
| ------------------ | -------------------------------------- |
| Montar un servidor | Ejecutar la app que escucha peticiones |
| Servidor web       | Tomcat embebido                        |
| Cliente            | Web, móvil, Postman, fetch, etc.       |
| URL en local       | `http://localhost:8080/...`            |

## `server.address=0.0.0.0`

Estás indicando que el servidor embebido (Tomcat, Jetty, etc) debe escuchar en todas las interfaces de red disponibles de la máquina.

0.0.0.0 = Escucha en todas las direcciones IP del servidor.

La aplicación aceptará conexiones:

- desde localhost (127.0.0.1)
- desde cualquier IP privada de la máquina (por ejemplo 192.168.x.x)
- desde cualquier IP pública si existe una interfaz y reglas de red que lo permitan

## Servidor en la nube vs Srverless

| Servidor en la nube (VM)       | Serverless                                      |
| ------------------------------ | ----------------------------------------------- |
| Tú administras el servidor     | Tú solo subes tu lógica/código                  |
| Siempre está encendido         | Solo se ejecuta cuando alguien lo usa           |
| Pagas por tiempo encendido     | Pagas por uso (requests, segundos de ejecución) |
| Debes aplicar parches/updates  | El proveedor administra todo                    |
| Ej: AWS EC2, VPS, DigitalOcean | Ej: AWS Lambda, Firebase Functions              |


## Como consumir servidores
- Postman
- curl
- Axios
- Otra app Spring / Node / Python
- App móvil Android/iOS

## Hacer tu servidor público en internet

Esto también se puede, pero aquí es donde empiezan las limitaciones:

Requisitos

- Una IP pública
- Abrir puertos en tu router (port forwarding)
- Firewall configurado
- Certificado HTTPS si lo quieres serio
- Mantener el servidor encendido

Se puede hacer con:
Ngrok / LocalTunnel / Cloudflare Tunnel

## ¿Servidor en tu casa 24/7?

Se puede, pero:

- Es más vulnerable a ataques
- Consumes energía
- Depende de tu conexión
- ISP puede bloquear puertos
- Necesitas seguridad (firewall, updates, etc.)
- Mejor para aprender, no recomendado para producción.

## Puertos

Un puerto es como una puerta de entrada/salida en tu computador o servidor, usada para comunicación en red.

Tu PC tiene una IP (dirección de la casa) →
y muchos puertos (puertas dentro de la casa).

| Elemento | Analogía                                         |
| -------- | ------------------------------------------------ |
| IP       | Dirección de tu casa                             |
| Puerto   | Puerta específica que da acceso a una habitación |
| Servicio | Persona o actividad usando esa habitación        |

- 65,535 puertos en total
- Puerto 0 no se usa
- Puertos válidos: 1 a 65535

Cada servicio tiene su propio puerto, así puedes tener:

| Servicio            | Puerto |
| ------------------- | ------ |
| Spring Boot API     | 8080   |
| Vite frontend       | 5173   |
| Database PostgreSQL | 5432   |


## Puertos reservados más conocidos

| Puerto        | Servicio         | Descripción                               |
| ------------- | ---------------- | ----------------------------------------- |
| **20 / 21**   | FTP              | Transferencia de archivos                 |
| **22**        | SSH              | Acceso remoto seguro a servidores         |
| **23**        | Telnet           | Acceso remoto sin cifrar (obsoleto)       |
| **25**        | SMTP             | Envío de correo                           |
| **53**        | DNS              | Resolución de nombres                     |
| **67/68**     | DHCP             | Asignación de IPs                         |
| **69**        | TFTP             | FTP simplificado                          |
| **80**        | HTTP             | Navegación web                            |
| **110**       | POP3             | Recepción de correo                       |
| **123**       | NTP              | Sincronización de hora                    |
| **135**       | RPC              | Servicios Windows                         |
| **139**       | NetBIOS          | Compartición de archivos en redes Windows |
| **143**       | IMAP             | Recepción de correo                       |
| **161/162**   | SNMP             | Administración de red                     |
| **389**       | LDAP             | Directorio de usuarios                    |
| **443**       | HTTPS            | Navegación web segura                     |
| **445**       | SMB              | Archivos e impresoras en Windows          |
| **514**       | Syslog           | Logs en red                               |
| **587 / 465** | SMTP seguro      | Envío seguro de correo                    |
| **631**       | CUPS             | Impresión en Linux                        |
| **993 / 995** | IMAP/POP3 seguro | Recepción de correo cifrada               |


Rango 0–1023 → Puertos reservados / bien conocidos (root/privilegios).

Rango 1024–49151 → Puertos registrados (para apps conocidas).

Rango 49152–65535 → Puertos dinámicos / privados (solo para conexiones temporales).


- Dirección = IP
- Habitaciones = Puertos
- Huésped = Servicio

