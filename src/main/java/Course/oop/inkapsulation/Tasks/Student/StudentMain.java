package Course.oop.inkapsulation.Tasks.Student;

import java.util.Arrays;

/**
 * Класс для демонстрации использования класса Student.
 * Продемонстрирует создание студентов, добавление оценок,
 * получение оценок и вывод информации о студентах.
 */
public class StudentMain {
    /**
     * Точка входа в программу.
     * Создает несколько студентов, добавляет им оценки
     * и выводит информацию о них.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Создаем первого студента
        Student student1 = new Student("Анна");

        // Добавляем оценки первому студенту
        student1.addGrade(5); // Отлично
        student1.addGrade(4); // Хорошо
        student1.addGrade(3); // Удовлетворительно

        // Создаем второго студента
        Student student2 = new Student("Михаил");

        // Добавляем оценки второму студенту
        student2.addGrade(4);
        student2.addGrade(5);
        student2.addGrade(5);
        student2.addGrade(4);

        // Выводим информацию о студентах
        System.out.println("Информация о студентах:");
        System.out.println(student1);
        System.out.println(student2);

        // Получаем массивы оценок и выводим их отдельно
        System.out.println("\nОценки студента " + student1.getName() + " в виде массива: " + Arrays.toString(student1.getGrades()));
        System.out.println("Оценки студента " + student2.getName() + " в виде массива: " + Arrays.toString(student2.getGrades()));

        // Демонстрация валидации: попытка добавить недопустимую оценку
        try {
            System.out.println("\nПопытка добавить недопустимую оценку (6) студенту " + student1.getName());
            student1.addGrade(6);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Демонстрация попытки создать студента с пустым именем
        try {
            System.out.println("\nПопытка создать студента с пустым именем");
            Student student3 = new Student("   ");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

