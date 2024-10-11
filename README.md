
# Conversor de Monedas

Este proyecto es un conversor de monedas desarrollado en Java que permite a los usuarios convertir entre varias monedas disponibles utilizando las tasas de cambio actuales. El programa registra cada conversión en un archivo de historial con la fecha y hora en la que se realizó.

## Características

- Conversión entre múltiples tipos de monedas.
- Interfaz de consola fácil de usar.
- Registro de cada conversión en un archivo con la fecha y la hora en que se realizó.
- Muestra las tasas de conversión actualizadas.
- Guardado automático de todas las conversiones en un archivo `conversiones.txt`.

## Requisitos

- Java 11 o superior.
- Biblioteca `Gson` para el manejo de JSON.

## Instalación

1. Clona el repositorio en tu máquina local:

   ```bash
   git clone https://github.com/tu-repositorio/conversor-monedas.git
   ```

2. Asegúrate de tener Java instalado. Si no lo tienes, descárgalo desde [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

3. Importa el proyecto en tu IDE favorito (como IntelliJ IDEA o Eclipse).

4. Agrega la biblioteca de `Gson` a tu proyecto.

## Uso

1. Ejecuta la clase `Principal.java`.
2. Selecciona la opción correspondiente a las monedas que deseas convertir.
3. Ingresa el valor de la moneda que deseas convertir.
4. El programa mostrará el valor convertido y lo registrará en el archivo `conversiones.txt`.
5. Para salir, selecciona la opción `9` en el menú principal.

### Ejemplo

```
********************************************
Sea bienvenida/o al Conversor de Monedas! <3
1. Dólar a Peso Argentino.
2. Peso Argentino a Dólar.
3. Dólar a Peso brasileño.
4. Real brasileño a Dólar.
5. Dólar a Peso colombiano.
6. Peso colombiano a Dólar.
7. Dólar a Pesos mexicanos.
8. Pesos mexicanos a dólar.
9. Salir.
Elija una opción válida: 1
********************************************
Ingresa el valor de la moneda que deseas convertir: 
100
La conversión es de: 100.00 USD a 195.00 ARS
```

El historial se guardará con un formato similar a este en `conversiones.txt`:

```
[2024-10-10 15:30:45] Convertido 100.00 USD a 195.00 ARS usando la tasa 195.0000
```

## Estructura del Proyecto

El proyecto contiene los siguientes archivos y clases:

- `Principal.java`: Clase principal que maneja el flujo del programa y la interacción con el usuario.
- `ConsultaConversion.java`: Realiza la consulta a la API para obtener las tasas de conversión.
- `CalculoConversion.java`: Realiza los cálculos de conversión basados en la tasa obtenida.
- `GeneradorDeHistorial.java`: Gestiona el archivo de historial donde se guardan las conversiones.
- `ValoresConversion.java`: Clase de modelo para almacenar las tasas de conversión en un formato adecuado.

## Autor

- **Karla Vázquez Pérez**

## Créditos

Gracias a [ExchangeRate-API](https://www.exchangerate-api.com/) por proporcionar las tasas de cambio actualizadas.


