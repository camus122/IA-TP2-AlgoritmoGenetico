# IA-TP2-AlgoritmoGenetico
## Ambiente
# GIT
1. Crear cuenta de gitHub https://github.com
2. Instalar git https://git-scm.com/
3. Ir a la carpeta que sera el workspace de eclipse por linea de comando
3. git clone https://github.com/camus122/IA-TP2-AlgoritmoGenetico
4. ingresar user y pass

## IDE
1. Instalar la JDK de java http://www.oracle.com/technetwork/es/java/javase/downloads/index.html
2. Descargar eclipse: https://www.eclipse.org/downloads/
3. Iniciar eclipse
4. Import Git > Projects from git
5. Agregar el repostiorio, este seria la carpeta que se creo dentro del workspace luego del git clone


## Ejecucion del test - JUnit
- AlgoritmoGeneticoTest 
    1. Boton derecho en la clase
    2. Run As
    3. Junit Test

# Package: main.java.ar.edu.utn.frba.ia.tp
Este package contiene todos los componentes custom que se realizaron para el TP entre ellos:
- AlgoritmoGeneticoTPTest
- Cromosoma
- Esposo

## Cromosoma!
Tiene una represetnacion en 4 atributos {daniel,enrique,martin,pablo} represeta cada una de las secciones del cromoosma.

Metodos:
- **cargarPilaDeportes / cargarPilaApellidos / cargarPilaEsposas:**  El objetivo es generar pilas random para cada uno de los casos sin repetir los valores posibles.
- **constructor:** Crea cada uno de los atributos de tipo esposo {daniel,enrique,martin,pablo}, con una caracteristica random de cada uno de ellos.
-  **aptitud:** Retorna la suma de la aptitud de cada una de los atributos de tipo esposo, teniendo en cuenta condiciones generales y condiciones particulares de cada uno de ellos.

