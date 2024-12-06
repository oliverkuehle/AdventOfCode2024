package adventofcode.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileReaderUtil {

    public String readFile(String filePath) {
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
        return fileReader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
}
