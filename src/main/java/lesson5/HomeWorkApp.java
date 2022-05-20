package lesson5;

public class HomeWorkApp {

    static final int EMPLOYEES_COUNT = 5;

    public static void main(String[] args) {
        Employee[] employees = new Employee[EMPLOYEES_COUNT];

        employees[0] = new Employee("Иванов", "Иван", "Иванович", "менеджер", "manager@mail.ru", "81112223344", 42, 1000);
        employees[1] = new Employee("Петров", "Петр", "Петрович", "директор", "boss@mail.ru", "89991112233", 55, 1000);
        employees[2] = new Employee("Сидоров", "Сидор", "Сидорович", "врач", "doctor@mail.ru", "82223334455", 33, 1000);
        employees[3] = new Employee("Федоров", "Федор", "Федорович", "строитель", "builder@mail.ru", "83334445566", 27, 1000);
        employees[4] = new Employee("Андреев", "Андрей", "Андреевич", "адвокат", "lawyer@mail.ru", "84445556677", 30, 1000);

        for (Employee person : employees) {
            if (person.iSOlderThan(40)) {
                System.out.println(person);
            }
        }

    }
}
