
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

    public DeveloperDAO getDeveloperDao() {
        return developerDao;
    }

    public void setDeveloperDao(DeveloperDAO developerDao) {
        this.developerDao = developerDao;
    }
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
    private List<HumanResources> hrList; 
    private List<Support> supportList;
    
    private int removeId; 

    private int employeeId;     
    private Developer developer; 
    private HumanResources humanResources; 
    private Support support; 

    public String submitDeveloper() {
        Developer developer = new Developer(); 
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setExperience(experience);
        developer.setWorkingHours(workingHours);
        developer.setAge(age);
        developer.setPercentageHourMultiplier(developer.calculatePercentageMultiplier(experience));
        developer.setSalary(developer.calculateAndGetSalary());
        developer.setBonus(developer.calculateAndGetBonus());
        developerDao.createDeveloper(developer);
        return "added";
    }

    public String submitHR() {
        HumanResources hr = new HumanResources(); 
        hr.setFirstName(firstName);
        hr.setLastName(lastName);
        hr.setExperience(experience);
        hr.setWorkingHours(workingHours);
        hr.setAge(age);
        hr.setWorkingField(workingField);
        hr.setPercentageHourMultiplier(hr.calculatePercentageMultiplier(experience));
        hr.setSalary(hr.calculateAndGetSalary());
        hr.setBonus(hr.calculateAndGetBonus());
        hrDao.createHR(hr);
        return "added";
    }

    public String submitSupport() {
        Support support = new Support(); 
        support.setFirstName(firstName);
        support.setLastName(lastName);
        support.setExperience(experience);
        support.setWorkingHours(workingHours);
        support.setAge(age);
        support.setNightHours(nightHours);
        support.setPercentageHourMultiplier(support.calculatePercentageMultiplier(experience));
        support.setSalary(support.calculateAndGetSalary());
        support.setBonus(support.calculateAndGetBonus());
        supportDao.createSupport(support);
        return "added";
    }


    // TODO: Add error handling: If id is not existing in db. 
    public String removeEmployee() {
        
        if (developerDao.findDeveloper(removeId) != null){
            developerDao.removeDeveloper(removeId);
        }
        if (hrDao.findHR(removeId) != null){
            hrDao.removeHR(removeId);
        }
        if (supportDao.findSupport(removeId) != null){
            supportDao.removeSupport(removeId);
        }
        return "removed";
    }
    public String removeDeveloper() {
        developerDao.removeDeveloper(removeId);
        return "removed";
    }
    public String removeHR() {
        hrDao.removeHR(removeId);
        return "removed";
    }
    public String removeSupport() {
        supportDao.removeSupport(removeId);
        return "removed";
    }

    public String showOneEmployee() {
        
        if (developerDao.findDeveloper(employeeId) != null){
            return this.showOneDeveloper();
        }
        if (hrDao.findHR(employeeId) != null){
            return this.showOneHR();
        }
        if (supportDao.findSupport(employeeId) != null){
            return this.showOneSupport();
        }
        return "index"; 
    }
    public String showOneDeveloper() {
        developer = developerDao.findDeveloper(employeeId);
        return "showOneDeveloper"; 
    }
    public String showOneHR() {
        humanResources = hrDao.findHR(employeeId);
        return "showOneHR"; 
    }

    public HumanResources getHumanResources() {
        return humanResources;
    }

    public void setHumanResources(HumanResources humanResources) {
        this.humanResources = humanResources;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
    public String showOneSupport() {
        support = supportDao.findSupport(employeeId);
        return "showOneSupport"; 
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
            
    public String findAll() {
        developerList = developerDao.findAllDevelopers();
        hrList = hrDao.findAllHr();
        supportList = supportDao.findAllSupport();        
        return "allEmployees";
    }
        
    
    // Getters and setters. 
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
    
    public int getNightHours() {
        return nightHours;
    }
    public void setNightHours(int nightHours) {
        this.nightHours = nightHours;
    }

    public List<Developer> getDeveloperList() {
        return developerDao.findAllDevelopers();
    }
    public void setDeveloperList(List<Developer> developerList) {
        this.developerList = developerList;
    }
    public List<HumanResources> getHrList() {
        return hrDao.findAllHr();
    }
    public void setHrList(List<HumanResources> hrList) {
        this.hrList = hrList;
    }
    public List<Support> getSupportList() {
        return supportDao.findAllSupport();
    }

    public void setSupportList(List<Support> supportList) {
        this.supportList = supportList;
    }

    public int getRemoveId() {
        return removeId;
    }
    public void setRemoveId(int removeId) {
        this.removeId = removeId;
    }

}
