package Course.oop.inicialization;

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
        public Name(String personName) {
            this(personName, "", "");
        }
}
