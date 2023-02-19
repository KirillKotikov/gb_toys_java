package ru.kotikov.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;

public class FileUtil {

    public static String readTextFromFile(String path) {
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public static void writeTextIntoFile(String path, String text, OpenOption option) {
        try {
            Files.writeString(Paths.get(path), text, option);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
