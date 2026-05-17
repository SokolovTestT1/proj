package Course.conditions;

/**
 * Теория: Условные операторы в Java
 *
 * В Java условные операторы используются для выполнения разных действий в зависимости от выполнения определённых условий.
 * Основные условные конструкции:
 *
 * 1. if — выполняет блок кода, если условие истинно (true).
 * 2. if-else — если условие истинно, выполняется один блок, иначе — другой.
 * 3. if-else if-else — позволяет проверять несколько условий последовательно.
 * 4. switch — альтернатива множественным if-else, используется для проверки значения переменной на совпадение с несколькими случаями.
 *
 * Логические операторы:
 * - && (логическое И) — true, если оба условия истинны.
 * - || (логическое ИЛИ) — true, если хотя бы одно условие истинно.
 * - ! (логическое НЕ) — инвертирует значение.
 *
 * Операторы сравнения:
 * - == (равно)
 * - != (не равно)
 * - < (меньше)
 * - > (больше)
 * - <= (меньше или равно)
 * - >= (больше или равно)
 */

public class Conditions {

    public static void main(String[] args) {
        int age = 18;
        boolean hasLicense = true;

        // Пример 1: if
        if (age >= 18) {
            System.out.println("Вы совершеннолетний.");
        }

        // Пример 2: if-else
        if (age >= 18 && hasLicense) {
            System.out.println("Вы можете водить машину.");
        } else {
            System.out.println("Вы не можете водить машину.");
        }

        // Пример 3: if-else if-else
        int score = 75;
        if (score >= 90) {
            System.out.println("Оценка: A");
        } else if (score >= 80) {
            System.out.println("Оценка: B");
        } else if (score >= 70) {
            System.out.println("Оценка: C");
        } else if (score >= 60) {
            System.out.println("Оценка: D");
        } else {
            System.out.println("Оценка: F");
        }

        // Пример 4: switch
        int dayOfWeek = 3;
        String dayName;
        switch (dayOfWeek) {
            case 1:
                dayName = "Понедельник";
                break;
            case 2:
                dayName = "Вторник";
                break;
            case 3:
                dayName = "Среда";
                break;
            case 4:
                dayName = "Четверг";
                break;
            case 5:
                dayName = "Пятница";
                break;
            case 6:
                dayName = "Суббота";
                break;
            case 7:
                dayName = "Воскресенье";
                break;
            default:
                dayName = "Неверный день";
                break;
        }
        System.out.println("День недели: " + dayName);

        // Пример 5: тернарный оператор (сокращённая форма if-else)
        String result = (age >= 18) ? "Доступ разрешён" : "Доступ запрещён";
        System.out.println(result);
    }
}