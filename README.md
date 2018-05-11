## Dictionary Word Locator

This app program process the dictionary attached (wordlist.txt), looking for all six letter words which are composed of two concatenated smaller words (also from the dictionary).

For example:
al + bums => albums
bar + ely => barely
be + foul => befoul
con + vex => convex
here + by => hereby
jig + saw => jigsaw
tail + or => tailor
we + aver => weaver

### How to build?
Just clone it and execute:
```
mvn clean install
```

### How to execute?
After doing the previous step:
```
java -jar word-locator-1.0.0-SNAPSHOT.jar
```

or, if you have a file and want to test it, just execute as follows:
```
java -Ddictionary.file=file:test.txt -jar word-locator-1.0.0-SNAPSHOT.jar
```