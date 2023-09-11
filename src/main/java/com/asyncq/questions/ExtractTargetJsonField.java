package com.asyncq.questions;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtractTargetJsonField {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> questions = solution("example_2.json");
        System.out.println(questions);
    }

    public static List<String> solution(String path) throws URISyntaxException, IOException {
        URI uri = ClassLoader.getSystemResource(path)
            .toURI();

        String matchingString = "question";
        String endingString = ",";

        return Files.newBufferedReader(Path.of(uri.getPath()))
            .lines()
            .filter(l -> l.contains(matchingString))
            .map(l -> l.substring(l.indexOf(matchingString), l.indexOf(endingString)))
            .toList();
    }
}
