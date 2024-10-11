import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaConversion consulta = new ConsultaConversion();
        CalculoConversion calculo = new CalculoConversion();
        GeneradorDeHistorial generador = null;
        String monedaDestino = "";
        String monedaOrigen = "USD";
        String tasaABuscar="";
        boolean continuar = true;
        try{
            generador = new GeneradorDeHistorial("conversiones.txt");
            while(continuar){
                System.out.println("********************************************");
                System.out.println("Sea bienvenida/o al Conversor de Monedas! <3");
                System.out.println("1. Dólar a Peso Argentino.");
                System.out.println("2. Peso Argentino a Dólar.");
                System.out.println("3. Dólar a Peso brasileño.");
                System.out.println("4. Real brasileño a Dólar.");
                System.out.println("5. Dólar a Peso colombiano.");
                System.out.println("6. Peso colombiano a Dólar.");
                System.out.println("7. Dólar a Pesos mexicanos.");
                System.out.println("8. Pesos mexicanos a dólar.");
                System.out.println("9. Salir.");
                System.out.println("Elija una opción válida: ");
                var opcion=Integer.valueOf(lectura.nextLine());
                System.out.println("********************************************");
                switch(opcion){
                    case 1:
                        tasaABuscar="ARS";
                        monedaDestino="ARS";
                        monedaOrigen = "USD";
                        break;
                    case 2:
                        tasaABuscar="ARS";
                        monedaDestino="USD";
                        monedaOrigen = "ARS";
                        break;
                    case 3:
                        tasaABuscar="BRL";
                        monedaDestino="BRL";
                        monedaOrigen = "USD";
                        break;
                    case 4:
                        tasaABuscar="BRL";
                        monedaDestino="USD";
                        monedaOrigen = "BRL";
                        break;
                    case 5:
                        tasaABuscar="COP";
                        monedaDestino="COP";
                        monedaOrigen = "USD";
                        break;
                    case 6:
                        tasaABuscar="COP";
                        monedaDestino="USD";
                        monedaOrigen="COP";
                        break;
                    case 7:
                        tasaABuscar="MXN";
                        monedaDestino="MXN";
                        monedaOrigen = "USD";
                        break;
                    case 8:
                        tasaABuscar="MXN";
                        monedaDestino="USD";
                        monedaOrigen="MXN";
                        break;
                    case 9:
                        System.out.println("Gracias por usar este Conversor de Monedas!");
                        System.out.println("Se ha guardado un archivo llamado conversiones.txt con el historial de conversiones que has realizado y el tiempo en que realizaste dicha conversión!");
                        System.out.println("Hasta luego!");
                        continuar=false;
                        break;
                    default:
                        System.out.println("Opción inválida!");
                        continuar=false;

                }
                if(continuar && !monedaDestino.isEmpty()){
                    System.out.println("Ingresa el valor de la moneda que deseas convertir: ");
                    double moneda=Double.parseDouble(lectura.nextLine());
                    double tasaConversion=consulta.buscaConversion(tasaABuscar);
                    double monedaConvertida=calculo.calculo(moneda,opcion,tasaConversion);
                    System.out.printf("La conversión es de: %.2f %s a %.2f %s\n", moneda, monedaOrigen, monedaConvertida, monedaDestino);
                    LocalDateTime fechaHoraActual = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String fechaHoraFormateada = fechaHoraActual.format(formatter);

                    String conversion = String.format("[%s] Convertido %.2f %s a %.2f %s usando la tasa %.4f",
                            fechaHoraFormateada, moneda, monedaOrigen, monedaConvertida, monedaDestino, tasaConversion);
                    generador.guardarConversion(conversion);

                }

            }

        }catch(NumberFormatException e){
            System.out.println("Número no encontrado: " + e.getMessage());
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación!");
        } catch (IOException e) {
            throw new RuntimeException("Error al manipular el archivo de historial de conversiones: " + e);
        }finally{
            try{
                if(generador!=null){
                    generador.cerrarArchivo();
                }
            } catch (IOException e) {
                throw new RuntimeException("Error al cerrar el archivo: " + e);
            }
        }


    }
}
