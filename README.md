# Seibi Experience
Seibi Experience busca proporcionar una forma cómoda de visualizar, comprar y compartir packs de experiencias entre usuarios.

Se trata de una aplicación web en la cual podremos encontrarnos con diferentes packs de experiencias por la ciudad de Madrid, es decir, una serie de actividades combinadas y diseñadas para facilitar la vida del usuario y permitirle vivir experiencias únicas y apasionantes. Con Seibi Experiencie, los usuarios podrán también ver recomendaciones de otros usuarios, comentarios y otras opciones que les ayuden a decidir y elegir la experiencia que quieren vivir en cada momento, pudiendo emplear también para ello búsquedas simplificadas. Es destacable que para llevar a cabo la compra de packs de experiencias se requiere de registro en la web.
## Funcionalidad pública y privada
Se detallan, de forma pormenorizada, la distinción entre funcionalidades públicas y privadas o particulares de cada usuario:
* __Funcionalidades públicas__: visualizar comentarios de usuarios y ofertas de packs sin registro
* __Funcionalidades privadas__: realizar comentarios sobre los packs de experiencia y llevar a cabo compras de packs
## Entidades principales
En Seibi Experience hay presentes un total de seis entidades, que son las siguientes:
* __Usuarios__: registro de los distintos usuarios registrados en la aplicación.
* __Productos__: packs de experiencias, con diferentes características para su filtrado (como localización u horario).
* __Pedidos__: con los diferentes packs seleccionados para su compra.
* __Comentarios__: realizados por un usuario ante diferentes publicaciones.
## Descripción de las funcionalidades internas
* Generar correo con el recibo del pedido
* Simular pasarela de pago con tarjeta
## Integrantes
* Jia Qi (Rocío) Chen Sun, jq.chen.2017@alumnos.urjc.es, github.com/rociiocs
* Antonio Robledinos Antón, a.robledinos.2017@alumnos.urjc.es, github.com/AruxG

_Trello:_ https://trello.com/b/20wlKqxT/seibi-experience

## Pantallas de la aplicación

### Pantalla Principal
En esta pantalla se da la bienvenida a la página (si es la primera vez que la visitamos) y se muestra el listado de productos (packs de experiencias) para ver los mismos en detalle, así como introducir filtros mediante los que realizar búsquedas más concretas. Por otro lado, como la mayoría de pantallas, dispone de un header que muestra el nombre de la aplicación, así como la opción de iniciar sesión (o en caso de que ya tengamos sesión iniciada, consultar nuestro carrito y datos personales). Es destacable que todo ello está paginado, de forma que se puede navegar por diferentes páginas para ver la totalidad de los productos en vez de mostrar los mismos apilados en una larga lista. Con el apartado de seguridad realizado, y disponiendo de un rol de administrador, si se inicia sesión como éste, se puede ver también un enlace para añadir nuevos productos. 

