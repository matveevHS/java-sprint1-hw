public class StepTracker {
    MonthData[] monthToData;
    int stepsTargetPerDay;


    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        stepsTargetPerDay = 10000;
    }

    public int stepsInDay(int stepsIn) {

        stepsTargetPerDay = stepsIn;
        return stepsTargetPerDay;
    }

    static class MonthData {

        public int[] days = new int[30];

        // Заполните класс самостоятельно
    }

    public void showStatisticForMonth(int month) {
        int sum = 0;
        int max = 0;
        for (int i = 1; i <= 30; i++) {
            System.out.print(i + " день: " + monthToData[month].days[i - 1] + ", ");
            sum = sum + monthToData[month].days[i - 1];
            if (max < monthToData[month].days[i - 1]) {
                max = monthToData[month].days[i - 1];
            }

        }
        int averageSteps = max / 30;
        System.out.println(" ");
        System.out.println("Всего шагов за месяц " + sum);
        System.out.println("Максимальное количество шагов " + max);
        System.out.println("Среднее количество шагов " + averageSteps);

    }

    public void saveStepsByDay(int month, int day, int steps) {
        monthToData[month].days[day] = steps;


    }


}


