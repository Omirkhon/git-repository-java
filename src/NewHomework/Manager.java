package NewHomework;

public class Manager extends Employee {
    String department;

    public Manager(String newName, double newSalary, String newDepartment) {
        super(newName, "Менеждер", newSalary);
        department = newDepartment;
    }

    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println(department);
    }
}
