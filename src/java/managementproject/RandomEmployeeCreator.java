package managementproject;

import java.util.Random;
import managementproject.Developer;
import managementproject.Employee;
//import managementproject.HumanResources;
//import managementproject.Support;

/**
 * Created by user on 2017-06-30.
 */
public class RandomEmployeeCreator {

    //0-9 Names
    String[] randomMaleNames;
    String[] randomFemaleNames;
    String[] randomLastNames;

    RandomEmployeeCreator(){
        randomMaleNames = new String[]{"Jonas", "Felix", "Jabbar", "Erik",
                "Lars", "Karl", "Anders", "Johan", "Per", "Nils"};
        randomFemaleNames = new String[]{ "Maria", "Anna","Margareta","Elisabeth",
                "Eva","Kristina","Birgitta","Karin","Marie","Ingrid" };
        randomLastNames = new String[]{ "Andersson", "Johansson","Karlsson","Nilsson","Eriksson",
                "Larsson","Persson","Svensson","Gustafsson","Hansson" };
    }

    Employee createRandomEmployee(){
        Random randomgenerator = new Random();
        int random= randomgenerator.nextInt(3) + 1;
        Employee randomGeneratedEmployee=null;

        if(random == 1){
            randomGeneratedEmployee = this.createRandomDeveloper(randomgenerator);
        }
//        if(random == 2){
//            randomGeneratedEmployee = this.createRandomSupport(randomgenerator);
//        }
//        if(random == 3){
//            randomGeneratedEmployee = this.createRandomHumanResources(randomgenerator);
//        }
        return randomGeneratedEmployee;
    }

    public Employee createRandomDeveloper(Random randomgenerator){
        //Generate random number
        String stringFirstName = new String();
        String stringLastName = new String();

        //Numbers to use and manipulate first and last name
        int firstNameRandom= randomgenerator.nextInt(10) + 1;
        int lastNameRandom= randomgenerator.nextInt(10) + 1;
        int genderRandom = randomgenerator.nextInt(2) + 1;

        if( genderRandom == 1){
            stringFirstName = this.getRandomFirstMaleName(firstNameRandom);
        }
        if( genderRandom == 2){
            stringFirstName = this.getRandomFirstMaleName(firstNameRandom);
        }
        stringLastName = this.getRandomLastName(lastNameRandom);

        //Numbers that need no modification
        int experienceRandom = randomgenerator.nextInt(30) + 1;
        int workingHoursRandom= randomgenerator.nextInt(50) + 20;
        int ageRandom = randomgenerator.nextInt(50) + 20;

        return new Developer(stringFirstName, stringLastName, ageRandom, experienceRandom,workingHoursRandom, 1);
             
    }

//    public Support createRandomSupport(Random randomgenerator){
//        //Generate random number
//        String stringFirstName = new String();
//        String stringLastName = new String();
//
//        //Numbers to use and manipulate first and last name
//        int firstNameRandom= randomgenerator.nextInt(10) + 1;
//        int lastNameRandom= randomgenerator.nextInt(10) + 1;
//        int genderRandom = randomgenerator.nextInt(2) + 1;
//
//        if( genderRandom == 1){
//            stringFirstName = this.getRandomFirstMaleName(firstNameRandom);
//        }
//        if( genderRandom == 2){
//            stringFirstName = this.getRandomFirstMaleName(firstNameRandom);
//        }
//        stringLastName = this.getRandomLastName(lastNameRandom);
//
//        //Numbers that need no modification
//        int experienceRandom = randomgenerator.nextInt(40) + 1;
//        int workingHoursRandom= randomgenerator.nextInt(50) + 20;
//        int ageRandom = randomgenerator.nextInt(60) + 20;
//        int randomNightHours = randomgenerator.nextInt(20) + 0;
//
//
//        return new Support(stringFirstName, stringLastName,experienceRandom,
//                workingHoursRandom,ageRandom,randomNightHours);
//    }
//
//    public Employee createRandomHumanResources(Random randomgenerator){
//        //Generate random number
//        String stringFirstName = new String();
//        String stringLastName = new String();
//        String stringField = new String();
//
//        //Numbers to use and manipulate first and last name
//        int firstNameRandom= randomgenerator.nextInt(10) + 1;
//        int lastNameRandom= randomgenerator.nextInt(10) + 1;
//        int genderRandom = randomgenerator.nextInt(2) + 1;
//
//        if( genderRandom == 1){
//            stringFirstName = this.getRandomFirstMaleName(firstNameRandom);
//        }
//        if( genderRandom == 2){
//            stringFirstName = this.getRandomFirstMaleName(firstNameRandom);
//        }
//        stringLastName = this.getRandomLastName(lastNameRandom);
//
//        int fieldRandom = randomgenerator.nextInt(3) + 1;
//
//        if( fieldRandom == 1){
//            stringField = "Consultant";
//        }
//        if( fieldRandom == 2){
//            stringField = "Executive";
//        }
//        if( fieldRandom == 3){
//            stringField = "Education";
//    }
//
//
//        //Numbers that need no modification
//        int experienceRandom = randomgenerator.nextInt(30) + 1;
//        int workingHoursRandom= randomgenerator.nextInt(50) + 20;
//        int ageRandom = randomgenerator.nextInt(50) + 20;
//        int randomNightHours = randomgenerator.nextInt(20) + 0;
//
//        return new HumanResources(stringFirstName, stringLastName,experienceRandom,
//                workingHoursRandom,ageRandom,stringField);
//    }

    public String getRandomFirstMaleName(int maleNumbers) {
      return this.randomMaleNames[maleNumbers-1];
    }
    public String getRandomFirstFemaleName(int femaleNumbers) {
        return this.randomMaleNames[femaleNumbers-1];
    }

    public String getRandomLastName(int lastNumbers) {
        return this.randomLastNames[lastNumbers-1];
    }
}
