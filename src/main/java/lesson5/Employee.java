package lesson5;

public class Employee {

    private String surname;
    private String name;
    private String patronymic;
    private String jobPosition;
    private String email;
    private String telephoneNumber;
    private int salary;
    private int age;

    public Employee(String surname, String name, String patronymic, String jobPosition, String email, String telephoneNumber, int age, int salary) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.jobPosition = jobPosition;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.age = age;
        this.salary = salary;
    }

    public boolean iSOlderThan(int age) {
        return this.age > age;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, должность: %s, email: %s, телефон: %s, возраст: %d, зарплата: %d", surname, name, patronymic, jobPosition, email, telephoneNumber, age, salary);
    }
}
