package Course.oop.Employee;

public class Employee {
    String name;
    Department dep;

    public Employee(String name){
        this.name = name;
    }

    public Employee(Department dep, String name) {
        this.dep = dep;
        this.name = name;
    }

    @Override
    public String toString() {
        if (this == dep.boss) return name + " boss in " + dep.name;
        return "Employee{" +
                "name='" + name + '\'' +
                ", dep=" + dep +
                '}';
    }
}
