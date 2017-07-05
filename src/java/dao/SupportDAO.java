
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

    public void removeSupport(int id) {
        em.remove(findSupport(id));
    }

    public Support findSupport(int id) {
        return  em.find(Support.class, id);
    }

    public List<Support> findAllSupport() {
        return em.createQuery("SELECT support FROM Support as support").getResultList();
    }

}
