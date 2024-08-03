package gradesTask;

public class Grades {

    public static void main(String[] args) {
        Grades grade = new Grades();
        String grades = "вероника,чехова,ФИЗИКА,5;анна,строкова,МАТЕМАТИКА,4;иван,петров,ГЕОМЕТРИЯ,5";
        grade.gradeBeautifier(grades);
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase()+" ";
    }

    private String gradeToString(String grade) {
        switch (grade) {
            case "5": {
                return "Безупречно";
            }
            case "4": {
                return "Потрясающе";
            }
            case "3": {
                return "Восхитительно";
            }
            case "2": {
                return "Прекрасно";
            }
            default:
                return "Очаровательно";
        }
    }

    // grades - строка вида "имя,фамилия,предмет,оценка;имя,фамилия,предмет,оценка;"
    public void gradeBeautifier(String grades) {
        String[] split = grades.split(";");
        for (String string : split) {
            StringBuilder builder = new StringBuilder();
            String[] splitTwo = string.split(",");
            for (int i = 0; i<splitTwo.length-1; i++) {
                if (i == 0 || i == 1) {
                    builder.append(capitalize(splitTwo[i]));
                } else {
                    builder.append(splitTwo[i].toLowerCase());
                }
            }
            builder.append(" - ");
            builder.append(gradeToString(splitTwo[3]));
            System.out.println(builder);
        }
    }
}
