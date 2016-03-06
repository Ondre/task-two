package com.epam.ap;

import com.epam.ap.entity.Sentence;
import com.epam.ap.entity.Text;
import com.epam.ap.parser.Parser;
import com.epam.ap.service.TextService;

import java.util.List;

import static com.epam.ap.util.ResourceService.getResourceAsString;

public class Runner {

    public static void main(String[] args) {
        String source = getResourceAsString("text.txt");

        Text text = Parser.parseText(source);
        TextService ts = new TextService();

        System.out.println(ts.getSentenceWithSameWordsCount(text));
        List<Sentence> sentencesInAscendingOrderOfWordsAmount = ts.getSentencesWithAscendingWordsOrder(text);
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentencesInAscendingOrderOfWordsAmount) {
            sentence.toPlainString(sb);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
