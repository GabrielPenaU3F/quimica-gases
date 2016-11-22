Repositorio original:

https://github.com/juliani2/SimuladorLeyesDeGasesIdeales

Repositorio actual:


-------

Autores originales: 
-Julian Moreno
-Gonzalo Cozzi
-Gonzalo Nahuel Di Pierro

Refactoring:
-Gabriel Pena

-------

Herramientas:

-Java 1.8
-IntelliJ IDEA
-Maven 3
-JUnit 4
-Swing


DATOS IMPORTANTES:

-La interfaz grafica esta hecha de una forma muy burda, y puede mejorarse mucho.

-La posicion de las particulas en el contenedor esta determinada por dos coordenadas, que se ordenan de la siguiente manera: el origen (0,0) esta en la esquina superior izquierda del contenedor. La coordenada X aumenta hacia la derecha (este). La coordenada Y aumenta hacia abajo (sur). Las orientaciones ejecutan el movimiento de esa forma.

-El movimiento de las particulas en funcion de su orientacion esta modelado segun el patron de diseño State.


Issues conocidas:

-El simulador no funciona. La parte de back-end (paquete Implementacion) esta bien cubierta por los tests unitarios y hace lo que debe hacer. El problema esta en la interfaz, y mas precisamente en la clase Simulador. A saber son varios problemas, el primero es que el boton de Actualizar no reacciona correctamente a los clicks, y da resultados distintos en diferentes momentos; el segundo es que las pelotitas no aparecen correctamente ni tampoco se mueven bien (reitero, los bugs estan en la vista, ya que el movimiento en el back-end funciona perfecto).

-La primer pelotita en el contenedor nunca se pinta del color correspondiente. De todas maneras, se ha pedido especialmente uqe este bug no sea corregido, ya que ayuda a seguir una pelotita en particular y ver como se producen los choques.


Falta:

-Corregir los problemas del simulador, para que con el nuevo diseño pueda funcionar igual que funcionaba la aplicacion original. (esta disponible en el repositorio original).

-Documentar  (Javadoc en el codigo, diagramas de secuencia UML, etc).


Posibles funcionalidades para agregar:

-Que los datos se puedan ingresar en otras unidades, y no solo las predeterminadas.
-Que se pueda calcular cualquiera de las otras magnitudes, no solo la presion.
-Sustituir los sliders por cuadros de texto, para facilitar el ingreso de datos de precision.
-Rediseñar el funcionamiento del choque para hacerlo más realista: modelar un choque que permita el movimiento en todas las direcciones, en lugar de solo cuatro combinaciones.
-Que las partículas no se muevan a velocidad constante y uniforme, sino que tengan una velocidad aleatoria distribuida segun la ley de Maxwell-Boltzmann y en los choques haya intercambios de energia que resulten en un recalculo de la velocidad.
-Que la velocidad de las particulas se modele en funcion de la temperatura siguiendo la teoria cinetica real.
-Que la forma de las pelotas (en la vista) sea realmente esferica y no rectangular.
-Cambiar la tecnologia de la interface visual, que actualmente es Swing, a otra mejor.


COMANDOS:

-Testear: mvn clean test
-Testear con informe de cobertura: mvn clean test cobertura:cobertura
-Compilar: mvn clean package
