package DataTypes;

/*
 * Класс Types — демонстрация темы: Приведение типов в Java.
 *
 * Приведение типов (Type Casting) — это процесс преобразования значения одного типа данных в другой.
 * В Java существует два вида приведения:
 *
 * 1. Неявное приведение (автоматическое, widening)
 *    - Происходит автоматически, когда значение меньшего типа присваивается переменной большего типа.
 *    - Безопасно, данные не теряются.
 *
 *    Пример: byte → short → int → long → float → double
 *
 * 2. Явное приведение (приведение вручную, narrowing)
 *    - Требуется при присваивании значения большего типа переменной меньшего типа.
 *    - Может привести к потере данных или искажению значения.
 *    - Синтаксис: (тип) значение
 */

public class TypeCastingDemo {
    public static void main(String[] args) {
        // 1. Неявное приведение (widening)
        int intValue = 100;
        long longValue = intValue;   // int → long (автоматически)
        double doubleValue = longValue; // long → double (автоматически)

        System.out.println("Неявное приведение:");
        System.out.println("int to long: " + longValue);
        System.out.println("long to double: " + doubleValue);

        // 2. Явное приведение (narrowing)
        double d = 123.987;
        int convertedInt = (int) d; // double → int (явно), дробная часть отбрасывается

        System.out.println("\nЯвное приведение:");
        System.out.println("double: " + d);
        System.out.println("После (int) d: " + convertedInt); // Результат: 123

        // Пример потери данных
        byte b = (byte) 1000; // int → byte (с переполнением)
        System.out.println("1000 как byte: " + b); // Результат может быть отрицательным из-за переполнения

        // Примеры других преобразований
        // char можно приводить к числовым типам
        char ch = 'A';
        int charToInt = ch; // 'A' → 65 (неявно)
        System.out.println("char 'A' как int: " + charToInt);

        // Обратное: число в символ
        char intToChar = (char) 66;
        System.out.println("66 как char: " + intToChar); // 'B'
    }
}
