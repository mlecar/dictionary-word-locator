package com.mlc.dictionary;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class CustomDictionary {

    private Set<String> oneLetter;
    private Set<String> twoLetters;
    private Set<String> threeLetters;
    private Set<String> fourLetters;
    private Set<String> fiveLetters;
    private Set<String> sixLetters;

    public CustomDictionary() {
        oneLetter = new HashSet<>();
        twoLetters = new HashSet<>();
        threeLetters = new HashSet<>();
        fourLetters = new HashSet<>();
        fiveLetters = new HashSet<>();
        sixLetters = new HashSet<>();
    }

    public void add(String word) {
        switch (word.length()) {
        case 1:
            oneLetter.add(word);
            break;
        case 2:
            twoLetters.add(word);
            break;
        case 3:
            threeLetters.add(word);
            break;
        case 4:
            fourLetters.add(word);
            break;
        case 5:
            fiveLetters.add(word);
            break;
        case 6:
            sixLetters.add(word);
            break;
        default:
            break;
        }
    }

    private boolean canBeFormedByConcatenation(String word) {
        if (oneLetter.contains(word.substring(0, 1)) && fiveLetters.contains(word.substring(1, 6)) || //
                twoLetters.contains(word.substring(0, 2)) && fourLetters.contains(word.substring(2, 6)) || //
                threeLetters.contains(word.substring(0, 3)) && threeLetters.contains(word.substring(3, 6)) || //
                fourLetters.contains(word.substring(0, 4)) && twoLetters.contains(word.substring(4, 6)) || //
                fiveLetters.contains(word.substring(0, 5)) && twoLetters.contains(word.substring(5, 6))) {
            return true;
        }
        return false;
    }

    public void searchComposedWords() {
        sixLetters.stream().filter(p -> canBeFormedByConcatenation(p)).forEach(word -> System.out.println(word));
    }

    /**
     * Just for test
     */
    public boolean checkExistence(String word) {
        return sixLetters.contains(word);
    }

}
