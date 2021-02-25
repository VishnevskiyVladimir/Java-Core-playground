package fuctional.stream_api.problems;

import java.util.*;

class EmployeesCounter {

    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     */

    static List<Employee> empItList = new ArrayList<>();
    static List<Employee> empQAList = new ArrayList<>();
    static List<Department> depList = new ArrayList<>();
    static {
        empItList.add(new Employee("JohnIT", 30000L));
        empItList.add(new Employee("AnnIT", 20000L));
        empItList.add(new Employee("MaryIT", 40000L));
        empItList.add(new Employee("SamIT", 10000L));
        empItList.add(new Employee("KateIT", 50000L));

        empQAList.add(new Employee("JohnQA", 30000L));
        empQAList.add(new Employee("AnnQA", 20000L));
        empQAList.add(new Employee("MaryQA", 40000L));
        empQAList.add(new Employee("SamQA", 10000L));
        empQAList.add(new Employee("KateQA", 50000L));

        depList.add(new Department("IT", "111-2",empItList));
        depList.add(new Department("QA", "112-2",empQAList));

    }
    public static void main(String[] args) {
        System.out.println(calcNumberOfEmployees(depList,20000));
    }

    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream()
                .filter(department -> department.getCode().startsWith("111-"))
                .peek(System.out::println)
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= threshold)
                .peek(System.out::println)
                .count();
    }

    static class Employee {
        private final String name;
        private final Long salary;

        Employee(String name, Long salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public Long getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    static class Department {
        private final String name;
        private final String code;
        private final List<Employee> employees;

        Department(String name, String code, List<Employee> employees) {
            this.name = name;
            this.code = code;
            this.employees = employees;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    ", employees=" + employees +
                    '}';
        }
    }
}