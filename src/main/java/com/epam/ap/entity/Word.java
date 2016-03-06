package com.epam.ap.entity;


public class Word extends CompoundTextComponent<SentenceSymbol> implements SentenceComponent, Comparable<Word> {

    public Word(String s) {
        for (int i = 0; i < s.length(); i++) {
            components.add(SentenceSymbol.valueOf(s.charAt(i), Type.WORD_SYMBOL));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (components.size() != ((Word) o).components.size()) return false;

        CompoundTextComponent<?> that = (Word) o;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < components.size(); i++) {
            this.components.get(i).toPlainString(sb1);
            that.components.get(i).toPlainString(sb2);
        }
        String thisString = sb1.toString().toLowerCase();
        String thatString = sb2.toString().toLowerCase();

        return thisString.equals(thatString);
    }

    @Override
    public int compareTo(Word o) {
        return Integer.compare(this.components.size(), o.components.size());
    }
}
