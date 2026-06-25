package Course.oop.inkapsulation.Tasks.Fraction;

public class Fraction {
    // Требование 1: Имеет числитель: целое число.
    private final int numerator;

    // Требование 2: Имеет знаменатель: целое число.
    private final int denominator;

    /**
     * Конструктор для создания дроби.
     * Требование 3: Дробь может быть создана с указанием числителя и знаменателя.
     *
     * @param numerator   Числитель (может быть отрицательным - Требование 5)
     * @param denominator Знаменатель (должен быть положительным - Требование 6)
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
        }

        // Нормализация: знаменатель всегда положительный
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        // Сокращение дроби
        int commonDivisor = gcd(Math.abs(numerator), denominator);
        if (commonDivisor > 1) {
            numerator /= commonDivisor;
            denominator /= commonDivisor;
        }

        // ← Только здесь и один раз присваиваем final-полям
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Геттер для числителя (без сеттера для обеспечения неизменяемости)
    public int getNumerator() {
        return numerator;
    }

    // Геттер для знаменателя (без сеттера для обеспечения неизменяемости)
    public int getDenominator() {
        return denominator;
    }

    /**
     * Требование 7: Может вернуть строковое представление вида «числитель/знаменатель».
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * Требование 8: Операция сложения с другой Дробью или целым числом.
     * Результатом операции должна быть новая Дробь.
     */
    public Fraction sum(Fraction other) {
        if (other == null) {
            throw new IllegalArgumentException("Дробь не может быть null");
        }

        // Формула: a/b + c/d = (ad + bc) / bd
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Требование 8: Операция сложения с целым числом.
     * Результатом операции должна быть новая Дробь.
     */
    public Fraction sum(int integer) {
        // Целое число представляем как дробь integer/1
        return this.sum(new Fraction(integer, 1));
    }

    /**
     * Требование 8: Операция вычитания с другой Дробью.
     * Результатом операции должна быть новая Дробь.
     */
    public Fraction minus(Fraction other) {
        if (other == null) {
            throw new IllegalArgumentException("Дробь не может быть null");
        }

        // Формула: a/b - c/d = (ad - bc) / bd
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Требование 8: Операция вычитания с целым числом.
     * Результатом операции должна быть новая Дробь.
     */
    public Fraction minus(int integer) {
        // Целое число представляем как дробь integer/1
        return this.minus(new Fraction(integer, 1));
    }

    // Вспомогательный метод для нахождения НОД (для сокращения дробей)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

// Требование 4: Объекты дробей не могут изменять своё состояние.
// Это достигается за счет использования модификатора 'final' для полей и отсутствия методов-сеттеров.
// Все арифметические операции создают и возвращают НОВЫЙ объект класса Fraction.


