package lesson6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {

    public static void read(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
