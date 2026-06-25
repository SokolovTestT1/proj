package Course.oop.inkapsulation.Tasks.BankAccount;

public class BankAccountMain {
    public static void main(String[] args) {
        System.out.println("=== Тестирование классов BankAccount и Client ===\n");

        // 1. Создание счетов
        BankAccount account1 = new BankAccount(1001, 5000.0);
        BankAccount account2 = new BankAccount(1002, 0.0);
        BankAccount account3 = new BankAccount(1003, 2500.5);
        System.out.println("✓ Создано 3 счета: account1 (5000), account2 (0), account3 (2500.5)");

        // 2. Создание клиента с начальными счетами
        BankAccount[] initialAccounts = {account1, account3};
        Client client = new Client("Иван", "Иванов", 1234, 567890, initialAccounts);
        System.out.println("✓ Клиент создан: " + client.getName() + " " + client.getSurname() +
                ", паспорт: " + client.getPassportSeries() + " " + client.getPassportNumber());

        // 3. Проверка getAccountByNumber()
        BankAccount found = client.getAccountByNumber(1001);
        System.out.println("\n--- Проверка getAccountByNumber(1001): " + (found != null ? "найден" : "не найден"));
        if (found != null) {
            System.out.println("  → баланс: " + found.getBalance());
        }

        // 4. Проверка getAllAccounts()
        BankAccount[] allAccounts = client.getAllAccounts();
        System.out.println("\n--- getAllAccounts(): получено " + allAccounts.length + " счетов");

        // 5. Проверка getTotalBalance()
        double total = client.getTotalBalance();
        System.out.println("\n--- getTotalBalance(): суммарный остаток = " + total + " ₽");

        // 6. Проверка getPositiveBalanceAccounts()
        BankAccount[] positiveAccounts = client.getPositiveBalanceAccounts();
        System.out.println("\n--- getPositiveBalanceAccounts(): счетов с положительным балансом = " + positiveAccounts.length);
        for (int i = 0; i < positiveAccounts.length; i++) {
            System.out.println("  → Счет #" + positiveAccounts[i].getAccountNumber() + ": " + positiveAccounts[i].getBalance() + " ₽");
        }

        // 7. Добавление счета (addAccount)
        BankAccount newAccount = new BankAccount(1004, 1000.0);
        System.out.println("\n--- addAccount(1004, 1000): добавляем счёт");
        client.addAccount(newAccount);
        System.out.println("  → общее количество счетов после добавления: " + client.getAllAccounts().length);

        // 8. Уменьшение баланса (decreaseBalance)
        System.out.println("\n--- decreaseBalance(account1, 2000): снимаем 2000 с account1 (было 5000)");
        boolean decreased = client.decreaseBalance(account1, 2000);
        System.out.println("  → операция " + (decreased ? "успешна" : "не удалась"));
        System.out.println("  → новый баланс account1: " + account1.getBalance());

        // 9. Увеличение баланса (increaseBalance)
        System.out.println("\n--- increaseBalance(account2, 500): кладём 500 на account2 (было 0)");
        boolean increased = client.increaseBalance(account2, 500);
        System.out.println("  → операция " + (increased ? "успешна" : "не удалась"));
        System.out.println("  → новый баланс account2: " + account2.getBalance());

        // 10. Проверка изменения: getTotalBalance() после транзакций
        double newTotal = client.getTotalBalance();
        System.out.println("\n--- Тот же клиент: обновлённый суммарный остаток = " + newTotal + " ₽");

        // 11. Удаление счёта (removeAccount)
        System.out.println("\n--- removeAccount(1002): удаляем account2 (номер 1002)");
        boolean removed = client.removeAccount(1002);
        System.out.println("  → удалён " + (removed ? "успешно" : "не найден"));
        System.out.println("  → количество счетов после удаления: " + client.getAllAccounts().length);

        // 12. Проверка getPositiveBalanceAccounts() после изменений
        BankAccount[] positiveAfter = client.getPositiveBalanceAccounts();
        System.out.println("\n--- getPositiveBalanceAccounts() после удаления: " + positiveAfter.length + " счетов");
        for (BankAccount acc : positiveAfter) {
            System.out.println("  → Счет #" + acc.getAccountNumber() + ": " + acc.getBalance());
        }

        // 13. Проверка удаления несуществующего счёта
        System.out.println("\n--- removeAccount(9999): удаляем несуществующий счёт");
        boolean notRemoved = client.removeAccount(9999);
        System.out.println("  → результат: " + notRemoved + " (должно быть false)");

        System.out.println("\n=== Все тесты пройдены успешно! ===");
    }
}