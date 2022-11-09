import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker step = new StepTracker();
        Converter converter = new Converter();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("Введите номер месяца");
                int month = scanner.nextInt();
                if (month < 0 || month >= 12) {
                    System.out.println("Вы ввели некорректное значение месяцев");
                    break;
                }
                System.out.println("Введите номер дня");
                int day = scanner.nextInt();
                if (day < 1 || day > 30) {
                    System.out.println("Вы ввели некорретное значение дней");
                    break;
                }
                System.out.println("Введите количество шагов");
                int stepsPerDay = scanner.nextInt();
                if (stepsPerDay < 0) {
                    System.out.println("Количество шагов не может быть отрицательным");
                } else {
                    step.saveStepsByDay(month, day, stepsPerDay);
                }
            } else if (userInput == 2) {
                System.out.println("Введите номер месяца, за который хотите получить статистику");
                int month = scanner.nextInt();
                step.showStatisticForMonth(month);
                double stepsToKM = converter.convertSteps(step, month);
                System.out.println("В километрах вы прошли " + stepsToKM);
                double stepsToCal = converter.convertStepsToCall(step, month);
                System.out.println("Вы сожгли " + stepsToCal + " килокалорий");
                int stepsBestSeries = converter.maxSeries(step, month);
                System.out.println("Ваша лучшая серия " + stepsBestSeries);
            } else if (userInput == 3) {
                System.out.println("Введите цель по количеству шагов в день");
                int PurposeStepsDay = scanner.nextInt();
                step.stepsInDay(PurposeStepsDay);
            } else if (userInput == 0) {
                System.out.println("Программа завершена");
                return;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }


}




