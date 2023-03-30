import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractorIMDB  implements ContentExtractor{
    public List<Content> extractorContent(String json){
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listData = parser.parse(json);

        List<Content> listContent = new ArrayList<>();

        for(Map<String, String> data:  listData){
            String title = data.get("title");
            String image = data.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            var newContent = new Content(title, image);

            listContent.add(newContent);
        }
        return listContent;
    }
}