![pantalla1](https://user-images.githubusercontent.com/48557378/110473706-1f87fc00-80df-11eb-847d-cef141c39210.png)

### Añadir Producto
Habiendo iniciado sesión como administradores se tiene la opción de, desde la pantalla principal, alcanzar esta pantalla en que crear y añadir a la aplicación nuevos productos, rellenando de forma adecuada sus campos (de forma que si están vacíos se nos indica apropiadamente) para poder añadir un producto a los ya presentes.

![admin1](https://user-images.githubusercontent.com/48557378/114228974-81a27e00-9977-11eb-977d-49edad7f17cd.png)

### Confirmación Producto Añadido
Si se cumplimenta de forma correcta los campos propuestos en la anterior pantalla, se pasa a una nueva que confirma que, efectivamente, el producto ha podido añadirse con éxito a la aplicación.

![admin2](https://user-images.githubusercontent.com/48557378/114230005-e0b4c280-9978-11eb-8632-17248562df86.png)

### Información de Producto
Esta pantalla ofrece al usuario información en detalle del producto, como es su descripción o nombre, así como la posibilidad de realziar comentarios sobre el mismo y añadirlo a nuestro carrito de compra. Estas dos últimas acciones requieren de tener una sesión iniciada, por supuesto. Es destacable que un comentario sólo puede ser eliminado por el usuario que lo creó, como también es relevante indicar que, si un usuario ya posee del producto en su carrito de compra, se le informará de ello y se le dará opción a eliminarlo del mismo. Por otro lado, con la implementación de seguridad y los roles pertinentes, si se inicia sesión como administrador, en esta pantalla se puede subir una imagen que  represente al producto.

![admin3](https://user-images.githubusercontent.com/48557378/114230320-4f921b80-9979-11eb-9bba-d975f783dde1.png)

### Confirmación Foto Subida
Si en la pantalla anterior se trata de añadir una foto al producto estando logeado como administrador, esta será la pantalla de confirmación que indicará que dicha acción ha sido realizada con éxito.

![admin4](https://user-images.githubusercontent.com/48557378/114230780-dba44300-9979-11eb-9f5f-1561a476f724.png)

### Confirmación Comentario Eliminado
Se le confirma al usuario de la correcta eliminación del comentario seleccionado.

![pantalla15](https://user-images.githubusercontent.com/48557378/110304208-977cf600-7ffb-11eb-9b40-2817d6060dd0.png)

### Creación de Comentarios
Continuando por la línea anterior, esta pantalla permite a un usuario con sesión iniciada la creación de un comentario a un producto, y guardar el mismo, de forma que dicho comentario sea visible por cualquier otro usuario que vea los detalles del producto.

![pantalla3](https://user-images.githubusercontent.com/48557378/110304410-dd39be80-7ffb-11eb-8256-8747404f0676.png)

### Confirmación de Creación de Comentario
Tras guardar el comentario en la pantalla anterior, esta pantalla simplemente confirma al usuario de la correcta creación del mismo, dándole opción a volver a la página del producto en que creaba el comentario.

![pantalla4](https://user-images.githubusercontent.com/48557378/110304513-fc385080-7ffb-11eb-9021-0b4714c596b0.png)

### Confirmación de Añadido a Carrito
De forma similar a la pantalla anterior, cuando añadimos un producto a nuestro carrito, desde la página de información del mismo, esta pantalla indica que dicha acción ha sido realizada correctamente.

![pantalla5](https://user-images.githubusercontent.com/48557378/110304613-17a35b80-7ffc-11eb-9da0-fc7631c0c364.png)

### Carrito de Compra
Tras añadir diversos productos a nuestro carrito de compra, podemos ver el estado del mismo. En este se listan los diferentes productos añadidos, con su precio individual y el precio total de la compra, así como la opción de modificar el pedido eliminando aquellos productos que no deseemos. También se permite al usuario volver a la página principal (como en la totalidad de pantallas)o pasar a realizar el pago del pedido.

![pantalla6](https://user-images.githubusercontent.com/48557378/110304718-34d82a00-7ffc-11eb-9951-3ed9fefac97d.png)

### Realización de Pedido
El botón de realizar pedido en la pantalla anterior lleva a esta pantalla, que se divide en dos partes: el resumen del pedido y la pasarela de pago. El primero muestra, como en el caso del carrito, el resumen de los productos que conforman el pedido, así como el precio total del mismo. Por otro lado, la pasarela de pago requiere de la introdución de los datos del usuario para realizar el pago, con datos como su correo electrónico (de tipo gmail/hotmail y .es/.com), su número de tarjeta (un número de ocho dígitos) y el CVV de la misma (de tres dígitos). Si alguno de los datos es erróneo, nos quedaremos en la misma página (con el aviso de haber introducido datos erróneos), y si no, pasaremos a la confirmación de pago.

![pantalla7](https://user-images.githubusercontent.com/48557378/110304833-55a07f80-7ffc-11eb-984d-c26c53c135e9.png)

### Confirmación de Pago
La introdución correcta de datos de compra nos lleva a esta pantalla, que como en otras pantallas, confirma la realización correcta de la acción, con el añadido de indicar al usuario que ha recibido, en el correo indicado, el recibo de su compra.

![pantalla8](https://user-images.githubusercontent.com/48557378/110304953-779a0200-7ffc-11eb-9d59-6f983a3dc263.png)

### Información de Usuario
En esta pantalla aportamos al usuario, con sesión iniciada, sus datos personales, como su nombre o un histórico de sus pedidos, así como se le da opción a cerrar la sesión.

![pantalla9](https://user-images.githubusercontent.com/48557378/110305099-a3b58300-7ffc-11eb-86f4-57420906c224.png)

### Confirmación de Cerrado de Sesión
Como en otras pantallas, aquí confirmamos al usuario la realización de una acción, en este caso, el cierre de su sesión.

![pantalla10](https://user-images.githubusercontent.com/48557378/110305174-bb8d0700-7ffc-11eb-9b33-6b99ae9fbaeb.png)

### Inicio de Sesión
Si no tenemos una sesión iniciada, esta pantalla nos permite hacerlo. En ella debemos introducir los campos que nos identifican como usuario, que son nuestro nombre y contraseña. Para poder realizar esta acción, debemos habernos registrado con anterioridad en la aplicación. Así, si tratáramos de iniciar sesión con datos érroneos, la página nos lo indicaría, señalando que el usuario introducido no está registrado o que la contraseña no es correcta.

![pantalla11](https://user-images.githubusercontent.com/48557378/110305287-e4150100-7ffc-11eb-8129-c86dadac2f0d.png)

### Confirmar Inicio de Sesión
Se confirma al usuario de que la sesión se ha iniciado correctamente

![pantalla14](https://user-images.githubusercontent.com/48557378/110303807-1faecb80-7ffb-11eb-941b-aba0a3a04394.png)

### Registro de usuario
Para poder iniciar sesión primeramente debemos habernos registrado en la aplicación. En esta pantalla se solicitan los datos de registro como son el nombre de usuario y la contraseña (con la confirmación de la misma). Si tratamos de registrarnos con un nombre de usuario ya existente (o vacío) la página lo impedirá, de igual forma que indicará que la confirmación de contraseña es o no correcta.

![pantalla12](https://user-images.githubusercontent.com/48557378/110305496-09097400-7ffd-11eb-9e64-185ea99919ab.png)

### Confirmación de Registro
Finalmente, esta pestaña confirma, como su nombre indica, el correcto registro de un nuevo usuario, dando la bienvenida al mismo por su nombre.

![pantalla13](https://user-images.githubusercontent.com/48557378/110305595-263e4280-7ffd-11eb-876b-794db4c92cd8.png)

## Diagrama de navegación
Dado que desde la totalidad de las pantallas (salvo desde sí mismas) se puede acceder a las pantallas de *Página Principal, perfil de usuario/iniciar sesión* y *carrito de compra*, y para simplificar la representación del diagrama de navegación, todas las entradas a estas pantallas se representará con un "\*". También es destacable que, con la implementación de la seguridad, si un usuario intenta acceder a cualquier pantalla privada (que requiere iniciar sesión) y no está logeado, será llevado automáticamente a la pantalla de inicio de sesión.

![diagramaNavegación (1)](https://user-images.githubusercontent.com/48557378/114230966-16a67680-997a-11eb-9118-3ff9307369e3.png)

## Diagrama de clases
Habiendo un total de cuatro entidades, *usuario, comentario, producto* y *pedido*, el diagrama de entidad relación (con representación de patas de gallo), es el siguiente:

![SeibiER](https://user-images.githubusercontent.com/48557378/110303547-cc3c7d80-7ffa-11eb-8eeb-edf129586298.png)

Por otro lado, se presenta el diagrama de clases UML, que establece los tipos de asociación y cardinalidad entre las distintas entidades, así como los métodos y atributos de las mismas.

![SeibiUML](https://user-images.githubusercontent.com/48557378/110474511-0c296080-80e0-11eb-80b3-31eeb3808352.png)

## Diagrama de clases y templates
En el presente diagrama se presentan la totalidad de clases presentes en ambas aplicaciones (separadas en dos islas), marcando la notación de las mismas mediante código de colores, y reflejando la relación entre ellas (mayoritariamente de asociación). Asimismo, se incluyen todas las plantillas presentes, dentro de los controller que gestionan las mismas, salvando las templates de *foot* y las diferentes *header...*, que son referenciadas desde las propias plantillas.

![classDiagram](https://user-images.githubusercontent.com/48557378/114268401-287f2c80-9a01-11eb-806d-96bad2eea1a9.png)

## Instrucciones para el despliegue de la aplicación
De cara a poder realizar el despliegue de la aplicación, se debe compilar la misma y generar el jar pertinente, así como adecuar la máquina virtual para poder correr en la misma la aplicación.

El primer paso, la compilación, se realiza fácilmente a través de SpringTool, ya que permite generar el jar a partir del propio proyecto usando la build de Maven(Click Derecho en el root del proyecto→Run as...→Maven build...→), y fijando en este como "Goals" *clean package*. Hecho esto, se aplican los cambios y se pulsa *Run*. Con ello, ya se dispone de la aplicación compilada y el jar generado  (este proceso se realiza para ambas aplicaciones). Es importante tener que en cuenta que, para que estos cambios se reflejen en el proyecto en GitHub, se ha de editar el .gitignore para no excluir la carpeta *target* (en que se ha generado el jar).

En cuanto a la configuración de la máquina virtual (habiendo instalado la misma, por ejemplo, a través de Virtual Box con una imagen del sistema operativo), se requiere instalar mySQL Workbench y Java8 para poder correr la aplicación.

Para el primero, los pasos son los siguientes, en caso de instalarlo mediante *apt*:
* Descargar el archivo de configuración del repositorio apt (https://dev.mysql.com/downloads/repo/apt/)
* Realizar la instalación de dicho archivo, a través del comando en consola *sudo apt install ./mysql-apt-config_0.8.15-1_all.deb* (encontrándonos en la ruta de descarga)
* Actualizar la caché apt (*sudo apt update*)
* Instalar, ahora sí, mySQL Workbench (*sudo apt install mysql-workbench-community*)

Con ello ya se dispone de mySQL Workbench, pero si se quiere evitar problemas para cargar la propia BD, se ha de llevar a cabo la siguiente configuración:
* Habiendo entrado en la aplicación (ejecutando la instrucción *mysql-workbench*), limpiar los privilegios (*FLUSH PRIVILEGES;*)
* Ello da capacidad para modificar la contraseña de conexión a la BD (*ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';*)
* Se puede ver el estado actual mediante *SELECT user,authentication_string,plugin,host FROM mysql.user;*

Ya se dispone de mySQL instalado. Tras ello se puede crear el *schema* para que todo funcione correctamente, y ya sólo resta instalar Java8:
* Para evitar problemas de dependencias primero ejecutamos *sudo apt install default-jre*
* Tras ello podemos instalar directamente con *sudo apt install openjdk-8-jdk*

Así, ya se han obtenido ambas herramientas y se puede correr la aplicación en la máquina virtual. Ello requiere de descargar los jar en la misma (tanto de la aplicación principal como de la aplicación de servicios) del repositorio en que se hayan, y ejecutar cada uno mediante *java -jar nombre-versión.jar*. Estos jar deben ejecutarse en consolas diferentes (o en diferentes pestañas de la misma), ya que esta quedará detenida con el proceso. Para poder acceder a la aplicación ejecutada, se debe introducir en el navegador que se desee la url *https://localhost:8443*.
