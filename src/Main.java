import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker step = new StepTracker();
        Converter converter = new Converter();

        outer:
        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("Введите номер месяца от 0 до 11");
                int month = scanner.nextInt();
                if (month < 0 || month >= 12) {
                    System.out.println("Вы ввели некорректное значение месяца");
                    continue outer;
                }
                System.out.println("Введите номер дня от 0 до 29");
                int day = scanner.nextInt();
                if (day < 0 || day >= 30) {
                    System.out.println("Вы ввели некорретное значение дней");
                    continue outer;
                }
                System.out.println("Введите количество шагов");
                int stepsPerDay = scanner.nextInt();
                if (stepsPerDay < 0) {
                    System.out.println("Количество шагов не может быть отрицательным");
                } else {
                    step.saveStepsByDay(month, day, stepsPerDay);
                }
            } else if (userInput == 2) {
                System.out.println("Введите номер месяца, за который хотите получить статистику от 0 до 11");
                int month = scanner.nextInt();
                if (month < 0 || month >= 12) {
                    System.out.println("Вы ввели некорректное значение месяца");
                    continue outer;
                }
                step.showStatisticForMonth(month, converter, step);
            } else if (userInput == 3) {
                step.stepsInDay();
            } else if (userInput == 0) {
                System.out.println("Программа завершена");
                return;
            } else {
                System.out.println("Извините, такой команды пок что нет.");
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




