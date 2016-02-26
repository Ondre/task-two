package com.epam.ap.entity;

import java.util.ArrayList;
import java.util.List;

public class Text {
    List<Paragraph> paragraphs = new ArrayList<>();


    public void add(Paragraph paragraph) {
        if (paragraph != null) {
            paragraphs.add(paragraph);
        }
    }

    public boolean remove(Paragraph paragraph){
        if (paragraph != null) {
            return paragraphs.remove(paragraph);
        }
        return false;
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
