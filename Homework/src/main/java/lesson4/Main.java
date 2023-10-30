package lesson4;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович", "Инженер", "ivanov@dddd.com", "89221221212", 26337, 29);
        employees[1] = new Employee("Петрова Анастасия Васильевна", "Переводчик", "petrova@dddd.com", "8922-333-11-22", 22673, 23);
        employees[2] = new Employee("Кузнецов Павел Алексеевич", "Аналитик", "kuznecov@dddd.com", "8 933 654 27 89", 31337, 32);
        employees[3] = new Employee("Денисов Максим Иванович", "Инженер", "denisov@dddd.com", "89235566313", 27537, 41);
        employees[4] = new Employee("Максимова Ирина Николаевна", "Разработчик", "maksimova@dddd.com", "+7-943-322-43-12", 33337, 27);

        for (Employee e : employees) {
            if (e.getAge() > 40) {
                e.info();
            }
        }
    }
}
