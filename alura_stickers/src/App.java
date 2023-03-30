import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Requisição HTTP para buscar dados do TOP 250 filmes do IMDB
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        ContentExtractor extractorIMDB = new ContentExtractorIMDB();

        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        //ContentExtractor extractorNASA = new ContentExtractorNASA();

        var http = new ClientHttp();
        String json = http.fetchData(url);

        //Exibir e manipular dados coletados

        List<Content> listContent = extractorIMDB.extractorContent(json);
        //List<Content> listContent = extractorNASA.extractorContent(json);

        var generator = new StickerGenerator();

        for (int i = 0 ; i < 3 ; i++) {
           Content content = listContent.get(i);

           //Gerando figurinhas com base na URL das imagens
            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName = content.getTitle();
            generator.createSticker(inputStream, fileName);

            System.out.println(fileName);
            System.out.println();
        }
    }
}