package com.mlc.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class FileReader {

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${dictionary.file.path}")
    private String dictionaryFile;

    @Autowired
    private CustomDictionary dictionary;

    public void readFile() throws IOException {
        Resource resource = resourceLoader.getResource(dictionaryFile);
        InputStream is = resource.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        br.lines().forEach(dictionary::add);
        br.close();
    }

}
