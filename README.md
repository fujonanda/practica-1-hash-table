Equipo: TQM Enoc
Integrantes:
- Correa Merino Fernanda
- Pérez Hernández Francisco Gadiel

Preguntas:

1. ¿Por qué tener una colisión no significa que una tabla hash esté implementada incorrectamente?
Porque es normal que las colisiones existan teniendo un sistema para asignar llaves cualesquiera a una tabla con índices limitados usando funciones de dispersión, lo que hace la diferencia entre una tabla hash bien implementada y una tabla mal implementada es que esas colisiones sean manejadas de forma en que cada llave pueda tener un lugar consultable y que se respete la función de dispersión que le asigna una posición

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Detalles de la práctica:

1. Lenguaje utilizado:
JAVA

2. Instrucciones para ejecutar el programa:
   - Copia el contenido del archivo TablaHash en un documento de texto y guárdalo como TablaHash.java dentro del fichero de tu elección, en lugar de copiar y pegar
     también puedes descargar el archivo original en la ruta que desees
   - Abre la terminal y realiza los comandos necesarios para dirigirte a la ruta donde guardaste el archivo
   - Escribe el comando javac TablaHash.java en la terminal para generar un archivo TablaHash.class que servirá como ejecutable y que se guardará en la misma ruta que
     el archivo de la práctica
   - Escribe el comando java TablaHash en la terminal para ejecutar el archivo .class, como el archivo TablaHash no contiene ningún método main no pasará nada más en
     la terminal y no se pondrá en acción el contenido del archivo por lo que se puede modificar el contenido del archivo TablaHash.java para añadir este método con
     las instrucciones de lo que se desea hacer para poner a prueba el programa y después repetir el proceso de generar el archivo .class y ejecutarlo. En su defecto
     también se puede utilizar el archivo correspondiente a las pruebas

3. Explicación de cómo ejecutar los casos de prueba:
   - Copia el contenido del archivo Pruebas en un documento de texto y guárdalo como un archivo .java en la misma ruta donde está guardado el archivo TablaHash.class,
     en lugar de copiar y pegar el contenido puedes optar por descargar el archivo fuente en esta misma ruta
   - Abre la terminal y realiza los comandos necesarios para entrar a la ruta donde los archivos Prueba.java y TablaHash.class están guardados
   - Escribe el comando javac Pruebas.java en la terminal para generar el archivo ejecutable Pruebas.class en el fichero donde se encuentran los otros archivos
   - Escribe el comando java Pruebas para ejecutar el archivo .class y en la terminal aparecerán los resultados de las operaciones realizadas dentro del método main
     de Pruebas, en caso de querer modificar, añadir o eliminar alguna operación se debe entrar al archivo Pruebas.java y reescribir el código con los métodos deseados
     y los datos que se desea ingresar al programa para después repetir el proceso para generar y ejecutar el archivo .class

4. Explicación de la función hash:
La función hash recibe como entrada la llave a la que se desea encontrarle un lugar dentro de la tabla, consiste en tomar la llave y aplicar la operación de módulo 7 sobre ella para obtener el índice de la tabla en el que pertenece. Se aplica módulo 7 porque la tabla únicamente consta de 7 índices distintos que van del 0 al 6 como una forma de ahorrar espacio de memoria, para saber cuál de esos 7 índices le corresponde a una llave cuyo valor puede ir más allá de esos números se aplica el módulo y el resultado equivale al índice donde se almacenará la llave. La operación se encarga de tomar el número con el que va a trabajar (la llave) y determinar si es divisible entre 7, si la división no produce ningún residuo el resultado será 0 pero si lo hace entonces arroja un número que indica cuántos números está la llave por delante de un múltiplo de 7 (por ejemplo, el 8 está un número por delante del 7 por lo que el resultado es 1). Los únicos resultados que puede arrojar la operación de módulo 7 para cualquier número son los números del 0 al 7 por lo que siempre coincidirán con un índice dentro de la tabla.

5. Explicación del manejo de colisiones:
Como se explicó antes, el que haya una colisión no significa que haya ocurrido un error, simplemente se le debe encontrar un lugar a las llaves que formaron parte de la colisión sin que alguna tenga que ser eliminada o sin que se tenga que cambiar la llave de los involucrados. Para manejar las colisiones lo que se hace es un encadenamiento, es decir que las llaves que comparten índice se colocan dentro de la misma cubeta como elementos separados, así que ninguna toma el lugar ni el valor de otra y cuando se necesita eliminar una de estas llaves las demás permanecen ahí

6. Explicación de qué ocurre cuando dos llaves producen el mismo hash:
Como se explicó, el hash representa el índice dentro de la tabla en donde una llave se guardará. Si dos llaves producen el mismo hash significa que ambas se van a almacenar en la cubeta correspondiente al mismo índice y ocurre una colisión la cual se debe manejar para que ambas llaves puedan tener un lugar en la tabla, en el punto anterior se explicó que si esto llega a pasar entonces todas las llaves que colisionaron se guardan en ese mismo índice como elementos separados

7. Explicación de qué ocurre cuando varias llaves caen en la misma cubeta:
Que varias llaves hayan sido enviadas a la misma cubeta significa que todas ellas colisionaron porque al aplicarles el hash arrojaron el mismo índice. Las llaves dentro de la cubeta se almacenan ahí encadenadas unas a otras en orden ascendente y cada una sigue siendo un elemento separado a las otras, por lo que cada una sigue siendo una llave independiente y con su propio valor sin formar parte de las otras llaves y sin compartir sus valores. Cuando se busca una de las llaves usando la función buscar(key) el resultado que arroja únicamente consta de la llave buscada y su valor, de forma similar cuando se aplica la función eliminar(key) a una llave esta es eliminada de la cubeta y las demás permanecen en la cubeta sin sufrir mayor afectación

8. Factor de carga final obtenido durante sus pruebas:
α = 0.5714285714285714
