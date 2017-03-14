package com.rafagonc.core;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Santander on 3/14/17.
 */
public class StringUtils {

    public static String wordBefore(String input, String word) {
        input = input.replaceAll("\\s+", " ");
        List<String> words = Arrays.asList(input.replace(":","").replace("\n"," ").split(" ")); //remove symbols
        Integer index = -1;
        for (String wordToCompare : words) {
            if (wordToCompare.contains(word)) {
                index = words.indexOf(wordToCompare);
            }
        }
        if (index <= 0) return null;
        else return words.get(index - 1);

    }

}
