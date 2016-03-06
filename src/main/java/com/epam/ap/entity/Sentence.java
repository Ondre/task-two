package com.epam.ap.entity;

public class Sentence extends CompoundTextComponent<SentenceComponent> implements Comparable<Sentence> {


    @Override
    public int compareTo(Sentence o) {
        int thisWordsCount = this.getCount(Type.WORD);
        int thatWordsCount = o.getCount(Type.WORD);
        return Integer.compare(thisWordsCount, thatWordsCount);
    }
}
