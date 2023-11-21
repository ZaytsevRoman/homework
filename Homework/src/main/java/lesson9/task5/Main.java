package lesson9.task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Logins logins = new Logins();

        while (true) {
            System.out.println("Введите логин");
            String login = in.nextLine();
            if (login.isEmpty()) {
                logins.getLogins().stream()
                        .filter(l -> l.charAt(0) == 'f')
                        .forEach(l -> System.out.println("Логин начинающийся на f: " + l));
                break;
            } else {
                logins.addLogin(login);
            }
        }
    }
}