package Course.oop.inkapsulation.Tasks.BankAccount.List;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Пример 1: Создание клиента без счетов (через короткий конструктор)
        Client client1 = new Client("Иван", "Иванов", 1234, 567890);
        System.out.println("Клиент 1: " + client1);
        // Ожидаемый вывод: Client{name='Иван', surname='Иванов', passport=1234-567890, accountsCount=0}

        // Пример 2: Создание нескольких счетов
        BankAccount account1 = new BankAccount(1001, 15000.0);
        BankAccount account2 = new BankAccount(1002, 5000.0);
        BankAccount account3 = new BankAccount(1003, -100.0); // ❗ будет исключение при создании (баланс < 0)

        // Пример 2 (исправленный): избегаем отрицательного баланса
        BankAccount safeAccount3 = new BankAccount(1003, 0.0); // допустимый нулевой баланс

        // Пример 3: Создание клиента с начальными счетами
        List<BankAccount> initialAccounts = new ArrayList<>();
        initialAccounts.add(new BankAccount(2001, 30000.0));
        initialAccounts.add(new BankAccount(2002, 12500.5));

        Client client2 = new Client("Мария", "Петрова", 4567, 112233, initialAccounts);
        System.out.println("Клиент 2: " + client2);
        System.out.println("Общий баланс: " + client2.getTotalBalance()); // 42500.5

        // Пример 4: Добавление нового счёта
        BankAccount newAccount = new BankAccount(3001, 8000.0);
        client2.addAccount(newAccount);
        System.out.println("После добавления счёта 3001: общая сумма = " + client2.getTotalBalance()); // 50500.5
        System.out.println("Клиент 2: " + client2);

        // Пример 5: Попытка дублирования номера счёта — вызовет исключение
        try {
            BankAccount duplicate = new BankAccount(3001, 500.0); // тот же номер 3001
            client2.addAccount(duplicate);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении дубликата: " + e.getMessage());
            // Ошибка: Счёт с номером 3001 уже существует
        }

        // Пример 6: Изменение баланса
        BankAccount targetAccount = client2.getAccountByNumber(2001);
        if (targetAccount != null) {
            System.out.println("Баланс до пополнения: " + targetAccount.getBalance()); // 30000.0
            client2.increaseBalance(targetAccount, 2000.0);
            System.out.println("Баланс после пополнения: " + targetAccount.getBalance()); // 32000.0
        }

        // Пример 7: Снятие средств (успешное и неуспешное)
        BankAccount acc2002 = client2.getAccountByNumber(2002);
        if (acc2002 != null) {
            boolean success = client2.decreaseBalance(acc2002, 500.0); // хватит средств
            System.out.println("Снятие 500 ₽ успешно: " + success); // true
            System.out.println("Новый баланс счёта 2002: " + acc2002.getBalance()); // 12000.5

            // Попытка снять больше, чем есть
            success = client2.decreaseBalance(acc2002, 20000.0); // не хватит (12000.5 < 20000)
            System.out.println("Списание 20000 ₽ успешно: " + success); // false
            System.out.println("Баланс остался: " + acc2002.getBalance()); // всё ещё 12000.5
        }

        // Пример 8: Получение счетов с положительным балансом
        List<BankAccount> positiveAccounts = client2.getPositiveBalanceAccounts();
        System.out.println("Клиент имеет " + positiveAccounts.size() + " счётов с положительным балансом");
        for (BankAccount acc : positiveAccounts) {
            System.out.println("  - Счёт #" + acc.getAccountNumber() + ": " + acc.getBalance() + " ₽");
        }

        // Пример 9: Удаление счёта
        boolean removed = client2.removeAccount(2002);
        System.out.println("Счёт 2002 удалён: " + removed); // true
        System.out.println("Клиент после удаления: " + client2);

        // Пример 10: Обработка null-счетов и исключений при инициализации
        try {
            Client badClient = new Client("", "Сидоров", 1234, 567890); // ❌ пустое имя
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания клиента: " + e.getMessage());
            // Ошибка: name не может быть null или пустым
        }

        try {
            Client badPassport = new Client("Анна", "Кузнецова", 99, 123456); // ❌ серия 2 цифры
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации паспорта: " + e.getMessage());
            // Ошибка: Серия паспорта должна быть четырёхзначным числом...
        }
    }
}