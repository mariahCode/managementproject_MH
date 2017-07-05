package managementproject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by user on 2017-06-30.
 */
public class Main{
    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
    static EntityManager em = emf.createEntityManager();

    
    public static void main(String args[] ) {
        int i=0;
        while(i<10){
            RandomEmployeeCreator randEmpCreator = new RandomEmployeeCreator();
            Employee randEmp = randEmpCreator.createRandomEmployee();
//            System.out.println("Emp: First name " +randEmp.firstName +" Lastname " +randEmp.lastName
//                    +" Age: " +randEmp.age +" Type " +randEmp.getClass() +" Experience " +randEmp.experience);
//            System.out.println("SALARY FOR EMPLOYYEE BEFORE :" +randEmp.calculateAndGetSalary());
            i++;

        }
    }
}
