import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversion {

    public double buscaConversion(String monedaDestino){
        URI direccion= URI.create("https://v6.exchangerate-api.com/v6/c46b9266add936bec2e07f19/latest/USD");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ValoresConversion valores = new Gson().fromJson(response.body(), ValoresConversion.class);
            return valores.conversion_rates().getOrDefault(monedaDestino, 0.0);
        }catch(Exception e){
            throw new RuntimeException("No encontré el valor de conversión: ",e);
        }
    }
}
