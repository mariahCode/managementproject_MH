
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import managementproject.HumanResources;

@Stateless
public class HumanResourcesDAO {

    @PersistenceContext
    private EntityManager em; 

    public void createHR(HumanResources hr) {
        em.persist(hr);
    }

    public void removeHR(int id) {
        em.remove(findHR(id));
    }

    public HumanResources findHR(int id) {
        return  em.find(HumanResources.class, id);
    }

    public List<HumanResources> findAllHr() {
        return em.createQuery("SELECT hr FROM HumanResources as hr").getResultList();
    }

}
