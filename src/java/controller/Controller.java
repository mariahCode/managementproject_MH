
package controller;

import dao.DeveloperDAO;
import dao.HumanResourcesDAO;
import dao.SupportDAO;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import managementproject.Developer;
import managementproject.HumanResources;
import managementproject.Support;

//@Named(value = "controller") // So we can reach it on JFS pages. 
@Named
@RequestScoped
public class Controller {

    @Inject
    private DeveloperDAO developerDao; 
    @Inject
    private HumanResourcesDAO hrDao; 
    @Inject
    private SupportDAO supportDao; 

    public Controller() {
    }

    private String firstName; 
    private String lastName; 
    private int experience; 
    private int workingHours; 
    private int age; 
    
    private String workingField;
    
    private int nightHours; 

    private List<Developer> developerList; 

    public void submitDeveloper() {
        Developer developer = new Developer(); 
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setExperience(experience);
        developer.setWorkingHours(workingHours);
        developer.setAge(age);
       developerDao.createDeveloper(developer);
    }

    public void submitHR() {
        HumanResources hr = new HumanResources(); 
        hr.setFirstName(firstName);
        hr.setLastName(lastName);
        hr.setExperience(experience);
        hr.setWorkingHours(workingHours);
        hr.setAge(age);
        hr.setWorkingField(workingField);
        hrDao.createHR(hr);
    }

    public void submitSupport() {
        Support support = new Support(); 
        support.setFirstName(firstName);
        support.setLastName(lastName);
        support.setExperience(experience);
        support.setWorkingHours(workingHours);
        support.setAge(age);
        support.setNightHours(nightHours);
        supportDao.createSupport(support);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkingField() {
        return workingField;
    }

    public void setWorkingField(String workingField) {
        this.workingField = workingField;
    }
    
    public List<Developer> getDeveloperList() {
        return developerDao.findAll();
    }

    public void setDeveloperList(List<Developer> developerList) {
        this.developerList = developerList;
    }
    

}
