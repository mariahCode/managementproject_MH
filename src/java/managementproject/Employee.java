package managementproject;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Created by user on 2017-06-30.
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="EMPLOYEE_TYPE")
@Table(name="EMPLOYEE")
public abstract class Employee {
    
    private String firstName;
    private String lastName;
    private int age;
    private int salary;
    private int bonus;
    private int experience;
    private int workingHours;
    private int gender; // TODO Change into enum. See Bardia Donkey example!

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;     

    public Employee(String firstName, String lastName, int age, int salary, int bonus, int experience, int workingHours, int gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.bonus = bonus;
        this.experience = experience;
        this.workingHours = workingHours;
        this.gender = gender;
    }

    public Employee() {} // Needed for all Java beans.     

    //Abstract classes
    abstract int calculateAndGetSalary();
    abstract int calculateAndGetBonus();

    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getSalary(){
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getBonus() {
        return bonus;
    }
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getWorkingHours() {
        return workingHours;
    }
    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    
    public void setBasicSalary(int salary) {
        this.salary = salary;
    }

}
