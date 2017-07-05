package managementproject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Felix on 2017-06-30.
 * Complete. Maybe
 */
@Entity
@DiscriminatorValue("sup")
@Table(name="SUPPORT")
public class Support extends Employee {
    
    public float percentageHourMultiplier;
    public int nightHours;
    private final float percentageExp = 200.0f;
    private final int hourFee = 250;
    private final int extraHourFree = 300;
    private final int normalWorkingHours = 40;

    public Support() {} // Needed for all Java beans. 

    public Support(String firstName, String lastName, int age, int experience, int workingHours, int gender, int nigtHours){
        super(firstName, lastName, age, 0, 0, experience, workingHours, gender);
        this.nightHours = nigtHours;
        percentageHourMultiplier = experience / percentageExp;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Support other = (Support) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    int calculateAndGetSalary() {
        int expExtra = (int) ((super.getWorkingHours() * hourFee)*percentageHourMultiplier);
        int salary = (super.getWorkingHours() - nightHours) * hourFee + expExtra +((int) (nightHours*hourFee*1.5));
        return salary;
    }

    @Override
    int calculateAndGetBonus() {
        if(super.getWorkingHours() > normalWorkingHours){
            super.setBonus((normalWorkingHours - super.getWorkingHours() )*extraHourFree);
            return (normalWorkingHours - super.getWorkingHours() )*extraHourFree;
        }
        else{
            return 0;
        }
    }
    
    public int getNightHours() {
        return nightHours;
    }
    public void setNightHours(int nightHours) {
        this.nightHours = nightHours;
    }

}
