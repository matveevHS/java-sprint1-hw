import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData;
    Scanner scanner = new Scanner(System.in);
    int stepsTargetPerDay;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        stepsTargetPerDay = 10000;
    }

    public int stepsInDay() {
        System.out.println("Введите новую цель по количеству шагов в день");
        int newStepsChallenge = scanner.nextInt();
        if (newStepsChallenge < 0) {
            System.out.println("Количество шагов не может быть отрицательным");
        } else {
            stepsTargetPerDay = newStepsChallenge;
            System.out.println("Вы установили новую цель в " + stepsTargetPerDay + " шагов в день");
        }
        return stepsTargetPerDay;
    }
    static class MonthData {
        public int[] days = new int[30];
    }

    public void showStatisticForMonth(int month, Converter converter, StepTracker step) {
        int sum = 0;
        int max = 0;
        for (int i = 1; i <= 30; i++) {
            System.out.print(i + " день: " + monthToData[month].days[i - 1] + ", ");
            sum = sum + monthToData[month].days[i - 1];
            if (max < monthToData[month].days[i - 1]) {
                max = monthToData[month].days[i - 1];
            }

        }
        int averageSteps = sum / 30;
        System.out.println(" ");
        System.out.println("Всего шагов за месяц " + sum);
        System.out.println("Максимальное количество шагов " + max);
        System.out.println("Среднее количество шагов " + averageSteps);
        converter.maxSeries(step, month);
        converter.convertStepsToCall(step, month);
        converter.convertSteps(step, month);
    }

    public void saveStepsByDay(int month, int day, int steps) {
        monthToData[month].days[day] = steps;
    }
}


