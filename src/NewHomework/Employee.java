package NewHomework;

public class Employee {
    String name;
    String position;
    double salary;
    public Employee(String newName, String newPosition, double newSalary) {
        name = newName;
        position = newPosition;
        salary = newSalary;
    }
    void displayInfo() {
        System.out.println(name);
        System.out.println(position);
        System.out.println(salary);
    }
}
