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
        System.out.println("\nСотрудник с минимальной ЗП в отделе 1: " + findMinSalaryEmployeeByDepartment(1));
        System.out.println("\nСотрудник с максимальной ЗП в отделе 2: " + findMaxSalaryEmployeeByDepartment(2));

        System.out.println("\nСредний уровень ");
        indexAllSalaries(10);
        printEmployee();
        System.out.println("\nСотрудник с минимальной ЗП в отделе 1: " + findMinSalaryEmployeeByDepartment(1));
        System.out.println("Сотрудник с максимальной ЗП в отделе 2: " + findMaxSalaryEmployeeByDepartment(2));
        System.out.println("Сумма затрат на ЗП по отделу 3: " + calculateTotalSalaryByDepartment(3));
        System.out.println("Средняя ЗП по отделу 4: " + calculateAverageSalaryByDepartment(4));

        System.out.println("\nИндексация зарплат в отделе 5 на 15%:");
        indexSalariesByDepartment(5, 15);
        printEmployee();


        printEmployeesByDepartment(3);
        printEmployeesWithSalaryLessThan(100000);
        printEmployeesWithSalaryGreaterOrEqual(80000);
    }

    // Метод для печати сотрудников с зарплатой меньше указанного числа
    public static void printEmployeesWithSalaryLessThan(double salary) {
        System.out.println("\nсотрудники с ЗП меньше " + salary);
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("ID: " + employee.getId() + ", ФИО: " + employee.getFullName() + ", ЗП: " + employee.getSalary());
            }
        }
    }

    // Метод для печати сотрудников с зарплатой больше или равно указанного числа
    public static void printEmployeesWithSalaryGreaterOrEqual(double salary) {
        System.out.println("\nсотрудники с ЗП больше " + salary);
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("ID: " + employee.getId() + ", ФИО: " + employee.getFullName() + ", ЗП: " + employee.getSalary());
            }
        }
    }
    // Метод для печати всех сотрудников отдела (без отдела)
    public static void printEmployeesByDepartment(int department) {
        System.out.println("\nСотрудники отдела " + department);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("ID: " + employee.getId() + ", ФИО: " + employee.getFullName() + ", ЗП: " + employee.getSalary());
            }
        }
    }

    // Метод для индексации зарплат сотрудников отдела на определенный процент
    public static void indexSalariesByDepartment(int department, double percentage) {
        System.out.println("Main.indexSalariesByDepartment");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                double newSalary = employee.getSalary() * (1 + percentage / 100);
                employee.setSalary((int) newSalary);
            }
        }
    }


    // Метод для подсчета средней зарплаты по отделу
    public static double calculateAverageSalaryByDepartment(int department) {
        System.out.println("Main.calculateAverageSalaryByDepartment");
        double total = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                total += employee.getSalary();
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }
    // Метод для подсчета суммы затрат на зарплаты по отделу
    public static double calculateTotalSalaryByDepartment(int department) {
        System.out.println("Main.calculateTotalSalaryByDepartment");
        double total = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                total += employee.getSalary();
            }
        }
        return total;
    }
    // Метод для поиска сотрудника с минимальной зарплатой в отделе
    public static Employee findMinSalaryEmployeeByDepartment(int department) {
        System.out.println("Main.findMinSalaryEmployeeByDepartment");
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (minSalaryEmployee == null || employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;
    }

    // Метод для поиска сотрудника с максимальной зарплатой в отделе
    public static Employee findMaxSalaryEmployeeByDepartment(int department) {
        System.out.println("Main.findMaxSalaryEmployeeByDepartment");
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (maxSalaryEmployee == null || employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }
    // Метод для индексации зарплат всех сотрудников на определенный процент
    private static void indexAllSalaries(double persent) {
        System.out.println("Main.indexAllSalaries");
        for (Employee employee : employees)
            if (employee != null) {
                double newSalary = employee.getSalary() * (1 + persent / 100);
                employee.setSalary((int) newSalary);
            }
    }
//метод для выведения всех сотрудников
    private static void printEmployee() {
        System.out.println("Main.printEmployee");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
// метод для расчета затрат на ЗП в месяц
    private static int calcSumSalary() {
        System.out.println("Main.calcSumSalary");
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }
// метод для поиска сотрудника с минимальной ЗП
    private static Employee findEmployeeWithMinSalary() {
        System.out.println("Main.findEmployeeWithMinSalary");
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }

        return employeeWithMinSalary;
    }
//метод для поиска сотрудника с максимальной ЗП
    private static Employee findEmployeeWithMaxSalary() {
        System.out.println("Main.findEmployeeWithMaxSalary");
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees) {
            if (employeeWithMaxSalary == null || employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;

    }
// метод для расчета средней зарплаты
    private static double calcAverageSalary() {
        System.out.println("\nMain.calcAverageSalary");
        return (double) calcSumSalary() / employees.length;
    }
// метод для печати ФИО
    private static void printFullName() {
        System.out.println("\nMain.printFullName");
        for (Employee employee: employees) {
            System.out.println(employee.getFullName());
    }



}
}