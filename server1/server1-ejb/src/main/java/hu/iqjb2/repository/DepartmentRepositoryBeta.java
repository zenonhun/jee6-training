/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2.repository;

import hu.iqjb2.domain.model.Department;
import interceptor.LoggingTimeInterceptor;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author IQJB
 */
@Stateless
@LocalBean
public class DepartmentRepositoryBeta {

    @PersistenceContext(unitName = "iqjb2bPU")
    private EntityManager em;

    @Interceptors(LoggingTimeInterceptor.class)
    public void add(Department department) {
        em.persist(department);
    }

    @Interceptors(LoggingTimeInterceptor.class)
    public List<Department> getAll() {
        return em.createQuery("SELECT d FROM Department d", Department.class).getResultList();
    }
}
