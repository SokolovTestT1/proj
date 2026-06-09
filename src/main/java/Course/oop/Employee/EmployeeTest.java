package Course.oop.Employee;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e = new Employee("Anton");
        Department dep = new Department(e, "IT");
        Employee e1 = new Employee("John");
        e1.dep = dep;
        Employee e2 = new Employee("Peter");

        e2.dep = dep;
        System.out.println(e1);
        System.out.println(e2);

        dep.boss = e1;
        System.out.println(e1);
        System.out.println(e2);
    }
}
