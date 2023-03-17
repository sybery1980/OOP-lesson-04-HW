
package oop.lesson_04;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public final class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Diary diary = new Diary();

        Calendar currDate = new GregorianCalendar();
        Calendar task1startTime = (Calendar) currDate.clone();
        task1startTime.add(Calendar.DAY_OF_MONTH, 1);
        Calendar task1deadlineTime = (Calendar) task1startTime.clone();
        task1deadlineTime.add(Calendar.DAY_OF_MONTH, 5);

        Task task1 = new Task("Task number 1", Priority.NORMAL, task1startTime, task1deadlineTime);

        Calendar task2startTime = (Calendar) currDate.clone();
        task2startTime.add(Calendar.DAY_OF_MONTH, 4);
        Calendar task2deadlineTime = (Calendar) task2startTime.clone();
        task2deadlineTime.add(Calendar.DAY_OF_MONTH, 10);

        Task task2 = new Task("Task number 2", Priority.LOW, task2startTime, task2deadlineTime);

        Calendar task3startTime = (Calendar) currDate.clone();
        task3startTime.add(Calendar.DAY_OF_MONTH, 3);
        Calendar task3deadlineTime = (Calendar) task3startTime.clone();
        task3deadlineTime.add(Calendar.DAY_OF_MONTH, 4);

        Task task3 = new Task("Task number 3", Priority.HIGH, task3startTime, task3deadlineTime);


        Calendar task4startTime = (Calendar) currDate.clone();
        task4startTime.add(Calendar.MONTH, 1);
        Calendar task4deadlineTime = (Calendar) task4startTime.clone();
        task4deadlineTime.add(Calendar.MONTH, 2);

        Task task4 = new Task("Task number 4", Priority.LOW, task4startTime, task4deadlineTime);


        Calendar task5startTime = (Calendar) currDate.clone();
        task5startTime.add(Calendar.DAY_OF_MONTH, 1);
        Calendar task5deadlineTime = (Calendar) task5startTime.clone();
        task5deadlineTime.add(Calendar.DAY_OF_MONTH, 6);

        Task task5 = new Task("Task number 5", Priority.NORMAL, task5startTime, task5deadlineTime);


        diary.addTask(task1);
        diary.addTask(task2);
        diary.addTask(task3);
        diary.addTask(task4);
        diary.addTask(task5);


        while (true) {
            int choice = App.menu(diary, scanner);

            if (choice == 0)
                break;

            switch (choice) {
                case 1:
                    int i = 1;
                    for (Task task : diary) {
                        System.out.println(i + ": " + task);
                        i++;
                    }
                    break;
                case 2:
                    App.showDiarySoretdByTime(diary);
                    break;
                case 3:
                    App.showDiarySoretdByDeadlineTime(diary);
                    break;
                case 4:
                    App.showDiarySortedByPriority(diary);
                    break;
            }
        }
    }

    public static int menu(Diary diary, Scanner scanner) {
        System.out.println("В списке находится " + diary.getQuontity() + " задач\n");

        while (true) {
            System.out.println("Выберите что вы хотите сделать:\n");
            System.out.println("1 - показать список текущих задач");
            System.out.println("2 - показать список текущих задач отсортированный по времени их начала");
            System.out.println("3 - показать список текущих задач отсортированный по времени их завершения");
            System.out.println("4 - показать список текущих задач отсортированный по приоритету");
            System.out.println("0 - выход");

            char ch = scanner.next().charAt(0);
            System.out.println();

            switch (ch) {
                case '0':
                    return 0;
                case '1':
                    return 1;
                case '2':
                    return 2;
                case '3':
                    return 3;
                case '4':
                    return 4;
                default:
                    System.out.println("неправильный ввод, повторите!\n");
            }
        }
    }

    public static void showDiarySoretdByTime(Diary diary) {
        for (Task task : diary.getSortedByStartTime()) {
            System.out.println(task);
        }
    }

    public static void showDiarySoretdByDeadlineTime(Diary diary) {
        for (Task task : diary.getSortedByDeadlineTime()) {
            System.out.println(task);
        }
    }

    public static void showDiarySortedByPriority(Diary diary) {
        for (Task task : diary.getSortedByPriority()) {
            System.out.println(task);
        }
    }
}
