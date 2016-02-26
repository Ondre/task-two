package com.epam.ap.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextPart {
    List<SentencePart> sentenceParts = new ArrayList<>();

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
}
