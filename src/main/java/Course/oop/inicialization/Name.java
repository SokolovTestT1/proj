package Course.oop.inicialization;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Name {
/* Это пример неудачного кода
    public Name(String personName, String familyName, String patronymic) {

        if (personName == null) {
            this.personName = "Pete";
        }
        else this.personName = personName;

        if (familyName == null) {
            this.familyName = "";
        }
        else this.familyName = familyName;

        if (patronymic == null) {
            this.patronymic = "";
        }
        else this.patronymic = patronymic;
    }

    public Name(String personName, String familyName) {
        if (personName == null) {
            this.personName = "Pete";
        }
        else this.personName = personName;

        if (familyName == null) {
            this.familyName = "";
        }
        else this.familyName = familyName;
    }

    public Name(String personName) {
        if (personName == null) {
            this.personName = "Pete";
        }
        else this.personName = personName;
    } */

        String personName = "Pete";
        String familyName = "";
        String patronymic = "";

    /**
     * Создаёт полное имя.
     * <p>
     * Если аргумент равен {@code null}, поле не изменяется (остаётся значение по умолчанию).
     *
     * @param personName   имя
     * @param familyName   фамилия
     * @param patronymic   отчество
     * @see #Name(String, String)
     * @see #Name(String)
     */
        public Name(String personName, String familyName, String patronymic) {
            if (personName != null) {
                this.personName = personName;
            }
            if (familyName != null) {
                this.familyName = familyName;
            }
            if (patronymic != null) {
                this.patronymic = patronymic;
            }
        }

    /**
     * Создаёт имя с именем и фамилией.
     * <p>
     * Отчество устанавливается в пустую строку.
     *
     * @param personName имя
     * @param familyName фамилия
     * @see #Name(String, String, String)
     */
        public Name(String personName, String familyName) {
            this(personName, familyName, "");
        }

    /**
     * Создаёт имя с именем и фамилией (фабричный метод).
     *
     * @param personName имя
     * @param familyName фамилия
     * @return новый экземпляр с заданными полями
     */
        @Contract(value = "_, _ -> new", pure = true)
        public static @NotNull Name ofPersonNameAndFamilyName(String personName, String familyName) {
            return new Name(personName, familyName, "");
        }

    /**
     * Создаёт имя с именем и отчеством (фабричный метод).
     *
     * @param personName   имя
     * @param patronymic   отчество
     * @return новый экземпляр с заданными полями
     */
        @Contract(value = "_, _ -> new", pure = true)
        public static @NotNull Name ofPersonNameAndPatronymic(String personName, String patronymic) {
            return new Name(personName, "", patronymic);
        }

    /**
     * Создаёт имя только с именем.
     * <p>
     * Фамилия и отчество устанавливаются в пустые строки.
     *
     * @param personName имя
     * @see #Name(String, String, String)
     */
        public Name(String personName) {
            this(personName, "", "");
        }

    @Override
    public String toString() {
        return "Name{" +
                "personName='" + personName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
