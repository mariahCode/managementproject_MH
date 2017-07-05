package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import managementproject.Developer;

@Stateless
public class DeveloperDAO {

    @PersistenceContext
    private EntityManager em;

    public void createDeveloper(Developer developer) {
        em.persist(developer);
    }

    public void removeDeveloper(int id) {
        em.remove(findDeveloper(id));
    }

    public Developer findDeveloper(int id) {
        return  em.find(Developer.class, id);
    }

    public List<Developer> findAllDevelopers() {
        return em.createQuery("SELECT developer FROM Developer as developer").getResultList();
    }

}
