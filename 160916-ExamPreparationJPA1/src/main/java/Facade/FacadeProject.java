package Facade;

import entity.Project;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class FacadeProject {
    
    EntityManagerFactory emf;

    public FacadeProject(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public Project addPerson(Project p) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }
    
        public Project getPerson(int id) {
        EntityManager em = emf.createEntityManager();

        Project p = null;

        try {
            em.getTransaction().begin();
            p = em.find(Project.class, id);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    public List<Project> getPersons() {
        EntityManager em = emf.createEntityManager();

        List<Project> persons = null;

        try {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        } finally {
            em.close();
        }
    }

    public Project deletePerson(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Project p = em.find(Project.class, id);
            em.remove(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }
}
