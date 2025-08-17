## Proyecto de Conversión de Números Romanos
Este es un proyecto de backend simple en Java que contiene una lógica de negocio para convertir números enteros a su representación romana y viceversa.

El proyecto está construido con Maven y utiliza JUnit 5 para las pruebas unitarias.

## 🚀 Requisitos previos
Asegúrate de tener instalado lo siguiente en tu sistema:

**JDK (Java Development Kit)**: Versión 17 o superior. Puedes verificar tu versión con el comando java -version.

**Maven**: Versión 3.x o superior. Puedes verificar tu versión con el comando mvn -v.

## 🛠️ Estructura del proyecto
El proyecto sigue la estructura estándar de Maven:

* src/main/java/: Contiene el código fuente de la aplicación.

  * com/backend/numeralconversion/RomanNumeralConverter.java: La clase principal con la lógica de conversión.

  * com/backend/numeralconversion/exception/InvalidRomanNumeralException.java: Excepción personalizada para manejar errores.
  * org.example
    * Main : Clase para correr la  **Fase 1** 



* src/test/java/: Contiene los tests unitarios para validar la funcionalidad.

    * com/backend/numeralconversion/RomanNumeralConverterTest.java: Clase de pruebas con JUnit 5.

## ▶️ Construcción y ejecución de los tests
Sigue estos pasos desde la terminal para construir y probar el proyecto:

### 1) Clonar el repositorio:
```
git clone https://github.com/claudioush2016/possumus

cd possumus
```
### 2) Construir el proyecto con Maven:
Este comando descargará todas las dependencias (incluyendo JUnit) y compilará el código.
```
mvn clean install
```
### 3) Ejecutar los tests unitarios:
Este comando ejecutará todas las pruebas definidas en la carpeta src/test/java.
```
mvn test
```
Si todas las pruebas pasan, verás un mensaje de **BUILD SUCCESS.**

### 4) Probar FASE 1
Ejecutar
```
java -cp target/classes org.example.Main
```

Se le mostrara un menu para elegir entre 2 opciones 

Convetir de romano a decimal o de decimal a romano. 

## 💡 Cómo usar el componente (FASE 1 )
El componente principal es com.backend.numeralconversion.RomanNumeralConverter. Puedes crear una instancia de esta clase en tu código para usar sus métodos de conversión. 

Incluye los metodos de 

* **toRoman(int number):String** ---> Pasa el número de decimal a romano en un rango de 1-3999 
* **toInt(String cadena): int**  ---> Pasa el número de romano a decimal en un rango de I-MMMCMXCIX



Autor: [Claudio Cabrera]


