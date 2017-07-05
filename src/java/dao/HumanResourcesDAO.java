
package dao;

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

}
