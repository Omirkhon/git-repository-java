package HomeTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PotatoLaboratory {

    public static void main(String[] args) {
        List<Potato> potatoes = List.of(
                new Potato(1, 30, 30, 30),
                new Potato(2, 35, 31, 35),
                new Potato(3, 40, 35, 44),
                new Potato(4, 28, 44, 41),
                new Potato(5, 33, 23, 30),
                new Potato(6, 35, 33, 33),
                new Potato(7, 38, 41, 24)
        );
        List<Potato> fourUnderExperiment = findPotatoesForExperiment(potatoes);
        List<Potato> newPotatoes = new ArrayList<>(potatoes);

        System.out.println("Картофелины для эксперимента: " + fourUnderExperiment);
    }

    private static List<Potato> findPotatoesForExperiment(List<Potato> potatoes) {
        int i = 1;
        for (Potato p : potatoes) {
            p.compareTo(potatoes.get(i));
            i++;
        }
        Collections.sort(potatoes);
        System.out.println(potatoes.get(0));
        System.out.println(potatoes.get(1));
        System.out.println(potatoes.get(potatoes.size()-2));
        System.out.println(potatoes.get(potatoes.size()-1));
				/* Вычислите две самые большие и две самые маленькие картофелины,
           а затем выведите их в порядке от самых маленьких до самых больших.*/
        return null;
    }
}
