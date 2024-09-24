package nl.bioinf.nomi.admin;

import java.util.Date;
import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private Address address;
    private Role role;

    public Employee(String firstName, String lastName, Date birthDate, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public Role getRole() {
        return role;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(address, employee.address) && role == employee.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, role);
    }
}
