package lesson9.task5;

import java.util.ArrayList;

public class Logins {

    private ArrayList<String> logins = new ArrayList<>();

    public void addLogin(String login) {
        logins.add(login);
    }

    public ArrayList<String> getLogins() {
        return logins;
    }
}
