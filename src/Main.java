import java.util.Random;

public class Main {
    private static Random random = new Random();
    private static String[] names = {"Александр", "Петр", "Сергеей", "Павел", "Кирилл", "Артем", "Иван", "Алексей", "Евгений", "Назар"};
    private static String[] lastname = {"Иванов", "Петров", "Сидоров", "Васечкин", "Кириллов", "Сергеев", "Ильин", "Якров", "Михайлов", "Щукин"};
    private static String[] surname = {"Иванович", "Петрович", "Павлович", "Сергеевич", "Андреевич", "Евгеньевич", "Александрович", "Игоревич"};

    private static Employee[] employees = new Employee[10];

    private static void randomFullName() {
        for (int i = 0; i < employees.length; i++) {
            String fullName = lastname[random.nextInt(0, lastname.length)] + " " +
                    names[random.nextInt(0, names.length)] + " " +
                    surname[random.nextInt(0, surname.length)];
            employees[i] = new Employee(fullName, random.nextInt(1, 6), random.nextInt(50000, 100000));

        }
    }

    public static void main(String[] args) {
        randomFullName();
        printEmployee();
        System.out.println(" ");
        System.out.println("сумма затрат на зарплату " + calcSumSalary());
        System.out.println(" ");
        System.out.println("Сотрудник с минимальной ЗП " + findEmployeeWithMinSalary());
        System.out.println(" ");
        System.out.println("Сотрудник с максимальной ЗП " + findEmployeeWithMaxSalary());
        System.out.println(" ");
        System.out.println("Средняя ЗП " + calcAverageSalary());
        System.out.println(" ");
        printFullName();

    }

    private static void printEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int calcSumSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }

        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees) {
            if (employeeWithMaxSalary == null || employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;

    }

    private static double calcAverageSalary() {
        return (double) calcSumSalary() / employees.length;
    }

    private static void printFullName() {
        for (Employee employee: employees) {
            System.out.println(employee.getFullName());
    }

}
}