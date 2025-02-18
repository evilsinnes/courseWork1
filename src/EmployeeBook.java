import java.util.Random;

class EmployeeBook {
    private static  Employee[] employees;
    private static int size;
    private static Random random = new Random();
    private static String[] names = {"Александр", "Петр", "Сергеей", "Павел", "Кирилл", "Артем", "Иван", "Алексей", "Евгений", "Назар"};
    private static String[] lastname = {"Иванов", "Петров", "Сидоров", "Васечкин", "Кириллов", "Сергеев", "Ильин", "Якров", "Михайлов", "Щукин"};
    private static String[] surname = {"Иванович", "Петрович", "Павлович", "Сергеевич", "Андреевич", "Евгеньевич", "Александрович", "Игоревич"};

    public EmployeeBook(int capacity) {
        this.employees = new Employee[capacity];
        this.size = 0;
    }



    public static void generateRandomEmployees() {
        for (int i = 0; i < employees.length; i++) {
            String fullName = lastname[random.nextInt(lastname.length)] + " " +
                    names[random.nextInt(names.length)] + " " +
                    surname[random.nextInt(surname.length)];
            employees[i] = new Employee(fullName, random.nextInt(1, 6), random.nextInt(50000, 100000));
            size++;
        }
    }

    public boolean addEmployee(Employee employee) {
        if (size >= employees.length) {
            return false; // Нет свободных мест
        }
        employees[size++] = employee;
        return true;
    }

    public static boolean removeEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[--size] = null;
                return true;
            }
        }
        return false; // Сотрудник не найден
    }

    public static Employee getEmployeeById(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }
    //метод для выведения всех сотрудников
    public static void printEmployee() {
        System.out.println("Main.printEmployee");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
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
    public static void indexAllSalaries(double persent) {
        System.out.println("Main.indexAllSalaries");
        for (Employee employee : employees)
            if (employee != null) {
                double newSalary = employee.getSalary() * (1 + persent / 100);
                employee.setSalary((int) newSalary);
            }
    }

    // метод для расчета затрат на ЗП в месяц
    public static int calcSumSalary() {
        System.out.println("Main.calcSumSalary");
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }
    // метод для поиска сотрудника с минимальной ЗП
    public static Employee findEmployeeWithMinSalary() {
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
    protected static Employee findEmployeeWithMaxSalary() {
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
    public static double calcAverageSalary() {
        System.out.println("\nMain.calcAverageSalary");
        return (double) calcSumSalary() / employees.length;
    }
    // метод для печати ФИО
    public static void printFullName() {
        System.out.println("\nMain.printFullName");
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }
}
