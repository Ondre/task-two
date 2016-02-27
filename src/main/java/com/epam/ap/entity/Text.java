package com.epam.ap.entity;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Paragraph> paragraphs = new ArrayList<>();


    public void add(Paragraph paragraph) {
        if (paragraph != null) {
            paragraphs.add(paragraph);
        }
    }

    public boolean remove(Paragraph paragraph) {
        return paragraph != null && paragraphs.remove(paragraph);
    }

    public int getWordCount() {
        int result = 0;
        for (Paragraph paragraph : paragraphs) {
            result += paragraph.getWordCount();
        }
        return result;
    }

    public String toPlainString() {
        StringBuilder sb = new StringBuilder();
        for (Paragraph paragraph : paragraphs) {
            paragraph.toPlaneText(sb);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Text{" +
                "paragraphs=" + paragraphs +
                '}';
    }
}
