import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Requisição HTTP para buscar dados do TOP 250 filmes do IMDB
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        var address = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address).GET().build();
        var response= client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        //Extração de dados(título, poster, classificação)
        JsonParser parser = new JsonParser();

        List<Map<String, String>> listMovies = parser.parse(body);

        //Exibir e manipular dados coletados

        for (Map<String, String> movie: listMovies) {
            System.out.println(movie.get("title"));
            System.out.println(movie.get("image"));
            System.out.println(movie.get("imDbRating"));
            System.out.println();
        }
    }
}