package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HtmlDocument {

    private final String text;

    /**
     * Инициализирует объект с помощью содержимого документа
     * @param text содержимое документа
     */
    public HtmlDocument(String text) {
        this.text = text;
    }

    /**
     * Инициализирует объект с помощью пути документа
     * @param path путь документа
     * @throws IOException если возникла ошибка при чтении
     */
    public HtmlDocument(Path path) throws IOException {
        text = readFile(path);
    }

    public String getText() {
        return text;
    }

    private String readFile(Path path) throws IOException {
        return String.join("\n", Files.readAllLines(path));
    }
}
