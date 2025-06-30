import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CatFactFetcher {

    public static String fetchRandomCatFact() {
        String apiUrl = "https://meowfacts.herokuapp.com/";

        // Create the HttpClient instance
        HttpClient client = HttpClient.newHttpClient();

        // Create the GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check for successful response
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.out.println("HTTP Error: " + response.statusCode());
                return null;
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String fact = fetchRandomCatFact();

        if (fact != null) {
            System.out.println("Random Cat Fact:");
            System.out.println(fact);
        }
    }
}
