package fuctional.stream_api.processing_class_user;

import java.math.BigDecimal;

public class Manager extends Employee {
    public Manager() {
        setDepartment(Department.MANAGEMENT);
    }

    public Manager(Integer age, String name, String surname, Address address, BigDecimal salary) {
        super(age, name, surname, address, salary);
        setDepartment(Department.MANAGEMENT);
    }
}
