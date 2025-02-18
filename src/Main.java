import java.util.Random;

public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(10);
        EmployeeBook.generateRandomEmployees();
        EmployeeBook.printEmployee();

        System.out.println(" ");
        System.out.println("сумма затрат на зарплату " + EmployeeBook.calcSumSalary());
        System.out.println(" ");
        System.out.println("Сотрудник с минимальной ЗП " + EmployeeBook.findEmployeeWithMinSalary());
        System.out.println(" ");
        System.out.println("Сотрудник с максимальной ЗП " + EmployeeBook.findEmployeeWithMaxSalary());
        System.out.println(" ");
        System.out.println("Средняя ЗП " + EmployeeBook.calcAverageSalary());
        System.out.println(" ");
        EmployeeBook.printFullName();
        System.out.println("\nСотрудник с минимальной ЗП в отделе 1: " + EmployeeBook.findMinSalaryEmployeeByDepartment(1));
        System.out.println("\nСотрудник с максимальной ЗП в отделе 2: " + EmployeeBook.findMaxSalaryEmployeeByDepartment(2));

        System.out.println("\nСредний уровень ");
        EmployeeBook.indexAllSalaries(10);
        EmployeeBook.printEmployee();
        System.out.println("\nСотрудник с минимальной ЗП в отделе 1: " + EmployeeBook.findMinSalaryEmployeeByDepartment(1));
        System.out.println("Сотрудник с максимальной ЗП в отделе 2: " + EmployeeBook.findMaxSalaryEmployeeByDepartment(2));
        System.out.println("Сумма затрат на ЗП по отделу 3: " + EmployeeBook.calculateTotalSalaryByDepartment(3));
        System.out.println("Средняя ЗП по отделу 4: " + EmployeeBook.calculateAverageSalaryByDepartment(4));

        System.out.println("\nИндексация зарплат в отделе 5 на 15%:");
        EmployeeBook.indexSalariesByDepartment(5, 15);
        EmployeeBook.printEmployee();


        EmployeeBook.printEmployeesByDepartment(3);
        EmployeeBook.printEmployeesWithSalaryLessThan(100000);
        EmployeeBook.printEmployeesWithSalaryGreaterOrEqual(80000);

        System.out.println("\nСотрудник с id=5:");
        Employee employee = employeeBook.getEmployeeById(5);
        System.out.println(employee);

        // Удаляем сотрудника по id
        System.out.println("\nУдаляем сотрудника с id=3:");
        EmployeeBook.removeEmployee(3);
        EmployeeBook.printEmployee();
    }





}