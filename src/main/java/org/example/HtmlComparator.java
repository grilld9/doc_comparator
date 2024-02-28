package org.example;

public class HtmlComparator implements DocComparator<HtmlDocument>{

    @Override
    public boolean equals(HtmlDocument firstDocument, HtmlDocument secondDocument) {
        return firstDocument.getText().equals(secondDocument.getText());
    }
}
