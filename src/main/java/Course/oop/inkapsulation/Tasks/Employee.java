package Course.oop.inkapsulation.Tasks;

public class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        setDepartment(department); // через сеттер, чтобы проверить и связать начальника
    }

    // Конструктор без отдела — сотрудник может быть "незакреплённым" или получить отдел позже
    public Employee(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        // Если.department изменился и текущий сотрудник — начальник этого отдела,
        // он перестаёт быть начальником старого отдела
        if (this.department != null && this.department.getHead() == this) {
            this.department.setHead(null);
        }

        this.department = department;

        // Если текущий сотрудник назначается в новый отдел и отдел имеет начальника,
        // он не может быть начальником другого отдела, но это уже не нарушит логику,
        // так как он будет "просто сотрудником"
        if (department != null) {
            // Устанавливаем сотрудника в отдел (не перезаписываем начальника, если он уже есть)
            // Но по ТЗ: гарантируем, что начальник всегда работает в том отделе, где он начальник.
            // Значит, если сотрудник — начальник отдела, он должен быть в этом отделе.
            // Мы не меняем начальника отдела здесь — это делается отдельно в классе Department.
        }
    }

    public void setAsHeadOf(Department department) {
        // Если сотрудник становится начальником, он должен быть привязан к этому отделу
        setDepartment(department);
        department.setHead(this);
    }

    @Override
    public String toString() {
        if (department != null && department.getHead() == this) {
            return name + " начальник отдела " + department.getName();
        } else if (department != null) {
            return name + " работает в отделе " + department.getName() + ", начальник которого " + department.getHead().getName();
        } else {
            return name + " не состоит в отделе";
        }
    }
}