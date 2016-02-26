package com.epam.ap;

import com.epam.ap.entity.Text;
import com.epam.ap.parser.Parser;

import java.io.InputStream;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        InputStream in = Runner.class.getClassLoader().getResourceAsStream("text.txt");
        Scanner sc = new Scanner(in);
        String source = sc.useDelimiter("\\A").next();

        Text text = Parser.parseText(source);
        System.out.println(text.toPlainString());
    }
}
