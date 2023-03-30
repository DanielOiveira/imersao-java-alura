import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractorNASA implements ContentExtractor{
    public List<Content> extractorContent(String json){
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listData = parser.parse(json);

        List<Content> listContent = new ArrayList<>();

        for(Map<String, String> data:  listData){
            String title = data.get("title");
            String urlImage = data.get("url");
            var newContent = new Content(title, urlImage);

            listContent.add(newContent);
        }
        return listContent;
    }
}
