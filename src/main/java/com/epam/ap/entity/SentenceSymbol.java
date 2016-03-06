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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SentenceSymbol that = (SentenceSymbol) o;

        return value == that.value;

    }

    @Override
    public int hashCode() {
        return (int) value;
    }

    @Override
    public int getCount(Type c) {
        if (c == Type.SYMBOL) return 1;
        if (c == type) return 1;
        return 0;
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
    public void toPlainString(StringBuilder sb) {
        sb.append(value);
    }

    @Override
    public String toString() {
        return "SentenceSymbol{" +
                "value=" + value +
                ", type=" + type +
                '}';
    }

    private static class Cache {
        static SentenceSymbol[] cache = new SentenceSymbol[65535];

        static SentenceSymbol get(char i) {
            if (cache[i] == null) cache[i] = new SentenceSymbol(i);
            return cache[i];
        }
    }
}
