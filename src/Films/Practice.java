package Films;

import java.util.HashMap;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {
        Map<String, Map<String, Double>> films = new HashMap<>();
        Map<String, Double> value = new HashMap<>(){{
            put("IMDb", 8.6);
            put("Kinopoisk", 8.7);
        }};
        films.put("Interstellar", value);

        value = new HashMap<>(){{
            put("IMDb", 8.8);
            put("Kinopoisk", 8.6);
        }};
        films.put("Inception", value);

        value = new HashMap<>(){{
            put("IMDb", 8.3);
            put("Kinopoisk", 8.2);
        }};
        films.put("Star Wars IV: Return of the Jedi", value);

        printInfo(films);
    }
    public static void printInfo(Map<String, Map<String, Double>> films) {
        double max = 0;
        double max2 = 0;
        String maxRatingFilm = null;
        String maxRatingFilm2 = null;
        for (String film : films.keySet()) {
            System.out.println("Фильм: "+film);
            System.out.println("Оценки:");
            for (String val : films.get(film).keySet()) {
                System.out.println(val+": "+ films.get(film).get(val));
                if(val.equals("IMDb")) {
                    if (films.get(film).get(val)>max) {
                        max = films.get(film).get(val);
                        maxRatingFilm = val;
                    }
                } else if (val.equals("Kinopoisk")) {
                    if (films.get(film).get(val)>max2) {
                        max2 = films.get(film).get(val);
                        maxRatingFilm2 = val;
                    }
                }
            }
        }
        System.out.println(maxRatingFilm+" ("+max+")");
        System.out.println(maxRatingFilm2+" ("+max2+")");
    }
}
