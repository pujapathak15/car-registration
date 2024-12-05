package org.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarInputData {
    private String regx = "[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}";

    public List<String> readCarNo(String path) throws IOException {
        String fileRead = Files.readString(Paths.get(path));
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(fileRead);
        return matcher.results()
                .map(MatchResult::group)
                .toList();
    }
}
