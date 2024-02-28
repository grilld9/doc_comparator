package org.example;

public interface DocComparator<T> {

    /**
     * Проверяет, являются ли документы идентичными
     * @param firstDocument документ для сравнения
     * @param secondDocument документ для сравнения
     * @return true, если документы совпадают, false - иначе
     */
    boolean equals(T firstDocument, T secondDocument);
}
