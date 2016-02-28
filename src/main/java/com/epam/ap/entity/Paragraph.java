package com.epam.ap.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextComponent {
    private List<Sentence> sentences = new ArrayList<>();

    public void toPlaneText(StringBuilder sb) {
        for (Sentence sentence : sentences) {
            sentence.toPlaneText(sb);
        }
    }

    public void add(Sentence sentence) {
        if (sentence != null) {
            sentences.add(sentence);
        }
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "sentences=" + sentences +
                '}';
    }


    public int getCount(Text.Component c) {
        int result = 0;
        for (Sentence sentence : sentences) {
            if (c.equals(Text.Component.SENTENCE)) result++;
            else  result += sentence.getCount(c);
        }
        return result;
    }
}
