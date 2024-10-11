public class CalculoConversion {
    public double calculo(double moneda, int opcion, double tasaConversion){
        double monedaConvertida=0.00;
        switch(opcion){
            case 1:
                monedaConvertida=moneda*tasaConversion;
                break;
            case 2:
                monedaConvertida=moneda/tasaConversion;
                break;
            case 3:
                monedaConvertida=moneda*tasaConversion;
                break;
            case 4:
                monedaConvertida=moneda/tasaConversion;
                break;
            case 5:
                monedaConvertida=moneda*tasaConversion;
                break;
            case 6:
                monedaConvertida=moneda/tasaConversion;
                break;
            case 7:
                monedaConvertida=moneda*tasaConversion;
                break;
            case 8:
                monedaConvertida=moneda/tasaConversion;
                break;
            default:
                System.out.println("Ocurrió un error en la transformación!");
        }
        return monedaConvertida;
    }
}
