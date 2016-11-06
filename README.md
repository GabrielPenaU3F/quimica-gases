Repositorio original:

https://github.com/juliani2/SimuladorLeyesDeGasesIdeales

Autores originales: 
-Julian Moreno
-Gonzalo Cozzi
-Gonzalo Nahuel Di Pierro

Refactoring:
-Gabriel Pena

DATOS IMPORTANTES:

-La interfaz grafica esta hecha con Swing. Puede mejorarse mucho.

-La posicion de las particulas en el contenedor esta determinada por dos coordenadas, que se ordenan de la siguiente manera: el origen (0,0) esta en la esquina superior izquierda del contenedor. La coordenada X aumenta hacia la derecha (este). La coordenada Y aumenta hacia abajo (sur). Las orientaciones ejecutan el movimiento de esa forma.

-El movimiento de las particulas en funcion de su orientacion esta modelado segun el patron de diseño State.


Issues conocidas:

-La primer pelotita en el contenedor nunca se pinta del color correspondiente. De todas maneras, se ha pedido especialmente uqe este bug no sea corregido, ya que ayuda a seguir una pelotita en particular y ver como se producen los choques.

Posibles funcionalidades para agregar:

-Que los datos se puedan ingresar en otras unidades, y no solo las predeterminadas.
-Que se pueda calcular cualquiera de las otras magnitudes, no solo la presion.
-Sustituir los sliders por cuadros de texto, para facilitar el ingreso de datos de precision.
-Rediseñar el funcionamiento del choque para hacerlo más realista: modelar un choque que permita el movimiento en todas las direcciones, en lugar de solo cuatro combinaciones.
-Que las partículas no se muevan a velocidad constante y uniforme, sino que tengan una velocidad aleatoria distribuida segun la ley de Maxwell-Boltzmann y en los choques haya intercambios de energia que resulten en un recalculo de la velocidad.
-Que la velocidad de las particulas se modele en funcion de la temperatura siguiendo la teoria cinetica real.
-Que la forma de las pelotas (en la vista) sea realmente esferica y no rectangular.
-Cambiar la tecnologia de la interface visual, que actualmente es Swing, a otra mejor.
