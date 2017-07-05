package managementproject;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by user on 2017-06-30.
 */
@Entity
@DiscriminatorValue("hr")
@Table(name="HUMANRESOURCES")
public class HumanResources extends Employee implements Serializable {
    
    private final float percentageExp = 50.0f;
    public float percentageHourMultiplier;
    private String workingField;
    public int hourFeeFieldMultiplication;

    private int hourFee = 500;
    private final int extraHourFree = 300;
    private final int normalWorkingHours = 38;

    public HumanResources() {} // Needed for all Java beans. 

    public HumanResources(String firstName, String lastName, int age, int experience, int workingHours, int gender, String workingField){
      super(firstName, lastName, age, 0, 0, experience, workingHours, gender);
      this.workingField = workingField;
      percentageHourMultiplier = experience / percentageExp;
    }

    @Override
    int calculateAndGetSalary() {

        switch (workingField) {
            case "Consultant":
                hourFeeFieldMultiplication = 2;
                break;
            case "Executive":
                hourFeeFieldMultiplication = 4;
                break;
            case "Education":
                hourFeeFieldMultiplication = 6;
                break;
            default:
                hourFeeFieldMultiplication = 0;
                break;
        }
            hourFee = hourFee * hourFeeFieldMultiplication;
            int expExtra = (int) ((super.getWorkingHours() * hourFee) * percentageHourMultiplier);
            int salary = (super.getWorkingHours()) * hourFee + expExtra;
            return salary;

    }

    @Override
    int calculateAndGetBonus() {
        return 0;
    }
    
    public String getWorkingField() {
        return workingField;
    }

    public void setWorkingField(String workingField) {
        this.workingField = workingField;
    }

}
