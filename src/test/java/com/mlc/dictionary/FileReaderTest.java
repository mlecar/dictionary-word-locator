package com.mlc.dictionary;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.ResourceLoader;

public class FileReaderTest {

    @InjectMocks
    private FileReader fileReader;

    @Mock
    private ResourceLoader resourceLoader;

    @Spy
    private CustomDictionary customDictionary;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void wordsComposedBy2Letters() throws IOException {

        StringBuilder sb = new StringBuilder();
        sb.append("ab\n");
        sb.append("cdef\n");
        sb.append("abcdef\n");

        InputStream wordsStream = new ByteArrayInputStream(sb.toString().getBytes());
        when(resourceLoader.getResource(anyString())).thenReturn(new InputStreamResource(wordsStream));
        fileReader.readFile();

        assertTrue(customDictionary.checkExistence("ab", 2));
        assertTrue(customDictionary.checkExistence("cdef", 4));
        assertTrue(customDictionary.checkExistence("abcdef", 6));
    }

    @Test
    public void wordsComposedBy1Letter() throws IOException {

        StringBuilder sb = new StringBuilder();
        sb.append("a\n");
        sb.append("bcdef\n");
        sb.append("abcdef\n");

        InputStream wordsStream = new ByteArrayInputStream(sb.toString().getBytes());
        when(resourceLoader.getResource(anyString())).thenReturn(new InputStreamResource(wordsStream));
        fileReader.readFile();

        assertTrue(customDictionary.checkExistence("a", 1));
        assertTrue(customDictionary.checkExistence("bcdef", 5));
        assertTrue(customDictionary.checkExistence("abcdef", 6));
    }

}
