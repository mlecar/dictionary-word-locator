package com.mlc.dictionary;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class CustomDictionary {

    private Set<String> twoLetters;
    private Set<String> threeLetters;
    private Set<String> fourLetters;
    private Set<String> sixLetters;

    public CustomDictionary() {
        twoLetters = new HashSet<>();
        threeLetters = new HashSet<>();
        fourLetters = new HashSet<>();
        sixLetters = new HashSet<>();
    }

    public void add(String word) {
        switch (word.length()) {
        case 2:
            twoLetters.add(word);
            break;
        case 3:
            threeLetters.add(word);
            break;
        case 4:
            fourLetters.add(word);
            break;
        case 6:
            sixLetters.add(word);
            break;
        default:
            break;
        }
    }

    private boolean canBeFormedByConcatenation(String word) {
        if (twoLetters.contains(word.substring(0, 2)) && fourLetters.contains(word.substring(2, 6)) || //
                threeLetters.contains(word.substring(0, 3)) && threeLetters.contains(word.substring(3, 6)) || //
                fourLetters.contains(word.substring(0, 4)) && twoLetters.contains(word.substring(4, 6))) {
            return true;
        }
        return false;
    }

    public void search() {
        sixLetters.stream().filter(p -> canBeFormedByConcatenation(p)).forEach(word -> System.out.println(word));
    }

    /**
     * Just for test
     */
    public boolean checkExistence(String word) {
        return sixLetters.contains(word);
    }

}
