package com.epam.ap.entity;

public interface TextComponent {
    int getCount(Type c);

    Type getType();

    void toPlainString(StringBuilder sb);

    enum Type {
        PARAGRAPH, SENTENCE, WORD, SYMBOL, WORD_SYMBOL, PUNCTUATION, WHITESPACE
    }

}
