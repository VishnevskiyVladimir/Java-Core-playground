package fuctional.stream_api.processing_class_user;

import java.math.BigDecimal;


public class ItSpecialist extends Employee {

    public ItSpecialist() {
        setDepartment(Department.IT);
    }

    public ItSpecialist(Integer age, String name, String surname, Address address, BigDecimal salary) {
        super(age, name, surname, address, salary);
        setDepartment(Department.IT);
    }
}
