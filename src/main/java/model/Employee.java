package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by Administrateur on 04/03/2015.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends Person {
    private String entrprise;
    private int salary;

    public String getEntrprise() {
        return entrprise;
    }

    public void setEntrprise(String entrprise) {
        this.entrprise = entrprise;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public Employee(String name, int age, String address, String entrprise, int salary) {
        super(name, age, address, null);
        this.entrprise = entrprise;
        this.salary = salary;
    }
}
