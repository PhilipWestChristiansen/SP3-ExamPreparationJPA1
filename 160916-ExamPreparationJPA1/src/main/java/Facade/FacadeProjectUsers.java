package Facade;

import entity.ProjectUsers;
import java.util.List;
import javax.persistence.*;

public class FacadeProjectUsers {

    EntityManagerFactory emf;

    public FacadeProjectUsers(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ProjectUsers addPerson(ProjectUsers p) {
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

    public ProjectUsers getPerson(int id) {
        EntityManager em = emf.createEntityManager();

        ProjectUsers p = null;

        try {
            em.getTransaction().begin();
            p = em.find(ProjectUsers.class, id);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    public List<ProjectUsers> getPersons() {
        EntityManager em = emf.createEntityManager();

        List<ProjectUsers> persons = null;

        try {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        } finally {
            em.close();
        }
    }

    public ProjectUsers deletePerson(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            ProjectUsers p = em.find(ProjectUsers.class, id);
            em.remove(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

}
