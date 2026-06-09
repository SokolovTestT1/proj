package Course.oop.Employee;

public class Department {
    Employee boss;
    String name;

    public Department(Employee boss, String name) {
        this.boss = boss;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "boss='" + boss.name + '\'' +
                ", department='" + name + '\'' +
                '}';
    }
}
