package TechnicalTask;

public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i< days.length; i++) {
            System.out.println(i+1+" день: "+days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sum = 0;
        for (int day: days) {
            sum += day;
        }
        return sum;
    }

    int maxSteps() {
        int max = 0;
        for (int day : days) {
            if (day>max) {
                max = day;
            }
        }
        return max;
    }

    int bestSeries(int goalByStepsPerDay) {
        int count = 0;
        int series = 0;
        for (int day : days) {
            if (day>=goalByStepsPerDay) {
                count++;
                if (count>series){
                series = count;
                }
            } else {
                count = 0;
            }
        }
        return series;
    }
}