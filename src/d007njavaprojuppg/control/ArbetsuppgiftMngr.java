/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d007njavaprojuppg.control;

import d007njavaprojuppg.model.ArbetsuppgiftEntity;
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
public class ArbetsuppgiftMngr {
    public String addArbUppgToDb(ArbetsuppgiftEntity aue) throws Exception, RollbackException{
        String status = "failure";
        //specificera uppkoppling mot db: info finns i filen persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("D007NJavaProjUppgPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //skapa ny post i db via entitymanager
        em.persist(aue);
        em.getTransaction().commit();
        //om vi når hit gick det bra...
        status = "success";
        
        em.close();
        emf.close();
       
        return status;
    } 
public String delArbUppgFromDb(Integer refnr) throws Exception{
        String status = "failure";
        //specificera uppkoppling mot db: info finns i filen persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("D007NJavaProjUppgPU");
      
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Hitta rätt arbetsuppgift i db och returnera som entity-objekt
        ArbetsuppgiftEntity aue = em.find(ArbetsuppgiftEntity.class, refnr);
        //ta bort post i db via entitymanager
        em.remove(aue);
        em.getTransaction().commit();
        //om vi når hit gick det bra...
        status = "success";
        
        em.close();
        emf.close();
       
        return status;
    } 
public List<ArbetsuppgiftEntity> getArbetsuppgiftInDb() throws Exception{
        //specificera uppkoppling mot db: info finns i filen persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("D007NJavaProjUppgPU");
      
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("ArbetsuppgiftEntity.findAll");
        List<ArbetsuppgiftEntity> list = query.getResultList();
        
        em.close();
        emf.close();
       
        return list;
    } 
    public List<ArbetsuppgiftEntity> getArbetsuppgiftInDb(Integer refNr) {
       //specificera uppkoppling mot db: info finns i filen persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("D007NJavaProjUppgPU");
       
        EntityManager em = emf.createEntityManager();
        //Query query = em.createNamedQuery("StudentEntity.findAll");
        Query query = em.createNamedQuery("ArbetsuppgiftEntity.findByReferensnummer").setParameter("referensnummer", refNr);
        List<ArbetsuppgiftEntity> list = query.getResultList();
        em.close();
        emf.close();
       
        return list;    }
}
