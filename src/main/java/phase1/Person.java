package phase1;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrateur on 03/03/2015.
 */
@Entity
@Table
public class Person implements Comparable,Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String address;

    public Person() {
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o.getClass().equals(this.getClass())){
            Person p = (Person) o;
            if(p.getAge()>this.getAge())
                return -1;
            else if (p.getAge()<this.getAge())
                    return 1;
        }
        return 0;

    }
}
