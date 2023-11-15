package lesson8;

import java.util.LinkedHashMap;
import java.util.Map;

public class Phonebook {

    private LinkedHashMap<String, String> surnameAndPhoneNumberList = new LinkedHashMap<>();

    public void add(String surname, String phoneNumber) {
        surnameAndPhoneNumberList.put(phoneNumber, surname);
    }

    public void get(String surname) {
        for (Map.Entry<String, String> entry : surnameAndPhoneNumberList.entrySet()) {
            if (entry.getValue().equals(surname)) {
                System.out.println(entry.getKey());
            }
        }
    }
}
