package gradesSecondTask;

public class GradesReversed {

    public static void main(String[] args) {
        GradesReversed gradesReversed = new GradesReversed();
        String[] grades = new String[3];
        grades[0] = "Вероника Чехова физика — Безупречно";
        grades[1] = "Анна Строкова математика — Потрясающе";
        grades[2] = "Иван Петров геометрия — Безупречно";
        System.out.println(gradesReversed.serializeGrades(grades));
    }

    private String gradeStringToInt(String grade) {
        switch (grade) {
            case "Безупречно": {
                return "5";
            }
            case "Потрясающе": {
                return "4";
            }
            case "Восхитительно": {
                return "3";
            }
            case "Прекрасно": {
                return "2";
            }
            default:
                return "1";
        }
    }

    public String serializeGrades(String[] grades) {
        String[] list = new String[grades.length];
        for (int i = 0; i < grades.length; i++) {
            String[] split = grades[i].split(" ");
            list[i] = String.join(",", split[0].toLowerCase(), split[1].toLowerCase(), split[2], gradeStringToInt(split[4]));
        }
        return String.join(";", list);
    }
}
