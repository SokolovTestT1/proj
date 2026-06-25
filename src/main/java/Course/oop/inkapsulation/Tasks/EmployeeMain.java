package Course.oop.inkapsulation.Tasks;

public class EmployeeMain {
    public static void main(String[] args) {
        System.out.println("=== Пример 1: Создание отдела и начальника ===");
        Department hr = new Department("HR");
        Employee director = new Employee("Иван");
        director.setAsHeadOf(hr); // Иван становится начальником отдела HR
        System.out.println(director); // => Иван начальник отдела HR

        System.out.println("\n=== Пример 2: Добавление обычного сотрудника ===");
        Employee worker1 = new Employee("Анна", hr);
        System.out.println(worker1); // => Анна работает в отделе HR, начальник которого Иван

        System.out.println("\n=== Пример 3: Вывод данных об отделе ===");
        System.out.println("Отдел: " + hr.getName() + ", начальник: " + (hr.getHead() != null ? hr.getHead().getName() : "нет"));

        System.out.println("\n=== Пример 4: Смена начальника отдела ===");
        Employee newHead = new Employee("Мария");
        newHead.setAsHeadOf(hr); // Теперь Мария — начальник HR, Иван — обычный сотрудник
        System.out.println(director); // => Иван работает в отделе HR, начальник которого Мария
        System.out.println(newHead);  // => Мария начальник отдела HR

        System.out.println("\n=== Пример 5: Нарушение правила (исключение) ===");
        try {
            Department finance = new Department("Finance");
            Employee boss = new Employee("Сидор");
            boss.setAsHeadOf(finance);
            // Проверка: Сидор должен работать в Finance, если он её начальник
            System.out.println("Сидор в отделе " + boss.getDepartment().getName());
            // Всё хорошо — Сидор в Finance.

            // Попытка вручную "перевести" Сидора в HR — но он уже начальник Finance.
            // Это возможно, но он перестанет быть начальником Finance:
            boss.setDepartment(hr); // теперь он просто сотрудник HR,不再是 начальником Finance!
            System.out.println("Сидор теперь просто сотрудник HR: " + boss);

            System.out.println("Начальник Finance: " + finance.getHead()); // => null
            System.out.println("Проблема: Сидор перестал быть начальником Finance, но мы этого не хотели!");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Пример 6: Защита от нарушения правила в setHead ===");
        try {
            Department it = new Department("IT");
            Employee someone = new Employee("Олег");
            //Someone в другом отделе — попытка поставить его начальником IT без привязки к отделу:
            it.setHead(someone); // -> IllegalArgumentException: Начальник должен работать в этом отделе!
        } catch (IllegalArgumentException e) {
            System.out.println("Ожидаемая ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Пример 7: Правильная установка начальника через setAsHeadOf ===");
        Department it = new Department("IT");
        Employee itHead = new Employee("Олег");
        itHead.setAsHeadOf(it); // корректно: сначала устанавливаем в отдел, затем — начальником
        System.out.println(itHead); // => Олег начальник отдела IT

        System.out.println("\n=== Пример 8: Проверка toString без отдела ===");
        Employee freelance = new Employee("Тимофей", null);
        System.out.println(freelance); // => Тимофей не состоит в отделе
    }
}