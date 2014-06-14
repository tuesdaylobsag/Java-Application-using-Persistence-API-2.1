/**
 * This class uses Persistence API and allow the interaction with the data base
 * 
 */
package com.model;
import com.view.CoachTrip;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 * @author Ricardo Saumeth
 * @version 03/06/2014
 */
public class DBManager {
    //variables 
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;
    private CoachTrip ct;
    //this is a ref of the database in netbeans
    String ref = "coachtrip?zeroDateTimeBehavior=convertToNullPU";
    
    //used for inserts
    /**
     * Instantiate the object required for Persistence 
     */
    public DBManager() {
        
        emf = Persistence.createEntityManagerFactory(ref);
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    
//    used for update or delete
//    public DBManager(CoachTrip ct) {
//        emf = Persistence.createEntityManagerFactory(ref);
//        em = emf.createEntityManager();
//        tx = em.getTransaction();
//        this.ct = ct;
//    }
    
    /**
     * clean up all instances of this class
     */
    public void close() {
        em.close();
        emf.close();
    }
    /**
     * Add customer to the database
     * @param c This is an object of the class entity from database
     */
    public void createCustomer(CoachTrip c){
        tx.begin();
        em.persist(c);
        tx.commit();
    }
    
    
    
    /**
     * find a record by it's id
     */     
    public CoachTrip findById(int id) {
        CoachTrip ct = em.find(CoachTrip.class, id);
        return ct;
    }
    
    /**
     * delete this record
     */
    public void delete(CoachTrip ct) {
        em.getTransaction().begin();
        //this is a little weird as we have to find the object once again
        //before its deleted - required because the object has to be in
        //the same context - too complicated to explain fully here
        CoachTrip customer = findById(ct.getId());
        em.remove(customer);
        em.getTransaction().commit();
    }
    
    /**update this record
     * @param ct This is an object of the class CoachTrip 
     */
    public void update (CoachTrip ct) {
        CoachTrip customer = em.find(CoachTrip.class, ct.getId());
        em.getTransaction().begin();
        
        customer.setTripdestination(ct.getTripdestination());
        customer.setFirstname(ct.getFirstname());
        customer.setLastname(ct.getLastname());
        customer.setPhone(ct.getPhone());
        customer.setAdults(ct.getAdults());
        customer.setChildren(ct.getChildren());
        
        em.getTransaction().commit();
    }
}
