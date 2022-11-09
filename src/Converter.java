

public class Converter {

    public double convertSteps(StepTracker step, int month) {
        int sum = 0;
        for (int i = 1; i <= 30; i++) {
            sum += step.monthToData[month].days[i - 1];
        }
        return (sum * 75) / 1000;
    }

    public double convertStepsToCall(StepTracker step, int month) {
        int sum = 0;
        for (int i = 1; i <= 30; i++) {
            sum += step.monthToData[month].days[i - 1];
        }
        return (sum * 50) / 1000;
    }

    public int maxSeries(StepTracker step, int month) {
        int seria = 0;
        int bestSeries = 0;
        for (int i = 1; i <= 30; i++) {
            if (step.monthToData[month].days[i - 1] >= step.stepsTargetPerDay) {
                seria++;
            } else if (step.monthToData[month].days[i - 1] < step.stepsTargetPerDay) {
                if (seria >= bestSeries) {
                    bestSeries = seria;
                }
                seria = 0;
            }
        }
        return bestSeries;
    }
}


