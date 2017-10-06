# IA-TP2-AlgoritmoGenetico

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

