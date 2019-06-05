/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2.repository;

import hu.iqjb2.domain.model.IqjbLog;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author IQJB
 */
@Stateless
@LocalBean
public class LoggingRepository {

    @PersistenceContext(unitName = "iqjbLoggerPU")
    private EntityManager em;

    public void add(IqjbLog log) {
        em.persist(log);
    }

    public List<IqjbLog> getLogs() {
        return em.createQuery("SELECT l FROM IqjbLog l", IqjbLog.class).getResultList();
    }

}
