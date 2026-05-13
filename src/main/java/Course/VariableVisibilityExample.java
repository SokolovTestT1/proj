package Course;

public class VariableVisibilityExample {

    // ПОЛЕ КЛАССА (статическая и нестатическая переменные)
    // Доступны во всём классе, включая все методы.
    // Статическое поле принадлежит самому классу, а не экземпляру.
    private static String staticField = "Статическое поле";

    // Нестатическое поле принадлежит каждому экземпляру класса.
    private String instanceField = "Поле экземпляра";

    public static void main(String[] args) {
        // ЛОКАЛЬНАЯ ПЕРЕМЕННАЯ (объявлена внутри метода)
        // Доступна только внутри этого метода.
        String localVar = "Локальная переменная в main";
        System.out.println(localVar);
        System.out.println(staticField); // ✅ можно: статическое поле доступно в статическом методе

        // ❌ Нельзя напрямую использовать instanceField в static методе:
        // System.out.println(instanceField); // Ошибка! Нужен экземпляр

        // Создаём экземпляр, чтобы получить доступ к нестатическим полям
        VariableVisibilityExample obj = new VariableVisibilityExample();
        System.out.println(obj.instanceField);

        // БЛОКИ: например, условный оператор
        if (true) {
            // Переменная, объявленная внутри блока, видна только в нём!
            String blockVar = "Переменная блока";
            System.out.println(blockVar);
            // Здесь можно использовать localVar и staticField
            System.out.println(localVar);
        }

        // System.out.println(blockVar); // ❌ Ошибка! blockVar не существует вне блока

        methodExample(); // Вызов другого статического метода
    }

    public static void methodExample() {
        // Эта переменная — локальная для метода methodExample
        String methodLocal = "Локально в methodExample";

        // Доступ к статическому полю — возможен
        System.out.println(staticField);

        // Доступ к локальной переменной из main — невозможен!
        // System.out.println(localVar); // ❌ Так нельзя!

        // ЦИКЛ: демонстрация области видимости
        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
            // Переменная цикла i видна только здесь
        }
        // System.out.println(i); // ❌ Ошибка: i не существует вне цикла

        // Но если объявить переменную до цикла — она будет доступна после
        int j = 0;
        for (j = 0; j < 3; j++) {
            System.out.println("j внутри цикла = " + j);
        }
        System.out.println("j после цикла = " + j); // ✅ Работает!

        // ПЕРЕОПРЕДЕЛЕНИЕ ИМЁН (не рекомендуется!)
        String staticField = "Локальная версия staticField";
        System.out.println("Локально: " + staticField);         // ❗ Локальная переменная "закрывает" поле
        System.out.println("Через класс: " + VariableVisibilityExample.staticField); // Явный доступ к полю
    }

    /*
     * Правила видимости в Java:
     *
     * 1. Поля класса (глобальные):
     *    - Видны во всём классе.
     *    - Статические — через имя класса или в статических контекстах.
     *    - Нестатические — только через экземпляр.
     *
     * 2. Локальные переменные:
     *    - Объявляются внутри метода, конструктора или блока.
     *    - Живут только во время выполнения этого блока.
     *    - Не могут быть доступны вне своей области (например, за пределами if/for).
     *
     * 3. Приоритет имён:
     *    - Локальная переменная "закрывает" поле с тем же именем.
     *    - Используйте this. для доступа к полям экземпляра (в нестатических методах).
     *
     * 4. Циклы:
     *    - Переменная объявленная в for(int i...) — недоступна после цикла.
     *    - Если объявлена до цикла — доступна после.
     */

}