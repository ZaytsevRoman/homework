package lesson6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {

    public static void write(AppData appData, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for (int i = 0; i < appData.getHeader().length; i++) {
                if (i == appData.getHeader().length - 1) {
                    writer.append(appData.getHeader()[i]);
                    writer.append("\n");
                } else {
                    writer.append(appData.getHeader()[i]);
                    writer.append(";");
                }
            }

            for (int i = 0; i < appData.getData().length; i++) {
                for (int j = 0; j < appData.getData()[i].length; j++) {
                    if (j == appData.getData()[i].length - 1) {
                        writer.append(String.valueOf(appData.getData()[i][j]));
                    } else {
                        writer.append(String.valueOf(appData.getData()[i][j]));
                        writer.append(";");
                    }
                }
                writer.append("\n");
            }

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
