package com.mlc.dictionary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CustomDictionaryTest {

    @InjectMocks
    private CustomDictionary customDictionary;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkComposedWords() {
        customDictionary.add("ab");
        customDictionary.add("cdef");
        customDictionary.add("abcdef");
        customDictionary.add("nofit");

        List<String> words = customDictionary.searchComposedWords();

        assertTrue(words.contains("abcdef"));
        assertFalse(words.contains("nofit"));
    }

}
