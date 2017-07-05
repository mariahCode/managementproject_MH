
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

    public List<Developer> findAll() {
        return em.createQuery("SELECT developer FROM Developer as developer").getResultList();
    }

}




