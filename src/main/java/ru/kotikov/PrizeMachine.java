package ru.kotikov;

import ru.kotikov.models.Toy;
import ru.kotikov.util.FileUtil;

import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class PrizeMachine {
    public static final String outputPrizesPath = "outputPrizes";

    public Toy takePrize() {
        String inputPrizesPath = "inputPrizes";
        String[] strings = FileUtil.readTextFromFile(inputPrizesPath).split("\n");
        if (strings[0].isBlank()) {
            System.out.println("Prizes file is empty");
            return null;
        } else {
            String[] toy = strings[0].split(" ");
            strings = Arrays.copyOfRange(strings, 1, strings.length);
            FileUtil.writeTextIntoFile(inputPrizesPath, String.join("\n", strings), StandardOpenOption.TRUNCATE_EXISTING);
            return new Toy(Long.parseLong(toy[0]), toy[1]);
        }
    }

    public void givePrise(Toy toy) {
        FileUtil.writeTextIntoFile(outputPrizesPath, toy.toString(), StandardOpenOption.APPEND);
    }
}
