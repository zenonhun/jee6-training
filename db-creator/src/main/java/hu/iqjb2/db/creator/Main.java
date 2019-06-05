/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2.db.creator;

import hu.iqjb2.domain.model.Address;
import hu.iqjb2.domain.model.Department;
import hu.iqjb2.domain.model.Employee;
import hu.iqjb2.domain.model.IqjbLog;
import hu.iqjb2.domain.model.Project;
import hu.iqjb2.domain.model.Role;
import hu.iqjb2.domain.model.Task;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author IQJB
 */
public class Main {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("iqjb2aPU");
    private static final EntityManagerFactory FACTORY2 = Persistence.createEntityManagerFactory("iqjb2bPU");
    private static final EntityManagerFactory FACTORYLOG = Persistence.createEntityManagerFactory("iqjbLoggerPU");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee e1 = new Employee("Főni", "Shepard", new Address("E///", "BP", "Valahol"));
        Employee e2 = new Employee("Gino", "G", new Address("Városliget", "BPalso", "Felvonulási tér"));
        Employee e3 = new Employee("xx", "x", new Address("Városliget", "BPalso", "Felvonulási tér"));

        Department deparmentHQ = new Department("HQ");
        Department deparmentEri = new Department("E///");
        e1.setDepartment(deparmentHQ);
        e2.setDepartment(deparmentEri);

        Role adminRole = new Role("admin");
        Role userRole = new Role("userRole");

        e1.setRoles(Arrays.asList(adminRole, userRole));
        e2.setRoles(Arrays.asList(userRole));
        e2.setBoss(e1);
        e3.setBoss(e1);

        Project mainProject = new Project("Main Project", new Date(2019, 1, 1), new Date(2019, 7, 8), e1);
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tasks.add(new Task("Task1 " + i, e2));
        }
        for (int i = 0; i < 5; i++) {
            tasks.add(new Task("Task2 " + i, e1));
        }
        mainProject.setTasks(tasks);

        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(e1);
        em.persist(e2);
        em.persist(e2);
        em.persist(adminRole);
        em.persist(userRole);
        em.persist(mainProject);
        //tasks.forEach(t -> em.persist(t));
        em.persist(deparmentEri);
        em.persist(deparmentHQ);
        tx.commit();

        EntityManager em2 = FACTORY2.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();
        tx2.begin();
        em2.persist(e1);
        em2.persist(e2);
        em2.persist(e2);
        em2.persist(adminRole);
        em2.persist(userRole);
        em2.persist(mainProject);
        //tasks.forEach(t -> em.persist(t));
        em2.persist(deparmentEri);
        em2.persist(deparmentHQ);
        tx2.commit();

        EntityManager em3 = FACTORYLOG.createEntityManager();
        EntityTransaction tx3 = em3.getTransaction();
        tx3.begin();
        IqjbLog log = new IqjbLog("testFunc", 123L, "MEE");
        em3.persist(log);
        tx3.commit();

        em.createQuery("select e from Employee e", Employee.class)
                .getResultList()
                .forEach(e -> {
                    System.out.println(e.getFirstName());
                    if (e.getBoss() != null) {
                        System.out.println("Boss: " + e.getBoss().getFirstName());
                    }
                    e.getRoles().forEach(r -> System.out.println(r.getName()));
                });
        /*
        em.createQuery("select t from Task t", Task.class)
                .getResultList()
                .forEach(t -> {
                    System.out.println(t.getName());
                    System.out.println(t.getPaticipant().getFirstName());
                });
         */
        FACTORY.close();
    }

}
