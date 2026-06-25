package Course.oop.inkapsulation.Tasks.Square;

import Course.oop.Task.Points;

/**
 * Главный класс для демонстрации использования класса {@link Square}.
 * <p>
 * Продемонстрированы:
 * <ul>
 *   <li>Создание квадрата через конструкторы;</li>
 *   <li>Изменение состояния (координаты и сторона);</li>
 *   <li>Контроль инкапсуляции (защита от внешнего изменения внутреннего состояния);</li>
 *   <li>Обработка ошибок при недопустимых значениях.</li>
 * </ul>
 */
public class SquareMain {
    public static void main(String[] args) {
        // === 1. Создание квадрата по координатам X, Y и длине стороны ===
        System.out.println("=== Создание квадрата через координаты ===");
        Square square1 = new Square(10, 20, 5);
        System.out.println(square1); // → Квадрат в точке Points{X=10, Y=20} со стороной 5

        // === 2. Создание квадрата через объект Points ===
        System.out.println("\n=== Создание квадрата через Points ===");
        Points point = new Points(100, 50);
        Square square2 = new Square(point, 12);
        System.out.println(square2); // → Квадрат в точке Points{X=100, Y=50} со стороной 12

        // === 3. Важно: изменение внешнего объекта point НЕ влияет на square2 (инкапсуляция) ===
        point.setX(999); // ❗Мы меняем внешний объект, но внутри square2 — неизменный
        System.out.println("После изменения внешнего 'point':");
        System.out.println(square2); // → Квадрат в точке Points{X=100, Y=50} со стороной 12 — не изменилось!

        // === 4. Получение координат — безопасно, возвращается копия ===
        System.out.println("\n=== Получение координат ===");
        Points topLeft1 = square1.getTopLeft();
        System.out.println("Координаты square1: " + topLeft1);

        // Изменяем копию — это НЕ повлияет на square1
        topLeft1.setX(777);
        System.out.println("После изменения копии координат:");
        System.out.println(square1); // → Координаты остались 10,20 — как и должно быть

        // === 5. Изменение координат и длины стороны ===
        System.out.println("\n=== Изменение координат и стороны ===");
        square1.setSideLength(8);
        System.out.println("После setSideLength(8): " + square1);

        square1.setTopLeft(30, 40);
        System.out.println("После setTopLeft(30, 40): " + square1);

        // === 6. Обработка ошибок (недопустимые значения) ===
        System.out.println("\n=== Обработка ошибок ===");
        try {
            new Square(0, 0, 0); // ❌ sideLength == 0
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании квадрата с sideLength=0: " + e.getMessage());
        }

        try {
            square1.setSideLength(-3); // ❌ отрицательная сторона
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при setSideLength(-3): " + e.getMessage());
        }

        // === 7. Пример ошибки при передаче null в конструктор или сеттер ===
        try {
            new Square((Points) null, 10); // ❌ null для topLeft
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при null в конструкторе: " + e.getMessage());
        }

        try {
            square1.setTopLeft((Points) null); // ❌ null в сеттере
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при null в setTopLeft: " + e.getMessage());
        }

        // === 8. Повторное использование объекта Points в нескольких квадратах ===
        System.out.println("\n=== Безопасное использование одной точки в нескольких квадратах ===");
        Points commonPoint = new Points(1, 1);
        Square sA = new Square(commonPoint, 5);
        Square sB = new Square(commonPoint, 7);
        System.out.println("sA: " + sA);
        System.out.println("sB: " + sB);

        commonPoint.setX(99);
        System.out.println("После изменения 'commonPoint':");
        System.out.println("sA: " + sA); // → остаётся (1,1)
        System.out.println("sB: " + sB); // → остаётся (1,1)
    }
}