package com.epam.ap.entity;

public class SentenceSymbol implements SentenceComponent {
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

    private void setType(Type type) {
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
    public int getCount(Text.Component c) {
        if (c.equals(Text.Component.WORD_SYMBOL) && type.equals(Type.WORDCHAR)) return 1;
        else if (c.equals(Text.Component.PUNCTUATION) && type.equals(Type.PUNCTUATION)) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "SentenceSymbol{" + value + type + '}';
    }

    public enum Type {
        WORDCHAR, PUNCTUATION, WHITESPACE
    }

    private static class Cache {
        static SentenceSymbol[] cache = new SentenceSymbol[65535];

        static SentenceSymbol get(char i) {
            if (cache[i] == null) cache[i] = new SentenceSymbol(i);
            return cache[i];
        }
    }
}
