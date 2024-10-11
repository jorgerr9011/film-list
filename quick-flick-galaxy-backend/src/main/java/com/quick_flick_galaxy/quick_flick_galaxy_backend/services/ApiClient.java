package com.quick_flick_galaxy.quick_flick_galaxy_backend.services;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

/*
import io.github.cdimascio.dotenv.Dotenv;
*/
public class ApiClient {
/*
    static Dotenv dotenv = Dotenv.load();

    static String apiKey = dotenv.get("API_KEY");
    static String accessToken = dotenv.get("ACCESS_TOKEN");
    static String url = dotenv.get("URL");

    private final RestTemplate restTemplate;

    public ApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String fetchDataFromApi() {

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        //headers.set("X-API-Key", apiKey); // Ajusta el nombre del encabezado según la API

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public static void main(String[] args){

        ApiClient apiClient = new ApiClient(new RestTemplate());

        String data = apiClient.fetchDataFromApi();
        System.out.println("Data from API: " + data);
    }
    */
}
