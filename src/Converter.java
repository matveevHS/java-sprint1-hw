

public class Converter {

    public void convertSteps(StepTracker step, int month) {
        double sum = 0;
        for (int i = 1; i <= 30; i++) {
            sum += step.monthToData[month].days[i - 1];
        }
        System.out.println("Вы прошли " + ((sum * 75) / 100000) + " километров");
    }

    public void convertStepsToCall(StepTracker step, int month) {
        double sum = 0;
        for (int i = 1; i <= 30; i++) {
            sum += step.monthToData[month].days[i - 1];
        }
        System.out.println("Вы сожгли " + ((sum * 50) / 1000) + " калорий");
    }

    public void maxSeries(StepTracker step, int month) {
        int seria = 0;
        int bestSeries = 0;
        for (int i = 0; i < step.monthToData[month].days.length; i++) {
            if (step.monthToData[month].days[i] >= step.stepsTargetPerDay) {
                seria++;
                if (bestSeries < seria) {
                    bestSeries = seria;
                }
            } else {
                seria = 0;
            }

        }
        System.out.println("Ваша лучшая серия " + bestSeries);
    }
}


