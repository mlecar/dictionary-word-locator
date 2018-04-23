package com.mlc.dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

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

    public void readFile() throws IOException {

        Set<String> twoLetters = new HashSet<>();
        Set<String> threeLetters = new HashSet<>();
        Set<String> fourLetters = new HashSet<>();
        Set<String> sixLetters = new HashSet<>();

        Resource resource = resourceLoader.getResource(dictionaryFile);

        InputStream is = resource.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line = br.readLine()) != null) {

            switch (line.length()) {
            case 2:
                twoLetters.add(line);
                break;
            case 3:
                threeLetters.add(line);
                break;
            case 4:
                fourLetters.add(line);
                break;
            case 6:
                sixLetters.add(line);
                break;

            default:
                break;
            }
        }
        br.close();

        for (String s6 : sixLetters) {
            if (twoLetters.contains(s6.substring(0, 2)) && fourLetters.contains(s6.substring(2, 6)) || threeLetters.contains(s6.substring(0, 3)) && threeLetters.contains(s6.substring(3, 6))
                    || fourLetters.contains(s6.substring(0, 4)) && twoLetters.contains(s6.substring(4, 6))) {
                System.out.println(s6);
            }
        }
    }

}
