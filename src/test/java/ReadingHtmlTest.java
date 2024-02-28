import org.example.HtmlDocument;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class ReadingHtmlTest {

    @Test
    public void readHtmlTest() throws IOException {
        HtmlDocument document = new HtmlDocument(Paths.get("doc_example1.html"));
        System.out.println(document.getText());
    }
}
