/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d007njavaprojuppg.control;

import d007njavaprojuppg.model.ArendeEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;

/**
 *
 * @author P
 */
public class ArendeMngr {
    public String addArendeToDb(ArendeEntity ae) throws Exception, RollbackException{
        String status = "failure";
        //specificera uppkoppling mot db: info finns i filen persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("D007NJavaProjUppgPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //skapa ny post i db via entitymanager
        em.persist(ae);
        em.getTransaction().commit();
        //om transaktionen lyckats, ändra status till success 
        status = "success";
        
        em.close();
        emf.close();
       
        return status;
    } 
public String delArendeFromDb(String refnr) throws Exception{
        String status = "failure";
        //specificera uppkoppling mot db: info finns i filen persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("D007NJavaProjUppgPU");
      
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Hitta rätt student i db studid=ideal och returnera som entity-objekt
        ArendeEntity ae = em.find(ArendeEntity.class, refnr);
        //ta bort post i db via entitymanager
        em.remove(ae);
        em.getTransaction().commit();
        //om vi når hit gick det bra...
        status = "success";
        
        em.close();
        emf.close();
       
        return status;
    } 
public List<ArendeEntity> getArendeInDb() throws Exception{
        //specificera uppkoppling mot db: info finns i filen persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("D007NJavaProjUppgPU");
      
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("ArendeEntity.findAll");
        List<ArendeEntity> list = query.getResultList();
        
        em.close();
        emf.close();
       
        return list;
    } 
public ArendeEntity getArendeInDb(int refNr) throws Exception{
        //specificera uppkoppling mot db: info finns i filen persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("D007NJavaProjUppgPU");
      
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("ArendeEntity.findByReferensnummer").setParameter("referensnummer", refNr);
        ArendeEntity ae = em.find(ArendeEntity.class, refNr);
        
        em.close();
        emf.close();
       
        return ae;
    } 

    public String updArendeStatus(ArendeEntity arende)throws Exception, RollbackException{
       String status = "failure";
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("D007NJavaProjUppgPU");
       EntityManager em = emf.createEntityManager();
       ArendeEntity ar = em.find(ArendeEntity.class, arende.getReferensnummer());
       em.getTransaction().begin();
       ar.setArbetsstatus("avslutad");
       
       em.getTransaction().commit();
       
               status = "success";
        
        em.close();
        emf.close();
       
        return status;
    }
}
