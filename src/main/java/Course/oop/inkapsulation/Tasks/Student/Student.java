package Course.oop.inkapsulation.Tasks.Student;

import java.util.Arrays;

/**
 * Класс, представляющий студента с его именем и оценками.
 * Поддерживает добавление оценок (от 2 до 5), получение всех оценок
 * и текстовое представление данных в формате: "Имя: [оценка1, оценка2,...,оценкаN]".
 */
public class Student {
    /**
     * Имя студента.
     */
    private String name;

    /**
     * Массив для хранения оценок.
     * Размер массива может изменяться динамически при добавлении новых оценок.
     */
    private int[] grades;

    /**
     * Количество фактически добавленных оценок в массиве.
     * Используется для отслеживания реального количества элементов.
     */
    private int gradesCount;

    /**
     * Создает нового студента с указанным именем.
     *
     * @param name имя студента (не может быть null или пустой строкой)
     */
    public Student(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя студента не может быть пустым или null");
        }
        this.name = name;
        this.grades = new int[10]; // начальная ёмкость массива
        this.gradesCount = 0;
    }

    /**
     * Добавляет новую оценку студенту.
     * Оценка должна быть в диапазоне от 2 до 5 включительно.
     * Массив оценок автоматически увеличивается при необходимости.
     *
     * @param grade новая оценка (целое число от 2 до 5)
     * @throws IllegalArgumentException если оценка вне допустимого диапазона
     */
    public void addGrade(int grade) {
        // Валидация оценки: должна быть в диапазоне от 2 до 5
        if (grade < 2 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5");
        }

        // Если массив заполнен, увеличиваем его размер в 2 раза
        if (gradesCount >= grades.length) {
            grades = Arrays.copyOf(grades, grades.length * 2);
        }

        // Добавляем оценку и увеличиваем счетчик
        grades[gradesCount++] = grade;
    }

    /**
     * Возвращает копию массива всех оценок студента.
     * Возвращается копия массива для защиты инкапсуляции —
     * изменения возвращаемого массива не повлияют на внутренние данные объекта.
     *
     * @ массив всех оценок (может быть пустым, если оценок нет)
     */
    public int[] getGrades() {
        return Arrays.copyOf(grades, gradesCount);
    }

    /**
     * Возвращает строковое представление студента в формате:
     * "Имя: [оценка1, оценка2, ..., оценкаN]".
     *
     * @ строковое представление студента
     */
    @Override
    public String toString() {
        return name + ": " + Arrays.toString(Arrays.copyOf(grades, gradesCount));
    }

    /**
     * Возвращает имя студента.
     *
     * @ имя студента
     */
    public String getName() {
        return name;
    }
}