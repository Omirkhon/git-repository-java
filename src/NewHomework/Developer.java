package NewHomework;

public class Developer extends Employee{
    String mainProgrammingLanguage;
    public Developer(String newName, double newSalary, String newMainLang) {
        super(newName, "Разработчик", newSalary);
        mainProgrammingLanguage = newMainLang;
    }

    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println(mainProgrammingLanguage);
    }
}