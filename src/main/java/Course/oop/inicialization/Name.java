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
        public Name(String personName, String familyName) {
            this(personName, familyName, "");
        }

        @Contract(value = "_, _ -> new", pure = true)
        public static @NotNull Name ofPersonNameAndFamilyName(String personName, String familyName) {
            return new Name(personName, familyName, "");
        }

        @Contract(value = "_, _ -> new", pure = true)
        public static @NotNull Name ofPersonNameAndPatronymic(String personName, String patronymic) {
            return new Name(personName, "", patronymic);
        }
        public Name(String personName) {
            this(personName, "", "");
        }
}
