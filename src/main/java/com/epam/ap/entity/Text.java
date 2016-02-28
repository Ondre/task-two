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

    public int getCount(Component c){
        int result = 0;
        for (Paragraph paragraph : paragraphs) {
            if (c.equals(Component.PARAGRAPH)) result++;
            else result += paragraph.getCount(c);
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

    public enum Component {
        PARAGRAPH, SENTENCE, WORD, WORD_SYMBOL, PUNCTUATION
    }
}
