package com.epam.ap.util;

import java.io.InputStream;
import java.util.Scanner;

public class ResourceService {
    public static String getResourceAsString(String path) {
        InputStream in = ResourceService.class.getClassLoader().getResourceAsStream(path);
        Scanner sc = new Scanner(in);
        return sc.useDelimiter("\\A").next();
    }
}
