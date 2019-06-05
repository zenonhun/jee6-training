/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2;

import hu.iqjb2.domain.model.Department;
import hu.iqjb2.remote.intf.DepartmentServiceInterface;
import hu.iqjb2.repository.DepartmentRepositoryAlpha;
import hu.iqjb2.repository.DepartmentRepositoryBeta;
import interceptor.LoggingTimeInterceptor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 * @author IQJB
 */
@Stateless
@LocalBean
@Remote(DepartmentServiceInterface.class)
public class DepartmentService implements DepartmentServiceInterface {

    @EJB
    private DepartmentRepositoryBeta dBeta;
    @EJB
    private DepartmentRepositoryAlpha dAlpha;

    @Interceptors(LoggingTimeInterceptor.class)
    @Override
    public void add(Department department) {
        dAlpha.add(department);
        dBeta.add(department);
    }

    @Interceptors(LoggingTimeInterceptor.class)
    @Override
    public List<Department> getAll() {
        List<Department> da = dAlpha.getAll();
        da.addAll(dBeta.getAll());
        return da;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
