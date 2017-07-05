
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import managementproject.Developer;
import managementproject.HumanResources;

@Stateless
public class HumanResourcesDAO {

    @PersistenceContext
    private EntityManager em; 

    public void createHR(HumanResources hr) {
        em.persist(hr);
    }

    public List<HumanResources> findAllHr() {
        return em.createQuery("SELECT hr FROM HumanResources as hr").getResultList();
    }

}
