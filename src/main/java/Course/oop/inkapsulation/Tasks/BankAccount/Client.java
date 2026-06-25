package Course.oop.inkapsulation.Tasks.BankAccount;

public class Client {
    private String name, surname;
    private int passportSeries, passportNumber;
    private BankAccount[] accounts = new BankAccount[0];

    // Конструктор с паспортными данными и без счетов (массив счетов пустой)
    public Client(String name, String surname, int passportSeries, int passportNumber) {
        this.name = validateNameParam(name, "name");
        this.surname = validateNameParam(surname, "surname");
        this.passportSeries = validatePassportSeries(passportSeries);
        this.passportNumber = validatePassportNumber(passportNumber);
    }

    // Конструктор с паспортными данными и массивом счетов
    public Client(String name, String surname, int passportSeries, int passportNumber, BankAccount[] accounts) {
        this.name = validateNameParam(name, "name");
        this.surname = validateNameParam(surname, "surname");
        this.passportSeries = validatePassportSeries(passportSeries);
        this.passportNumber = validatePassportNumber(passportNumber);
        if (accounts != null) {
            this.accounts = accounts.clone();
        }
    }

    // Вспомогательные методы валидации — теперь они возвращают проверенное значение
    // или кидают исключение — для консистентности
    private static String validateNameParam(String name, String fieldName) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " не может быть null или пустым");
        }
        return name;
    }

    private static int validatePassportSeries(int series) {
        if (series < 1000 || series > 9999) {
            throw new IllegalArgumentException("Серия паспорта должна быть четырёхзначным числом (1000-9999), получено: " + series);
        }
        return series;
    }

    private static int validatePassportNumber(int number) {
        if (number < 100000 || number > 999999) {
            throw new IllegalArgumentException("Номер паспорта должен быть шестизначным числом (100000-999999), получено: " + number);
        }
        return number;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPassportSeries() {
        return passportSeries;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    // Метод, возвращающий ссылку на счет по его уникальному номеру
    public BankAccount getAccountByNumber(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account != null && account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    // Метод, возвращающий массив всех счетов
    public BankAccount[] getAllAccounts() {
        return accounts.clone();
    }

    // Метод, возвращающий суммарный остаток на всех счетах
    public double getTotalBalance() {
        double total = 0;
        for (BankAccount account : accounts) {
            if (account != null) {
                total += account.getBalance();
            }
        }
        return total;
    }

    // Метод, возвращающий массив счетов с положительным остатком
    public BankAccount[] getPositiveBalanceAccounts() {
        int count = 0;
        for (BankAccount account : accounts) {
            if (account != null && account.getBalance() > 0) {
                count++;
            }
        }

        BankAccount[] result = new BankAccount[count];
        int index = 0;
        for (BankAccount account : accounts) {
            if (account != null && account.getBalance() > 0) {
                result[index++] = account;
            }
        }

        return result;
    }

    // Метод добавления счета (расширяет массив счетов)
    public void addAccount(BankAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Счет не может быть null");
        }
        BankAccount[] newAccounts = new BankAccount[accounts.length + 1];
        System.arraycopy(accounts, 0, newAccounts, 0, accounts.length);
        newAccounts[accounts.length] = account;
        accounts = newAccounts;
    }

    // Метод удаления счета по номеру
    public boolean removeAccount(int accountNumber) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                // Создаем новый массив на 1 элемент меньше
                BankAccount[] newAccounts = new BankAccount[accounts.length - 1];
                // Копируем элементы до удаляемого
                System.arraycopy(accounts, 0, newAccounts, 0, i);
                // Копируем элементы после удаляемого
                if (i < accounts.length - 1) {
                    System.arraycopy(accounts, i + 1, newAccounts, i, accounts.length - i - 1);
                }
                accounts = newAccounts;
                return true;
            }
        }
        return false; // счет не найден
    }

    /**
     * Уменьшает баланс счёта, если этот счёт принадлежит клиенту (присутствует в списке accounts).
     * @param account счёт для изменения (должен быть в списке клиентских счетов)
     */
    // Метод уменьшения остатка счета
    public boolean decreaseBalance(BankAccount account, double amount) {
        if (account == null) {
            return false;
        }
        for (BankAccount acc : accounts) {
            if (acc != null && acc.getAccountNumber() == account.getAccountNumber()) {
                if (acc.getBalance() >= amount) {
                    acc.setBalance(acc.getBalance() - amount);
                    return true;
                }
                return false; // недостаточно средств
            }
        }
        return false; // счет не найден в списках клиента
    }

    // Метод увеличения остатка счета
    public boolean increaseBalance(BankAccount account, double amount) {
        if (account == null) {
            return false;
        }
        for (BankAccount acc : accounts) {
            if (acc != null && acc.getAccountNumber() == account.getAccountNumber()) {
                acc.setBalance(acc.getBalance() + amount);
                return true;
            }
        }
        return false; // счет не найден в списках клиента
    }

    @Override
    public String toString() {
        return "Client{name='" + name + "', surname='" + surname +
                "', passport=" + passportSeries + "-" + passportNumber +
                ", accountsCount=" + accounts.length + "}";
    }
}