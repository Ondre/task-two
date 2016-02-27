package com.epam.ap;

import com.epam.ap.entity.Text;
import com.epam.ap.parser.Parser;

import static com.epam.ap.util.ResourceService.getResourceAsString;

public class Runner {

    public static void main(String[] args) {
        String source = getResourceAsString("text.txt");

        Text text = Parser.parseText(source);
        System.out.println(text.toPlainString());
        System.out.println(text.getWordCount());
    }
}
