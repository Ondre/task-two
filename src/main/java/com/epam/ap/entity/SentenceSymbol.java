package com.epam.ap.entity;

public class SentenceSymbol implements SentencePart {
    private char value;
    private Type type;

    private SentenceSymbol(char i) {
        value = i;
    }

    public static SentenceSymbol valueOf(char i, Type type) {
        SentenceSymbol ss = Cache.get(i);
        ss.setType(type);
        return ss;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void toPlaneText(StringBuilder sb) {
        sb.append(value);
    }

    @Override
    public String toString() {
        return "SentenceSymbol{" +
                "value=" + value +
                ", type=" + type +
                '}';
    }

    public enum Type {
        WORDCHAR, PUNCTUATION, WHITESPACE;

        public static Type getType(char value) {

            return null;
        }
    }

    private static class Cache {
        static SentenceSymbol[] cache = new SentenceSymbol[65535];

        static SentenceSymbol get(char i) {
            if (cache[i] == null) cache[i] = new SentenceSymbol(i);
            return cache[i];
        }
    }
}
