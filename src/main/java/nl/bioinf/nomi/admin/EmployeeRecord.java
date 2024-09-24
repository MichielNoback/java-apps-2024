package nl.bioinf.nomi.admin;

import java.util.Date;

public record EmployeeRecord(String firstName, String lastName, Role role, Address address) {
    //getters
    //all-arg constructor
    //equals + hashCode
    //toString

    //COMPILER-GENERATED

    public String printEmployeeNice() {
        return "";
    }



}
