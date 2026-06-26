package Course.oop.inkapsulation.Tasks.BankAccount.List;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name, surname;
    private int passportSeries, passportNumber;
    private List<BankAccount> accounts = new ArrayList<>();

    // Полный конструктор — «базовый»: принимает всё, включая список счетов
    public Client(String name, String surname, int passportSeries, int passportNumber, List<BankAccount> accounts) {
        this.name = validateNameParam(name, "name");
        this.surname = validateNameParam(surname, "surname");
        this.passportSeries = validatePassportSeries(passportSeries);
        this.passportNumber = validatePassportNumber(passportNumber);
        this.accounts = (accounts != null) ? new ArrayList<>(accounts) : new ArrayList<>();
    }

    // Сокращённый конструктор — без счетов (создаём пустой список)
    public Client(String name, String surname, int passportSeries, int passportNumber) {
        this(name, surname, passportSeries, passportNumber, new ArrayList<>());
    }

    // Вспомогательные методы валидации
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

    public List<BankAccount> getAccounts() {
        return new ArrayList<>(accounts);
    }

    // Метод, возвращающий счет по его номеру (или null, если не найден)
    public BankAccount getAccountByNumber(int accountNumber) {
        return accounts.stream()
                .filter(account -> account != null && account.getAccountNumber() == accountNumber)
                .findFirst()
                .orElse(null);
    }

    // Метод, возвращающий суммарный остаток на всех счетах
    public double getTotalBalance() {
        return accounts.stream()
                .filter(account -> account != null)
                .mapToDouble(BankAccount::getBalance)
                .sum();
    }

    // Метод, возвращающий список счетов с положительным остатком
    public List<BankAccount> getPositiveBalanceAccounts() {
        return accounts.stream()
                .filter(account -> account != null && account.getBalance() > 0)
                .toList();
    }

    // Метод добавления счёта
    public void addAccount(BankAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Счет не может быть null");
        }
        if (getAccountByNumber(account.getAccountNumber()) != null) {
            throw new IllegalArgumentException("Счёт с номером " + account.getAccountNumber() + " уже существует");
        }
        accounts.add(account);
    }

    // Метод удаления счёта по номеру — возвращает true, если удалено
    public boolean removeAccount(int accountNumber) {
        return accounts.removeIf(account -> account != null && account.getAccountNumber() == accountNumber);
    }

    // Метод уменьшения остатка счёта (если счёт принадлежит клиенту)
    public boolean decreaseBalance(BankAccount account, double amount) {
        if (account == null) {
            return false;
        }
        BankAccount found = getAccountByNumber(account.getAccountNumber());
        if (found != null && found.getBalance() >= amount) {
            found.setBalance(found.getBalance() - amount);
            return true;
        }
        return false;
    }

    // Метод увеличения остатка счёта
    public boolean increaseBalance(BankAccount account, double amount) {
        if (account == null) {
            return false;
        }
        BankAccount found = getAccountByNumber(account.getAccountNumber());
        if (found != null) {
            found.setBalance(found.getBalance() + amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Client{name='" + name + "', surname='" + surname +
                "', passport=" + passportSeries + "-" + passportNumber +
                ", accountsCount=" + accounts.size() + "}";
    }
}