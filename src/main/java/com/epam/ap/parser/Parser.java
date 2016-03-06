package com.epam.ap.parser;

import com.epam.ap.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String paragraphRegex = "(?<=\\n)(?=\\S)";
    private static final String sentenceRegex = "(?<=[^A-ZА-Я0-9].)(?<=[.!?])(?= [[— ?\"]]?[A-ZА-Я0-9])";

    public static Text parseText(String source) {
        Text result = new Text();
        String[] strings = source.split(paragraphRegex);
        for (String string : strings) {
            Paragraph paragraph = parseParagraph(string);
            result.add(paragraph);
        }
        return result;
    }

    private static Paragraph parseParagraph(String source) {
        Paragraph result = new Paragraph();
        result.setType(TextComponent.Type.PARAGRAPH);
        String[] strings = source.split(sentenceRegex);
        for (String string : strings) {
            Sentence sentence = parseSentence(string);
            result.add(sentence);
        }
        return result;
    }

    private static Sentence parseSentence(String source) {
        Sentence result = new Sentence();
        result.setType(TextComponent.Type.SENTENCE);
        final String whitespace =  "(?<whitespace>\\s)";
        final String wordRegex = "(?<word>\\w+)";
        final String punct = "(?<punct>\\p{P})";
        final String or = "|";
        Matcher matcher = Pattern.compile(wordRegex + or + punct + or + whitespace, Pattern.UNICODE_CHARACTER_CLASS).matcher(source);

        while (matcher.find()) {
            if (matcher.group("word") != null) {
                final Word word;
                word = new Word(matcher.group());
                word.setType(TextComponent.Type.WORD);
                result.add(word);
            }
            if (matcher.group("punct") != null)
                result.add(SentenceSymbol.valueOf(matcher.group().charAt(0), TextComponent.Type.PUNCTUATION));
            if (matcher.group("whitespace") != null)
                result.add(SentenceSymbol.valueOf(matcher.group().charAt(0), TextComponent.Type.WHITESPACE));
        }

        return result;
    }

}
