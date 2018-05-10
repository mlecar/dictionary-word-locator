package com.mlc.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class WordProcessor implements CommandLineRunner {

    @Autowired
    private FileReader fileReader;

    @Autowired
    private CustomDictionary customDictionary;

    @Override
    public void run(String... args) throws Exception {

        fileReader.readFile();

        customDictionary.searchComposedWords().forEach(word -> System.out.println(word));
    }

}
