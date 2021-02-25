package fuctional.stream_api.processing_class_user;

import java.math.BigDecimal;

public abstract class Employee {
    private Integer id;
    private int age;
    private String name;
    private String surname;
    private Address address;
    private BigDecimal salary;
    private Department department;
    static int idCounter;

    public Employee() {
        this.id = ++idCounter;
    }

    public Employee(Integer age, String name, String surname, Address address, BigDecimal salary) {
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.salary = salary;
        this.id = ++idCounter;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!id.equals(employee.id)) return false;
        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\nprocessing_class_user.Employee{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name +
                ", surname='" + surname +
                ", salary=" + salary +
                ", department=" + department +
                ", address=" + address +
                '}';
    }
}
