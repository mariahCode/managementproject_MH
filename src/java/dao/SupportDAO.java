
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import managementproject.HumanResources;
import managementproject.Support;

@Stateless
public class SupportDAO {
 
    @PersistenceContext
    private EntityManager em; 

    public void createSupport(Support support) {
        em.persist(support);
    }

    public List<Support> findAllSupport() {
        return em.createQuery("SELECT support FROM Support as support").getResultList();
    }

}
