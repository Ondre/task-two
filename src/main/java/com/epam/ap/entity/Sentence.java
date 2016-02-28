package com.epam.ap.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextComponent {
    private List<SentenceComponent> sentenceParts = new ArrayList<>();

    public void toPlaneText(StringBuilder sb) {
        for (SentenceComponent sentencePart : sentenceParts) {
            sentencePart.toPlaneText(sb);
        }
    }

    @Override
    public int getCount(Text.Component c) {
        int result = 0;
        for (SentenceComponent sentencePart : sentenceParts) {
            if (sentencePart instanceof Word) {
                if (c.equals(Text.Component.WORD)) result++;
                else if (c.equals(Text.Component.WORD_SYMBOL)) result += sentencePart.getCount(c);
            } else if (c.equals(Text.Component.PUNCTUATION)) result += sentencePart.getCount(c);
        }
        return result;
    }

    public void add(SentenceComponent sentencePart) {
        if (sentencePart != null) {
            sentenceParts.add(sentencePart);
        }
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentenceParts=" + sentenceParts +
                '}';
    }

}
