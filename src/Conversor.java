import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public Moneda convertirA(String moneda1, String moneda2){
        //CONECTAR CON EL API MEDIANTE HTTP REQUEST
        String apiKey = "3b692e24ad35470118f77f9d";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+ apiKey +"/pair/"+moneda1+"/"+ moneda2);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //DEBEMOS IMPORTAR LA CLASE DESDE PROJEC ESTRUCTURE
            //retorna el JSON convertido en nuestra Pelicula
            return new Gson().fromJson(response.body(),Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException("Momeda mal escrita, favor validar, escribiste: "+ moneda1 + " - " + moneda2);
        }

    }

}
