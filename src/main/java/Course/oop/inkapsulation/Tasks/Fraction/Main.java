package Course.oop.inkapsulation.Tasks.Fraction;

/**
 * Тестовый класс для проверки задания 3.1. Дробь.
 *
 * Требование 9: Создать несколько экземпляров дробей и выполнить вычисление:
 *   f1.sum(f2).sum(f3).minus(5)
 *   где f1 = 1/3, f2 = 2/5, f3 = 7/8.
 */
public class Main {
    public static void main(String[] args) {
        // Создаём дроби по условию (Требование 3)
        Fraction f1 = new Fraction(1, 3);  // одна треть → "1/3"
        Fraction f2 = new Fraction(2, 5);  // две пятых → "2/5"
        Fraction f3 = new Fraction(7, 8);  // семь восьмых → "7/8"
        Fraction f4 = new Fraction(9, -10);

        System.out.println(f4);

        // Выполняем вычисление: f1 + f2 + f3 - 5
        // Требование 8: операции sum и minus возвращают НОВУЮ дробь.
        // Это цепочка: ((f1 + f2) + f3) - 5
        Fraction result = f1.sum(f2).sum(f3).minus(5);

        // Требование 7: строковое представление "числитель/знаменатель"
        System.out.println("Результат: " + result);  // → "-407/120"

        // Дополнительно: выводим отдельные части (Требование 1, 2)
        System.out.println("Числитель: " + result.getNumerator());     // -407
        System.out.println("Знаменатель: " + result.getDenominator());  // 120

        // Проверим промежуточные шаги для наглядности:
        System.out.println("\nПромежуточные шаги:");
        System.out.println("f1 = " + f1);         // 1/3
        System.out.println("f2 = " + f2);         // 2/5
        System.out.println("f3 = " + f3);         // 7/8
        System.out.println("f1 + f2 = " + f1.sum(f2));       // 11/15
        System.out.println("f1 + f2 + f3 = " + f1.sum(f2).sum(f3)); // 193/120
        System.out.println("f1 + f2 + f3 - 5 = " + result);        // -407/120

        // Требование 5: отрицательный числитель → отрицательная дробь
        Fraction negative = new Fraction(-1, 3);
        System.out.println("\nОтрицательная дробь (-1/3): " + negative); // "-1/3"
    }
}