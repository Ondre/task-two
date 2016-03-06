package com.epam.ap.service;

import com.epam.ap.entity.Sentence;
import com.epam.ap.entity.Text;
import com.epam.ap.entity.TextComponent;
import com.epam.ap.entity.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TextService {

    public int getSentenceWithSameWordsCount(Text text){
        int result = 0;

        Iterator<TextComponent> sentenceIterator = text.getIterator(TextComponent.Type.SENTENCE);

        List<String> words =  new ArrayList<>();
        StringBuilder sb;
        String currentWord;
        Word word;
        Sentence sentence;

        while (sentenceIterator.hasNext()) {
            words.clear();
            sentence = (Sentence) sentenceIterator.next();
            Iterator<TextComponent> wordIterator = sentence.getIterator(TextComponent.Type.WORD);

            while (wordIterator.hasNext()) {
                word = (Word) wordIterator.next();
                sb = new StringBuilder();
                word.toPlainString(sb);
                currentWord = sb.toString().toLowerCase();
                if (!words.contains(currentWord)) words.add(currentWord);
                else {result++;break;}
            }
        }

        return result;
    }

    public List<Sentence> getSentencesWithAscendingWordsOrder(Text text){
        List<Sentence> result = new ArrayList<>();
        final Iterator<TextComponent> iterator = text.getIterator(TextComponent.Type.SENTENCE);
        while (iterator.hasNext()) {
            Sentence next = (Sentence) iterator.next();
            result.add(next);
        }
        Collections.sort(result);

        return result;
    }
}
