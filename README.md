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

## Pantallas
![pantalla1](https://user-images.githubusercontent.com/48557378/110241585-d8203500-7f51-11eb-8fce-d24fef055122.png)
__Pantalla Principal__
En esta pantalla se nos da la bienvenida a la página (si es la primera vez que la visitamos) y se nos muestra el listado de productos (packs de experiencias) para ver los mismos en detalle, así como introducir filtros mediante los que realizar búsquedas más concretas. Por otro lado, como la mayoría de pantallas, dispone de un header que muestra el nombre de la aplicación, así como la opción de iniciar sesión (o en caso de que ya tengamos sesión iniciada, consultar nuestro carrito y datos personales). Es destacable que todo ello está paginado, de forma que podemos navegar por diferentes páginas para ver la totalidad de los productos en vez de mostrar los mismos apilados en una larga lista.
![pantalla2](https://user-images.githubusercontent.com/48557378/110241931-d5264400-7f53-11eb-8435-891386706f47.png)
__Información de Producto__
Esta pantalla ofrece al usuario información en detalle del producto, como es su descripción o nombre, así como la posibilidad de realziar comentarios sobre el mismo y añadirlo a nuestro carrito de compra. Estas dos últimas acciones requieren de tener una sesión iniciada, por supuesto. Es destacable que un comentario sólo puedde ser eliminado por el usuario que lo creó, como también es relevante indicar que, si un usuario ya posee del producto en su carrito de compra, se le informará de ello y se le dará opción a eliminarlo del mismo.
![pantalla3](https://user-images.githubusercontent.com/48557378/110241846-56310b80-7f53-11eb-8984-d30ba5916ef2.png)
__Creación de Comentarios__
Continuando por la lía anterior, esta pantalla permite a un usuario con sesión iniciada la creación de un comentario a un producto, y guardar el mismo, de forma que dicho que dicho comentario sea visible por cualquier otro usuario que vea los detalles del producto.
![pantalla4](https://user-images.githubusercontent.com/48557378/110241884-88db0400-7f53-11eb-9c5d-7a0b1e97e9b4.png)
__Confirmación de Creación de Comentario__
Tras guardar el comentario en la pantalla anterior, esta pantalla simplemente confirma al usuario de la correcta creación del mismo, dándole opción a volver a la página del producto en que creaba el comentario.
![pantalla5](https://user-images.githubusercontent.com/48557378/110241977-1b7ba300-7f54-11eb-9eaa-a9cbbb7c894c.png)
__Confirmación de Añadido a Carrito__
De forma similar a la pantalla anterior, cuando añadimos un producto a nuestro carrito, desde la página de información del mismo, esta pantalla nos indica que dicha acción ha sido realziada correctamente.
![pantalla6](https://user-images.githubusercontent.com/48557378/110242086-99d84500-7f54-11eb-82ba-bc52e5796797.png)
__Carrito de Compra__
Tras añadir diversos productos a nuestro carrito de compra, podemos ver el estado del mismo. En este se los listan los diferentes productos añadidos, con su precio individual y el precio total de la compra, así como la opción a modificar el pedido eliminando aquellos productos que no deseemos. También se permite al usuario volver a la página principal (como en la totalidad de pantallas)o pasar a realizar el pago del pedido.
![pantalla7](https://user-images.githubusercontent.com/48557378/110242158-15d28d00-7f55-11eb-8d58-4d451176663f.png)
__Realización de Pedido__
El botón de realizar pedido en la pantalla anterior nos lleva a esta pantalla, que se divide en dos partes: el resumen del pedido y la pasarela de pago. El primero nos muestra, como en el caso del carrito, el resumen de los productos que conforman el pedido, así como el precio total del mismo. Por otro lado, la pasarela de pago requiere de la introdución de los datos del usuario para realizar el pago, con datos como su correo electrónico (de tipo gmail/hotmail y .es/.com), su número de tarjeta (un número de ocho dígitos) y el CVV de la misma (de tres dígitos). Si alguno de los datos es erróneo, nos quedaremos en la misma página (con el aviso de haber introducido datos erróneos), y si no, pasaremos a la confirmación de pago.
![pantalla8](https://user-images.githubusercontent.com/48557378/110242287-ab6e1c80-7f55-11eb-8c4b-2dad20d230d0.png)
__Confirmación de Pago__
La introdución correcta de datos de compra nos lleva a esta pantalla, que como en otras pantallas, confirma la realización correcta de la acción, con el añadido de indicar al usuario que ha recibido, en el correo indicado, el recibo de su compra. 
![pantalla9](https://user-images.githubusercontent.com/48557378/110242396-2b948200-7f56-11eb-8ebe-f8d9cd8b1cc1.png)
__Información de Usuario__
En esta pantalla aportamos al usuario, con sesión iniciada, sus datos personales, como su nombre o un histórico de sus pedidos, así como le damos opción a cerrar la sesión.
![pantalla10](https://user-images.githubusercontent.com/48557378/110242448-7c0bdf80-7f56-11eb-9618-f1c7b1799d29.png)
__Confirmación de Cerrado de Sesión__
Como en otras pantallas, aquí confirmamos al usuario la realización de una acción, en este caso, el cierre de su sesión.
![pantalla11](https://user-images.githubusercontent.com/48557378/110242588-110ed880-7f57-11eb-9f82-afe32a8371a5.png)
__Inicio de Sesión__
Si no tenemos una sesión inicada, esta pantalla nos permite hacerlo. En ella debemos introducir los campos que nos identifican como usuario, que son nuestro nombre y contraseña. Para poder realziar esta acción, debemos habernos registrado con anterioridad en la aplicación. Así, si tratáramos de iniciar sesión con datos érroneos, la página nos lo indicaría, señalando que el usuario introducido no está registrado o que la contraseña no es correcta.
![pantalla12](https://user-images.githubusercontent.com/48557378/110242592-179d5000-7f57-11eb-950d-f94a6c30d394.png)
__Registro de usuario__
Para poder iniciar sesión primeramente debemos habernos registrado en la aplicación. En esta pantalla se nos solicitan los datos de registro como son el nombre de usuario y la contraseña (con la confirmación de la misma). Si tratamos de registrarnos con un nombre de usuario ya existente (o vacío) la página nos lo impedirá, de igual forma que nos indicará que la confirmación de contraseña es o no correcta.
![pantalla13](https://user-images.githubusercontent.com/48557378/110242678-706ce880-7f57-11eb-9223-5062a76104bf.png)
__Confirmación de Registro__
Finalmente, esta pestaña nos confirma, como su nombre indica, el correcto registro de un nuevo usuario, dando la bienvenida al mismo por su nombre.

