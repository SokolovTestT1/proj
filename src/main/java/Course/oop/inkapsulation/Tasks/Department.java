package Course.oop.inkapsulation.Tasks;

public class Department {
    private String name;
    private Employee head;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        // Если сотрудника ставят начальником — он должен быть в этом отделе
        if (head != null) {
            if (head.getDepartment() != this) {
                throw new IllegalArgumentException("Начальник должен работать в этом отделе!");
            }
        }
        this.head = head;
    }
}