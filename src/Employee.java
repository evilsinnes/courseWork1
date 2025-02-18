import java.util.Objects;


public class Employee {
    private static int idGenerator = 1;
    private int id;
    private String fullName;
    private int department;
    private int salary;


    public Employee(String fullName, int department, int salary) {
        id = idGenerator++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;

    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary);
    }

    @Override
    public String toString() {
        return "id=" + id + ", " + fullName + '\'' +
                ", отдел=" + department +
                ", зарплата=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }
}



