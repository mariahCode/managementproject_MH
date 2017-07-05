
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import managementproject.Support;

@Stateless
public class SupportDAO {
 
    @PersistenceContext
    private EntityManager em; 

    public void createSupport(Support support) {
        em.persist(support);
    }

}
