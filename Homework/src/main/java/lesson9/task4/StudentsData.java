package lesson9.task4;

import java.util.*;

public class StudentsData {

    Collection<Student> students = Arrays.asList(
            new Student("митрий", 17, Gender.MAN),
            new Student("Максим", 20, Gender.MAN),
            new Student("Екатерина", 20, Gender.WOMAN),
            new Student("Михаил", 28, Gender.MAN));

    public void getAverageAge() {
        OptionalDouble averageAge = students.stream()
                .filter(student -> student.getGender().equals(Gender.MAN))
                .mapToInt(student -> student.getAge())
                .average();
        System.out.println("Средний возраст студентов мужского пола: " + averageAge.getAsDouble());
    }

    public void getStudentsWithMilitaryAge() {
        students.stream()
                .filter(student -> student.getGender().equals(Gender.MAN))
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 27)
                .forEach(student -> System.out.println("Повестка грозит: " + student));
    }

    private enum Gender {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(gender, student.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }
}
