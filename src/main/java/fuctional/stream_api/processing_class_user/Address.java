package fuctional.stream_api.processing_class_user;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private int building;
    private int flat;

    public Address() {
    }

    public Address(String city, String street, int building, int flat) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.flat = flat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return building == address.building &&
                flat == address.flat &&
                city.equals(address.city) &&
                street.equals(address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, building, flat);
    }

    @Override
    public String toString() {
        return "\nprocessing_class_user.Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building=" + building +
                ", flat=" + flat +
                "\n_________________________________________________________" +
                '}';
    }
}
