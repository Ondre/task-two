package com.epam.ap.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextPart {
    private List<SentencePart> sentenceParts = new ArrayList<>();

    public void toPlaneText(StringBuilder sb) {
        for (SentencePart sentencePart : sentenceParts) {
            sentencePart.toPlaneText(sb);
        }

    }

    public void add(SentencePart sentencePart) {
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

    public int getWordCount() {
        int result = 0;
        for (SentencePart sentencePart : sentenceParts) {
            if (sentencePart instanceof Word) result++;
        }
        return result;
    }
}
