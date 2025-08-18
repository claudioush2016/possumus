## Proyecto de Conversión de Números Romanos
Este es un proyecto de backend simple en Java que contiene una lógica de negocio para convertir números enteros a su representación romana y viceversa.

El proyecto está construido con Maven y utiliza JUnit 5 para las pruebas unitarias.

## 🚀 Requisitos previos
Asegúrate de tener instalado lo siguiente en tu sistema:

**JDK (Java Development Kit)**: Versión 17 o superior. Puedes verificar tu versión con el comando java -version.

**Maven**: Versión 3.x o superior. Puedes verificar tu versión con el comando mvn -v.

## 🛠️ Estructura del proyecto
### Fase 1 – Lógica básica de conversión

La fase 1 contiene la implementación básica de la conversión y tests unitarios.

El proyecto sigue la estructura estándar de Maven:
```
src/
├─ main/
│ └─ java/
│ └─ com/backend/numeralconversion/
│ ├─ RomanNumeralConverter.java # Lógica de conversión
│ └─ exception/
│ └─ InvalidRomanNumeralException.java # Excepción personalizada
│ └─ org/example/
│ └─ Main.java # Clase para ejecutar la Fase 1
└─ test/
└─ java/
└─ com/backend/numeralconversion/
└─ RomanNumeralConverterTest.java # Tests unitarios JUnit 5
```
### Fase 2 – Arquitectura Spring Boot con REST API
Contiene : 
 * controller → endpoints REST

 * service → lógica de negocio desacoplada

 * dto → estructuras de entrada y salida

 * exception → manejo global de errores con GlobalExceptionHandler
```
src/
├─ main/
│   └─ java/
│       └─ com/backend/numeralconversion/
│           ├─ BackendApplication.java          # Clase principal Spring Boot
│           ├─ controller/
│           │   └─ RomanController.java        # Endpoints REST
│           ├─ service/
│           │   └─ RomanService.java           # Lógica de negocio
│           ├─ dto/
│           │   ├─ RomanRequest.java           # DTO de entrada
│           │   ├─ RomanResponse.java          # DTO de salida
│           │   └─ ErrorResponse.java          # DTO de errores
│           └─ exception/
│               ├─ InvalidRomanNumeralException.java  # Excepción personalizada
│               └─ GlobalExceptionHandler.java       # Manejo global de errores
└─ test/
└─ java/
└─ com/backend/numeralconversion/
└─ controller/
└─ RomanControllerIntegrationTest.java # Tests de integración
```

## ▶️ Construcción y ejecución de los tests (fase 1)
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
mvn test -Dtest=RomanNumeralConverterTest
```
Si todas las pruebas pasan, verás un mensaje de **BUILD SUCCESS.**

### 4) Probar FASE 1
Ejecutar
```
java -cp target/classes org.example.Main
```

Se le mostrara un menu para elegir entre 2 opciones 

Convetir de romano a decimal o de decimal a romano. 

### 💡 Cómo usar el componente (FASE 1 )
El componente principal es com.backend.numeralconversion.RomanNumeralConverter. Puedes crear una instancia de esta clase en tu código para usar sus métodos de conversión. 

Incluye los metodos de 

* **toRoman(int number):String** ---> Pasa el número de decimal a romano en un rango de 1-3999 
* **toInt(String cadena): int**  ---> Pasa el número de romano a decimal en un rango de I-MMMCMXCIX

## ▶️ Construcción y ejecución  (fase 2)

Para la fase 2 se debe iniciar el servidor y probar los endpoints expuestos.

### 1️⃣ Requisitos previos

- Java 17
- Maven 3.8+
- IDE recomendado: IntelliJ, Eclipse o VS Code
- Postman o cURL para probar los endpoints

---

### 2️⃣ Compilar y ejecutar la aplicación

Desde la raíz del proyecto:

```
# Compilar el proyecto
mvn clean install

# Ejecutar la aplicación
mvn spring-boot:run
```
Por defecto, Spring Boot levantará el servidor en http://localhost:8080.

### 3️⃣ Endpoints disponibles

| Endpoint               | Método | Parámetros       | Descripción                         |
| ---------------------- | ------ | ---------------- | ----------------------------------- |
| `/api/roman/toRoman`   | GET    | `value` (int)    | Convierte un número entero a romano |
| `/api/roman/toInteger` | GET    | `value` (String) | Convierte un número romano a entero |

### 4️⃣ Manejo de errores
Si se envía un valor inválido, la API devuelve un JSON con detalles del error y código HTTP 400.

GET http://localhost:8080/api/roman/toInteger?value=@
#### Respuesta esperada
```
{
"timestamp": "2025-08-18T12:00:00",
"status": 400,
"error": "Bad Request",
"message": "Formato romano inválido con los símbolos permitidos",
"code": "INVALID_ROMAN"
}
```

### 5️⃣ Ejecutar tests de integración
```
# Ejecutar todos los tests
mvn test -Dtest=RomanControllerIntegrationTest
```

Los tests incluyen:

Casos válidos (toRoman y toInteger)

Casos inválidos (símbolos incorrectos, números fuera de rango)

Casos límite (0, negativos, números grandes)

Validación de JSON de error con GlobalExceptionHandler


# Ejemplos de uso con Postman o navegador:

## Convertir 20 a romano
GET http://localhost:8080/api/roman/toRoman?value=21
### Respuesta esperada
{
"roman": "XX"
}

## Convertir XX a entero
GET http://localhost:8080/api/roman/toInteger?value=XXI
### Respuesta esperada
{
"roman": "20"
}

Autor: [Claudio Cabrera]


