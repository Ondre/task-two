package com.epam.ap.entity;

import java.util.ArrayList;
import java.util.List;

public class Word implements SentencePart {
    List<SentenceSymbol> wordSymbols = new ArrayList<>();

    public Word(String s) {
        for (int i = 0; i < s.length(); i++) {
            wordSymbols.add(SentenceSymbol.valueOf(s.charAt(i), SentenceSymbol.Type.WORDCHAR));
        }
    }

    public void toPlaneText(StringBuilder sb) {
        for (SentenceSymbol wordSymbol : wordSymbols) {
            wordSymbol.toPlaneText(sb);
        }
    }

    @Override
    public String toString() {
        return "Word{" +
                "wordSymbols=" + wordSymbols +
                '}';
    }
}
