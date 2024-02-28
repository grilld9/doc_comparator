package org.example;

import java.util.*;

public class ChangeAnalyzer {

    private final String name;
    private final HtmlComparator comparator;
    private final String surname;
    private final Sex sex;
    public ChangeAnalyzer(String name, String surname, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        comparator = new HtmlComparator();
    }

    public ChangeAnalyzer() {
        name = null;
        surname = null;
        sex = null;
        comparator = new HtmlComparator();
    }

    /**
     * Сравнивает состояния страниц веб сайтов за вчера и за сегодня,
     * @param oldState состаяния страниц веб сайтов на вчера
     * @param newState состояния страниц веб сайтов на сегодня
     * @return рапорт, отражающий изменения состояний страниц, включая списки URL измененных,
     * удаленных и добавленных страниц
     */
    public String getReport(Map<String, HtmlDocument> oldState, Map<String, HtmlDocument> newState) {
        Set<String> deletedUrls = new HashSet<>();
        Set<String> createdUrls = new HashSet<>();
        Set<String> updatedUrls = new HashSet<>();
        Set<String> unchangedUrls = new HashSet<>();
        for (String key : oldState.keySet()) {
            if (newState.containsKey(key)) {
                if (!comparator.equals(oldState.get(key), newState.get(key))) {
                    updatedUrls.add(key);
                } else {
                    unchangedUrls.add(key);
                }
            } else {
                deletedUrls.add(key);
            }
        }
        for (String key : newState.keySet()) {
            if (!unchangedUrls.contains(key)
                    && !updatedUrls.contains(key)) {
                createdUrls.add(key);
            }
        }
        return makeReport(deletedUrls, createdUrls, updatedUrls);
    }

    private String makeReport(Set<String> deleted, Set<String> created, Set<String> updated) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Здравствуйте");
        if (name != null) {
            if (sex == Sex.MALE) reportBuilder.append(", дорогой ");
            else reportBuilder.append(", дорогая ");
            reportBuilder.append(name).append(' ').append(surname);
        }
        reportBuilder.append("\n\n")
                .append("За последние сутки во вверенных Вам сайтах произошли следующие изменения:")
                .append("\n\n")
                .append("Исчезли следующие страницы: ").append(deleted).append('\n')
                .append("Появились следующие новые страницы: ").append(created).append('\n')
                .append("Изменились следующие страницы: ").append(updated).append('\n')
                .append("""
                        
                        С уважением,
                        автоматизированная система
                        мониторинга.""");
        return reportBuilder.toString();
    }
}
