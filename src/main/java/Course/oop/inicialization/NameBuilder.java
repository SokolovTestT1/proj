package Course.oop.inicialization;

public class NameBuilder {
    String personName;
    String familyName;
    String patronymic;

    public NameBuilder() {
    }
    public NameBuilder addPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    public NameBuilder addFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public NameBuilder addPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }
    public Name build() {
        return new Name(personName, familyName, patronymic);
    }
}
