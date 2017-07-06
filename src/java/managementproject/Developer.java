package managementproject;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Felix on 2017-06-30.
 * Complete. Maybe
 */

@Entity
@DiscriminatorValue("dev")
@Table(name="DEVELOPER")
public class Developer extends Employee implements Serializable {
    
    private final float percentageExp = 100.0f;
    private float percentageHourMultiplier;
    private final int hourFee = 1250;
    private final int extraHourFree = 1500;
    private final int normalWorkingHours = 35;

    public Developer() {} // Needed for all Java beans. 

    public Developer(String firstName, String lastName, int age, int experience, int workingHours, int gender){
      super(firstName, lastName, age, 0, 0, experience, workingHours, gender);
      percentageHourMultiplier = experience / percentageExp;
    }

    public float getPercentageHourMultiplier() {
        return percentageHourMultiplier;
    }
    
    public float calculatePercentageMultiplier(int experience){
       return percentageHourMultiplier = experience / percentageExp;
    }
    
    public void setPercentageHourMultiplier(float percentageHourMultiplier) {
        this.percentageHourMultiplier = percentageHourMultiplier;
    }

    @Override
    public int calculateAndGetSalary() {
        int expExtra = (int) ((super.getWorkingHours() * hourFee)*percentageHourMultiplier);
        int salary = super.getWorkingHours() * hourFee + expExtra;
        return salary;
    }

    @Override
    public int calculateAndGetBonus() {
        if(super.getWorkingHours() > normalWorkingHours){
            super.setBonus((normalWorkingHours - super.getWorkingHours() ) * extraHourFree);
            return (normalWorkingHours-super.getWorkingHours() )*extraHourFree;
        }
        else{
            return 0;
        }
    }
}
