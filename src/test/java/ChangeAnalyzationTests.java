import org.example.ChangeAnalyzer;
import org.example.HtmlDocument;
import org.example.Sex;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ChangeAnalyzationTests {

    @Test
    public void smallTest() {
        ChangeAnalyzer changeAnalyzer = new ChangeAnalyzer("Михаил",
                "Палыч", Sex.MALE);
        Map<String, HtmlDocument> oldPagesMap = new HashMap<>();
        Map<String, HtmlDocument> newPagesMap = new HashMap<>();
        oldPagesMap.put("https//www.youtube.com",
                new HtmlDocument("test_files\\youtube_deleted.html"));
        oldPagesMap.put("https//github.com",
                new HtmlDocument("test_files\\github_changed.html"));
        newPagesMap.put("https//github.com",
                new HtmlDocument("test_files\\github_changed_new.html"));
        newPagesMap.put("https//www.gasprombank.ru",
                new HtmlDocument("test_files\\gasprom_bank_added.html"));
        newPagesMap.put("https//mvnrepository.com",
                new HtmlDocument("test_files\\mvn_repository_saved.html"));
        oldPagesMap.put("https//mvnrepository.com",
                new HtmlDocument("test_files\\mvn_repository_saved.html"));
        Assert.assertEquals("""
                        Здравствуйте, дорогой Михаил Палыч
                                                
                        За последние сутки во вверенных Вам сайтах произошли следующие изменения:
                                                
                        Исчезли следующие страницы: [https//www.youtube.com]
                        Появились следующие новые страницы: [https//www.gasprombank.ru]
                        Изменились следующие страницы: [https//github.com]
                                                
                        С уважением,
                        автоматизированная система
                        мониторинга.""", changeAnalyzer.getReport(oldPagesMap, newPagesMap));
    }
}
