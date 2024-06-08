package NewHomework;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Роберт", "Клерк", 2000);
        employee.displayInfo();
        Manager manager = new Manager("Джон", 3000, "Научный департамент");
        manager.displayInfo();
        Developer developer = new Developer("Йохан", 5000, "Java");
        developer.displayInfo();
    }
}
